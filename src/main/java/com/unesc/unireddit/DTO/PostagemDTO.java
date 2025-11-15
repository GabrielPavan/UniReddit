package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class PostagemDTO {

    @NotBlank
    private String titulo;

    @NotBlank
    private String conteudo;

    @NotNull
    private Long comunidadeId;

    @NotNull
    private Long autorId;

    // Getters e Setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public Long getComunidadeId() { return comunidadeId; }
    public void setComunidadeId(Long comunidadeId) { this.comunidadeId = comunidadeId; }

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
}
