package com.unesc.unireddit.Service;

import com.unesc.unireddit.DTO.ComentarioDTO;
import com.unesc.unireddit.DTO.ComentarioResponseDTO;
import com.unesc.unireddit.Model.ComentarioModel;
import com.unesc.unireddit.Model.PostagemModel;
import com.unesc.unireddit.Model.UsuarioModel;
import com.unesc.unireddit.Repository.ComentarioRepository;
import com.unesc.unireddit.Repository.PostagemRepository;
import com.unesc.unireddit.Repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;
    private final PostagemRepository postagemRepository;
    private final UsuarioRepository usuarioRepository;

    public ComentarioService(
            ComentarioRepository comentarioRepository,
            PostagemRepository postagemRepository,
            UsuarioRepository usuarioRepository
    ) {
        this.comentarioRepository = comentarioRepository;
        this.postagemRepository = postagemRepository;
        this.usuarioRepository = usuarioRepository;
    }

    // Criar novo comentário
    public ComentarioResponseDTO criarComentario(ComentarioDTO dto) {

        ComentarioModel comentario = new ComentarioModel();
        comentario.setConteudo(dto.getConteudo());

        // Vincular postagem
        PostagemModel postagem = postagemRepository.findById(dto.getPostagemId())
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada."));
        comentario.setPostagem(postagem);

        // Vincular usuário
        UsuarioModel usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado."));
        comentario.setUsuario(usuario);

        // Se for resposta
        if (dto.getParentId() != null) {
            ComentarioModel parent = comentarioRepository.findById(dto.getParentId())
                    .orElseThrow(() -> new RuntimeException("Comentário pai não encontrado."));
            comentario.setParent(parent);
        }

        comentarioRepository.save(comentario);

        ComentarioResponseDTO resp = new ComentarioResponseDTO();
        resp.setId(comentario.getId());
        resp.setConteudo(comentario.getConteudo());
        resp.setCreateAt(comentario.getCreateAt());
        resp.setParentId(dto.getParentId());
        resp.setUsuarioId(usuario.getId());
        resp.setSubRespostas(List.of()); // nenhuma resposta ao criar

        return resp;
    }

    // UPDATE DE COMENTÁRIO
    public ComentarioResponseDTO atualizarComentario(Long id, ComentarioDTO dto) {

        ComentarioModel comentario = comentarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado."));

        // Atualizar apenas o conteúdo
        comentario.setConteudo(dto.getConteudo());

        comentarioRepository.save(comentario);

        // Converter para DTO
        return converterParaDTOComSubRespostas(comentario);
    }

    // Listar comentários raiz por postagem
    public List<ComentarioResponseDTO> listarPorPostagem(Long postagemId) {
        List<ComentarioModel> comentarios = comentarioRepository.findByPostagemId(postagemId);

        return comentarios.stream()
                .filter(c -> c.getParent() == null)
                .map(this::converterParaDTOComSubRespostas)
                .collect(Collectors.toList());
    }

    // Listar respostas de um comentário
    public List<ComentarioResponseDTO> listarRespostas(Long comentarioId) {
        return comentarioRepository.findByParentId(comentarioId)
                .stream()
                .map(this::converterParaDTOComSubRespostas)
                .collect(Collectors.toList());
    }

    // Converter modelo ResponseDTO
    private ComentarioResponseDTO converterParaDTOComSubRespostas(ComentarioModel c) {

        ComentarioResponseDTO dto = new ComentarioResponseDTO();
        dto.setId(c.getId());
        dto.setConteudo(c.getConteudo());
        dto.setCreateAt(c.getCreateAt());
        dto.setParentId(c.getParent() != null ? c.getParent().getId() : null);
        dto.setUsuarioId(c.getUsuario() != null ? c.getUsuario().getId() : null);

        List<ComentarioResponseDTO> subRespostas = comentarioRepository.findByParentId(c.getId())
                .stream()
                .map(this::converterParaDTOComSubRespostas)
                .collect(Collectors.toList());

        dto.setSubRespostas(subRespostas);

        return dto;
    }

    // Delete com cascata
    public void deletarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
