CREATE TABLE tb_comunidade(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description TEXT NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT NOW(),
    is_private BOOLEAN DEFAULT FALSE
);