CREATE TABLE tb_postagem (
    id              BIGSERIAL PRIMARY KEY,
    titulo          VARCHAR(255) NOT NULL,
    conteudo        TEXT NOT NULL,
    criada_em       TIMESTAMP DEFAULT NOW(),
    atualizada_em   TIMESTAMP DEFAULT NOW(),

    comunidade_id   BIGINT NOT NULL,
    autor_id        BIGINT NOT NULL,

    CONSTRAINT fk_postagem_comunidade FOREIGN KEY (comunidade_id)
        REFERENCES tb_comunidade(id),

    CONSTRAINT fk_postagem_usuario FOREIGN KEY (autor_id)
        REFERENCES tb_usuario(id)
);
