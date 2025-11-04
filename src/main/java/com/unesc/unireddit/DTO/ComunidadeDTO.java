package com.unesc.unireddit.DTO;

public class ComunidadeDTO {

    private String name;
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
