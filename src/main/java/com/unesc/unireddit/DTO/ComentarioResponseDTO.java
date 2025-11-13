package com.unesc.unireddit.DTO;

import java.time.LocalDateTime;
import java.util.List;

public class ComentarioResponseDTO {

    private Long id;
    private String conteudo;
    private LocalDateTime createAt;
    private Long parentId;
    private Long usuarioId;

    // Lista recursiva de respostas
    private List<ComentarioResponseDTO> subRespostas;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public LocalDateTime getCreateAt() { return createAt; }
    public void setCreateAt(LocalDateTime createAt) { this.createAt = createAt; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public List<ComentarioResponseDTO> getSubRespostas() { return subRespostas; }
    public void setSubRespostas(List<ComentarioResponseDTO> subRespostas) { this.subRespostas = subRespostas; }
}
