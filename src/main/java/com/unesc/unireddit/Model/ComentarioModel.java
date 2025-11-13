package com.unesc.unireddit.Model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_comentario")
public class ComentarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String conteudo;

    @Column(name = "create_at")
    private LocalDateTime createAt = LocalDateTime.now();

    // Comentário pai → para hierarquia de respostas
    @ManyToOne
    @JoinColumn(name = "parent_id")
    private ComentarioModel parent;

    // Associação com a postagem
    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private PostagemModel postagem;

    // Associação com o usuário autor
    @ManyToOne
    @JoinColumn(name = "usuario_id")
    private UsuarioModel usuario;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getConteudo() { return conteudo; }
    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public LocalDateTime getCreateAt() { return createAt; }
    public void setCreateAt(LocalDateTime createAt) { this.createAt = createAt; }

    public ComentarioModel getParent() { return parent; }
    public void setParent(ComentarioModel parent) { this.parent = parent; }

    public PostagemModel getPostagem() { return postagem; }
    public void setPostagem(PostagemModel postagem) { this.postagem = postagem; }

    public UsuarioModel getUsuario() { return usuario; }
    public void setUsuario(UsuarioModel usuario) { this.usuario = usuario; }
}
