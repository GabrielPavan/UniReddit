CREATE TABLE tb_comunidades(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    description TEXT NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT NOW(),
    is_private BOOLEAN DEFAULT FALSE
);
CREATE TABLE tb_usuarios(
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    mail VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    create_at TIMESTAMP NOT NULL DEFAULT NOW(),
);
CREATE TABLE tb_usuarios_roles(
    usuario_id BIGSERIAL NOT NULL,
    role VARCHAR(50) NOT NULL,
    CONSTRAINTS fk_user FOREIGN KEY (usuario_id) REFERENCES tb_usuarios(id) ON DELETE CASCADE
);