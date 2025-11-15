package com.unesc.unireddit.DTO;

import java.time.Instant;

public class PostagemResponseDTO {

    private Long id;
    private String titulo;
    private String conteudo;
    private Instant criadaEm;
    private Instant atualizadaEm;
    private Long comunidadeId;
    private Long autorId;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public Instant getCriadaEm() { return criadaEm; }
    public void setCriadaEm(Instant criadaEm) { this.criadaEm = criadaEm; }

    public Instant getAtualizadaEm() { return atualizadaEm; }
    public void setAtualizadaEm(Instant atualizadaEm) { this.atualizadaEm = atualizadaEm; }

    public Long getComunidadeId() { return comunidadeId; }
    public void setComunidadeId(Long comunidadeId) { this.comunidadeId = comunidadeId; }

    public Long getAutorId() { return autorId; }
    public void setAutorId(Long autorId) { this.autorId = autorId; }
}
