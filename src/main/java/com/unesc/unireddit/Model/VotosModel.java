package com.unesc.unireddit.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_votos")
public class VotosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TipoVoto tipo;

    private LocalDateTime criadoEm = LocalDateTime.now();

    @Column(name = "usuario_id")
    private Long usuarioId;

    @Column(name = "postagem_id")
    private Long postagemId;

    // getters e setters

    public Long getPostagemId() {
        return postagemId;
    }

    public void setPostagemId(Long postagemId) {
        this.postagemId = postagemId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public TipoVoto getTipo() {
        return tipo;
    }

    public void setTipo(TipoVoto tipo) {
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}

