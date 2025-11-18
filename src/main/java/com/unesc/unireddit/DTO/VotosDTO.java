package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class VotosDTO {
    @NotNull(message = "O tipo é obrigatório")
    @Min(value = 0, message = "Tipo inválido, só é permitido 0 ou 1")
    @Max(value = 1, message = "Tipo inválido, só é permitido 0 ou 1")
    private Integer tipo;

    @NotNull(message = "O usuário é obrigatório")
    private Long usuarioId;

    @NotNull(message = "A postagem é obrigatório")
    private Long postagemId;

    // getters e setters

    public Integer getTipo() {
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
