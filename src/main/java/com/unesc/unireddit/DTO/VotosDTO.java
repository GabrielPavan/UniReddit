package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.NotNull;

public class VotosDTO {
    @NotNull(message = "O tipo é obrigatório")
    private int tipo; // 1, 2, etc.

    @NotNull(message = "O usuário é obrigatório")
    private Long usuarioId;

    @NotNull(message = "A postagem é obrigatório")
    private Long postagemId;

    // getters e setters

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public Long getPostagemId() {
        return postagemId;
    }

    public void setPostagemId(Long postagemId) {
        this.postagemId = postagemId;
    }
}
