CREATE TABLE tb_comentario (
    id SERIAL PRIMARY KEY,
    conteudo TEXT NOT NULL,
    create_at TIMESTAMP DEFAULT NOW(),
    parent_id BIGINT,
    postagem_id BIGINT NOT NULL,
    usuario_id BIGINT NOT NULL,
    CONSTRAINT fk_comentario_postagem FOREIGN KEY (postagem_id) REFERENCES tb_postagem(id) ON DELETE CASCADE,
    CONSTRAINT fk_comentario_usuario FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id),
    CONSTRAINT fk_comentario_parent FOREIGN KEY (parent_id) REFERENCES tb_comentario(id)
);
