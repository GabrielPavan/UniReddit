package com.unesc.unireddit.Model;

import jakarta.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "tb_postagem")
public class PostagemModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String conteudo;

    @Column(name = "criada_em")
    private Instant criadaEm = Instant.now();

    @Column(name = "atualizada_em")
    private Instant atualizadaEm = Instant.now();

    @Column(name = "comunidade_id")
    private Long comunidadeId;

    @Column(name = "autor_id")
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
