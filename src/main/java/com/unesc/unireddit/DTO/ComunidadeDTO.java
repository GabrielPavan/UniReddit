package com.unesc.unireddit.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ComunidadeDTO {

    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 30, message = "O nome pode ter no máximo 30 caracteres")
    private String name;
    @NotBlank(message = "A descrição é obrigatória")
    private String description;

    private boolean isPrivate;

    // Getters e setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean isPrivate() { return isPrivate; }
    public void setPrivate(boolean isPrivate) { this.isPrivate = isPrivate; }
}
