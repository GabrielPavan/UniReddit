package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PostagemDTO {

    @NotBlank(message = "O titulo é obrigatório")
    @Size(max = 100, message = "O titulo pode ter no máximo 100 caracteres")
    private String titulo;

    @NotBlank(message = "A descrição é obrigatório")
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
