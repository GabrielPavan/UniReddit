package com.unesc.unireddit.DTO;

import java.time.LocalDateTime;

public class ComunidadeResponseDTO {

    private Long id;
    private String name;
    private String description;
    private boolean isPrivate;
    private LocalDateTime createAt;

    public ComunidadeResponseDTO(Long id, String name, String description, boolean isPrivate, LocalDateTime createAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.isPrivate = isPrivate;
        this.createAt = createAt;
    }

    // Getters
    public Long getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public boolean isPrivate() { return isPrivate; }
    public LocalDateTime getCreateAt() { return createAt; }
}
