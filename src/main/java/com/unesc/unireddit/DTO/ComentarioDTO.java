package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.NotBlank;

public class ComentarioDTO {

    @NotBlank(message = "O titulo é obrigatório")
    private String conteudo;
    private Long postagemId;
    private Long parentId;
    private Long usuarioId;

    // Getters e Setters
    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public Long getPostagemId() { return postagemId; }
    public void setPostagemId(Long postagemId) { this.postagemId = postagemId; }

    public Long getParentId() { return parentId; }
    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }
}
