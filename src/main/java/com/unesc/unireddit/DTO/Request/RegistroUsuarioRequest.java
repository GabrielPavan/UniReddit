package com.unesc.unireddit.DTO.Request;

import com.unesc.unireddit.Model.UsuarioRole;
import jakarta.validation.constraints.NotEmpty;

public record RegistroUsuarioRequest(@NotEmpty(message = "Nome é obrigatório") String name,
                                     @NotEmpty(message = "Email é obrigatório") String mail,
                                     @NotEmpty(message = "Senha é obrigatório") String password,
                                     UsuarioRole role) {
}