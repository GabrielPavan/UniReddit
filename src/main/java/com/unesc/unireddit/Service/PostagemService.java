package com.unesc.unireddit.Service;

import com.unesc.unireddit.DTO.PostagemDTO;
import com.unesc.unireddit.DTO.PostagemResponseDTO;
import com.unesc.unireddit.Model.PostagemModel;
import com.unesc.unireddit.Repository.PostagemRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostagemService {

    private final PostagemRepository postagemRepository;

    public PostagemService(PostagemRepository postagemRepository) {
        this.postagemRepository = postagemRepository;
    }

    // Criar postagem
    public PostagemResponseDTO criar(PostagemDTO dto) {
        PostagemModel p = new PostagemModel();
        p.setTitulo(dto.getTitulo());
        p.setConteudo(dto.getConteudo());
        p.setComunidadeId(dto.getComunidadeId());
        p.setAutorId(dto.getAutorId());
        p.setCriadaEm(Instant.now());
        p.setAtualizadaEm(Instant.now());

        postagemRepository.save(p);
        return converter(p);
    }

    // Buscar por ID
    public PostagemResponseDTO buscarPorId(Long id) {
        return postagemRepository.findById(id)
                .map(this::converter)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));
    }

    // Listar todas
    public List<PostagemResponseDTO> listar() {
        return postagemRepository.findAll().stream()
                .map(this::converter)
                .collect(Collectors.toList());
    }

    // Listar por comunidade
    public List<PostagemResponseDTO> listarPorComunidade(Long comunidadeId) {
        return postagemRepository.findByComunidadeId(comunidadeId)
                .stream().map(this::converter).collect(Collectors.toList());
    }

    // Atualizar
    public PostagemResponseDTO atualizar(Long id, PostagemDTO dto) {
        PostagemModel p = postagemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Postagem não encontrada!"));

        p.setTitulo(dto.getTitulo());
        p.setConteudo(dto.getConteudo());
        p.setComunidadeId(dto.getComunidadeId());
        p.setAutorId(dto.getAutorId());
        p.setAtualizadaEm(Instant.now());

        postagemRepository.save(p);
        return converter(p);
    }

    // Deletar
    public void deletar(Long id) {
        postagemRepository.deleteById(id);
    }

    // Conversão para DTO
    private PostagemResponseDTO converter(PostagemModel p) {
        PostagemResponseDTO dto = new PostagemResponseDTO();
        dto.setId(p.getId());
        dto.setTitulo(p.getTitulo());
        dto.setConteudo(p.getConteudo());
        dto.setCriadaEm(p.getCriadaEm());
        dto.setAtualizadaEm(p.getAtualizadaEm());
        dto.setComunidadeId(p.getComunidadeId());
        dto.setAutorId(p.getAutorId());
        return dto;
    }
}
