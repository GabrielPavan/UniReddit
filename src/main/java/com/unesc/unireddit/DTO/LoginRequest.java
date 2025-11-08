package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.NotEmpty;

public record LoginRequest(@NotEmpty(message = "Email é obrigatório") String mail,
                           @NotEmpty(message = "Senha é obrigatório") String password) {

}
