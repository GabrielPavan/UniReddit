create table tb_votos(
    id              BIGSERIAL PRIMARY KEY,
    tipo            VARCHAR(15) NOT NULL,
    criada_em       TIMESTAMP DEFAULT NOW(),
    comunidade_id   BIGINT NOT NULL,
    autor_id        BIGINT NOT NULL,

    CONSTRAINT fk_postagem_comunidade FOREIGN KEY (comunidade_id)
        REFERENCES tb_comunidade(id) ON DELETE CASCADE,

    CONSTRAINT fk_postagem_usuario FOREIGN KEY (autor_id)
        REFERENCES tb_usuario(id)
)