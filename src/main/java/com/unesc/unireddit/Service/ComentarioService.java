package com.unesc.unireddit.Service;

import com.unesc.unireddit.DTO.ComentarioDTO;
import com.unesc.unireddit.DTO.ComentarioResponseDTO;
import com.unesc.unireddit.Model.ComentarioModel;
import com.unesc.unireddit.Repository.ComentarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComentarioService {

    private final ComentarioRepository comentarioRepository;

    public ComentarioService(ComentarioRepository comentarioRepository) {
        this.comentarioRepository = comentarioRepository;
    }

    // Criação de comentário
    public ComentarioResponseDTO criarComentario(ComentarioDTO dto) {
        ComentarioModel comentario = new ComentarioModel();
        comentario.setConteudo(dto.getConteudo());
        comentarioRepository.save(comentario);

        ComentarioResponseDTO resp = new ComentarioResponseDTO();
        resp.setId(comentario.getId());
        resp.setConteudo(comentario.getConteudo());
        resp.setCreateAt(comentario.getCreateAt());
        return resp;
    }

    // Listar comentários de uma postagem
    public List<ComentarioResponseDTO> listarPorPostagem(Long postagemId) {
        List<ComentarioModel> comentarios = comentarioRepository.findByPostagemId(postagemId);
        return comentarios.stream().filter(c -> c.getParent() == null)
                .map(this::converterParaDTOComSubRespostas)
                .collect(Collectors.toList());
    }

    // Buscar árvore completa de respostas (recursivamente)
    public List<ComentarioResponseDTO> listarRespostas(Long comentarioId) {
        List<ComentarioModel> respostas = comentarioRepository.findByParentId(comentarioId);
        return respostas.stream()
                .map(this::converterParaDTOComSubRespostas)
                .collect(Collectors.toList());
    }

    // Conversão com recursão de sub-respostas
    private ComentarioResponseDTO converterParaDTOComSubRespostas(ComentarioModel c) {
        ComentarioResponseDTO dto = new ComentarioResponseDTO();
        dto.setId(c.getId());
        dto.setConteudo(c.getConteudo());
        dto.setCreateAt(c.getCreateAt());
        dto.setParentId(c.getParent() != null ? c.getParent().getId() : null);
        dto.setUsuarioId(c.getUsuario() != null ? c.getUsuario().getId() : null);

        // Recursão: busca todas as respostas desse comentário
        List<ComentarioResponseDTO> subRespostas = comentarioRepository.findByParentId(c.getId())
                .stream()
                .map(this::converterParaDTOComSubRespostas)
                .collect(Collectors.toList());

        dto.setSubRespostas(subRespostas);
        return dto;
    }

    // Deletar comentário
    public void deletarComentario(Long id) {
        comentarioRepository.deleteById(id);
    }
}
