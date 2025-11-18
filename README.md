# UniReddit

UniReddit é uma API RESTful desenvolvida em Java com Spring Boot que simula as funcionalidades básicas de uma rede social semelhante ao Reddit. O sistema permite o gerenciamento de usuários, comunidades, postagens, comentários e sistemas de votação.

## 🚀 Tecnologias Utilizadas

*   **Java 21**
*   **Spring Boot 3.5.7**
*   **Spring Data JPA** (Hibernate)
*   **Spring Security + JWT** (Autenticação e Autorização)
*   **PostgreSQL** (Banco de dados)
*   **Flyway** (Migrações de banco de dados)
*   **Lombok**
*   **Gradle** (Gerenciador de dependências)

## ⚙️ Como Configurar e Executar

### Pré-requisitos
*   Java JDK 21 instalado.
*   PostgreSQL instalado e rodando.

### Passo a Passo

1.  **Clone o repositório:**
    ```bash
    git clone https://github.com/GabrielPavan/UniReddit.git
    cd UniReddit
    ```

2.  **Configure o Banco de Dados:**
    Abra o arquivo `src/main/resources/application.properties` e verifique se as configurações de conexão com o banco de dados estão corretas (URL, username e password).

3.  **Execute a aplicação:**
    
    No Windows:
    ```cmd
    gradlew.bat bootRun
    ```
    
    No Linux/macOS:
    ```bash
    ./gradlew bootRun
    ```

A aplicação estará rodando em `http://localhost:8080`.

---

## 📚 Documentação da API

Abaixo estão listados os principais endpoints da aplicação com exemplos de requisição.

### 🔐 Autenticação (`/auth`)

#### Login
*   **URL:** `POST /auth/login`
*   **Descrição:** Autentica um usuário e retorna um token JWT.
*   **Body:**
    ```json
    {
      "mail": "email@exemplo.com",
      "password": "senha123"
    }
    ```

#### Registro
*   **URL:** `POST /auth/register`
*   **Descrição:** Cria uma nova conta de usuário.
*   **Body:**
    ```json
    {
      "name": "Nome do Usuário",
      "mail": "email@exemplo.com",
      "password": "senha123",
      "role": "ROLE_USER"
    }
    ```
    *(Nota: `role` é opcional, padrão ROLE_USER, valores aceitos: ROLE_ADMIN e ROLE_USER)*

---

### 👥 Comunidades (`/comunidades`)

#### Criar Comunidade
*   **URL:** `POST /comunidades`
*   **Descrição:** Cria uma nova comunidade.
*   **Body:**
    ```json
    {
      "name": "Java Developers",
      "description": "Comunidade para discutir sobre Java e Spring Boot",
      "private": false
    }
    ```

#### Listar Todas
*   **URL:** `GET /comunidades`

#### Buscar por ID
*   **URL:** `GET /comunidades/{id}`

#### Buscar por Nome
*   **URL:** `GET /comunidades/search?nome=termo`

#### Atualizar Comunidade
*   **URL:** `PUT /comunidades/{id}`
*   **Body:** (Mesmo formato da criação)

#### Deletar Comunidade
*   **URL:** `DELETE /comunidades/{id}`

---

### 📝 Postagens (`/postagens`)

#### Criar Postagem
*   **URL:** `POST /postagens`
*   **Descrição:** Cria uma nova postagem em uma comunidade.
*   **Body:**
    ```json
    {
      "titulo": "Como usar o Spring Security?",
      "conteudo": "Estou com dúvidas na configuração do JWT...",
      "comunidadeId": 1,
      "autorId": 1
    }
    ```

#### Listar Todas
*   **URL:** `GET /postagens`

#### Buscar por ID
*   **URL:** `GET /postagens/{id}`

#### Listar por Comunidade
*   **URL:** `GET /postagens/comunidade/{comunidadeId}`

#### Atualizar Postagem
*   **URL:** `PUT /postagens/{id}`
*   **Body:** (Mesmo formato da criação)

#### Deletar Postagem
*   **URL:** `DELETE /postagens/{id}`

---

### 💬 Comentários (`/comentarios`)

#### Criar Comentário
*   **URL:** `POST /comentarios`
*   **Descrição:** Adiciona um comentário a uma postagem ou responde a outro comentário.
*   **Body (Comentário na Postagem):**
    ```json
    {
      "conteudo": "Ótima dúvida! Você precisa configurar o filtro...",
      "postagemId": 1,
      "usuarioId": 2
    }
    ```
*   **Body (Resposta a um Comentário - Thread):**
    ```json
    {
      "conteudo": "Obrigado pela ajuda!",
      "postagemId": 1,
      "usuarioId": 1,
      "parentId": 10
    }
    ```

#### Listar Comentários de uma Postagem
*   **URL:** `GET /comentarios/postagem/{postagemId}`

#### Listar Respostas de um Comentário
*   **URL:** `GET /comentarios/{id}/respostas`

#### Atualizar Comentário
*   **URL:** `PUT /comentarios/{id}`
*   **Body:**
    ```json
    {
      "conteudo": "Conteúdo editado..."
    }
    ```

#### Deletar Comentário
*   **URL:** `DELETE /comentarios/{id}`

---

### ⬆️ Votos (`/votos`)

#### Votar
*   **URL:** `POST /votos`
*   **Descrição:** Registra um voto em uma postagem.
*   **Body:**
    ```json
    {
      "tipo": 1,
      "usuarioId": 2,
      "postagemId": 1
    }
    ```
    *(Nota: `tipo` pode ser 1 para positivo ou 0 para negativo)*

#### Listar Votos de uma Postagem
*   **URL:** `GET /votos/postagem/{id}`

#### Listar Votos de um Usuário
*   **URL:** `GET /votos/usuario/{id}`

#### Deletar Voto
*   **URL:** `DELETE /votos/{id}`

---

### 👤 Usuários (`/usuarios`)

#### Listar Todos
*   **URL:** `GET /usuarios`

#### Buscar por ID
*   **URL:** `GET /usuarios/{id}`

#### Buscar por Email
*   **URL:** `GET /usuarios/mail/{mail}`

#### Deletar
*   **URL:** `DELETE /usuarios/{id}`

---

## 🔒 Autenticação e Segurança

A maioria dos endpoints (exceto `/auth/*` e visualizações públicas `GET`) exige autenticação via **Bearer Token**.

1.  Faça login na rota `/auth/login`.
2.  Copie o `token` retornado.
3.  Nas requisições subsequentes, adicione o header:

```http
Authorization: Bearer <seu_token_jwt>
```
