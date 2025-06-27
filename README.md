# 🧠 FirstGate

Bem-vindo à minha API de usuários feita com **Spring Boot**!  
Este projeto foi construído com foco em aprendizado, boas práticas, organização de código e muita vontade de evoluir como dev Java! 💪

---

## 📚 Sobre o Projeto

Esta é uma API RESTful simples de gerenciamento de usuários, onde é possível:

- ✅ Criar usuários
- 📋 Listar todos os usuários
- 📝 Atualizar informações de um usuário
- ❌ Remover um usuário

O armazenamento dos dados é feito **em memória (usando uma lista interna)**.

---

## 🚀 Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Maven
- Testado com Insomnia/Postman

---

## 📁 Estrutura do Projeto

```plaintext
src/
└── main/
    └── java/
        └── com/
            └── example/
                └── demo/
                    ├── controller/
                    │   └── UserController.java
                    ├── model/
                    │   └── User.java
                    ├── service/
                    │   └── UserService.java
                    └── DemoApplication.java

```

### 🔗 Base URL
http://localhost:8080/api

### 📌 POST `/users` – Criar novo usuário

Cria um novo usuário e salva na memória.

#### Corpo da requisição:
```
{
  "nome": "João Silva",
  "email": "joao@email.com",
  "senha": "minhaSenha123"
}
````
Respostas:
201 Created – Usuário salvo com sucesso

400 Bad Request – Dados inválidos (nome, email ou senha)

### 📌 GET /users – Listar todos os usuários
Retorna todos os usuários cadastrados.

Resposta:
```
[
  {
    "nome": "João Silva",
    "email": "joao@email.com",
    "senha": "minhaSenha123"
  }
]
```
200 OK – Lista retornada com sucesso

### 📌 PUT /users/{email} – Atualizar usuário
Atualiza os dados de um usuário com base no email.

Parâmetro na URL:
{email} – Email do usuário a ser atualizado

Corpo da requisição:
```
{
  "nome": "João Atualizado",
  "email": "joao@email.com",
  "senha": "novaSenha123"
}
```
Respostas:
200 OK – Usuário atualizado com sucesso

404 Not Found – Usuário não encontrado

### 📌 DELETE /users/{email} – Deletar usuário
Remove um usuário com base no email.

Parâmetro na URL:
{email} – Email do usuário a ser deletado

Respostas:
200 OK – Usuário deletado com sucesso

404 Not Found – Usuário não encontrado

### 🛡️ Validações Aplicadas
Campo	Regras
nome	Obrigatório (não pode estar vazio)
email	Obrigatório e deve conter @
senha	Obrigatória e com no mínimo 8 caracteres
🧪 Testando com Insomnia/Postman
Base URL: http://localhost:8080/api

Utilize métodos: POST, GET, PUT, DELETE

Corpo da requisição sempre em JSON

### ✨ Autor
João Pedro.

Estudante de Análise e Desenvolvimento de Sistemas
📚 Futuro Engenheiro de Software | Back-end Java
🔥 Em constante evolução

### 📸 Print de código

<sub>![image](https://github.com/user-attachments/assets/4b419a9e-af71-4ec0-81ac-73e2b6bf8fc1)
</sub>

### 📸 POST:

<sub>![image](https://github.com/user-attachments/assets/9644ee67-0656-48ac-ba5f-23f18d5986f3)
</sub>

### 📸 GET:

<sub>![image](https://github.com/user-attachments/assets/c27440f9-95d6-4b38-86ae-56a3206eb8ef)
</sub>

### 📸 PUT:

<sub>![image](https://github.com/user-attachments/assets/3c6d3f3d-a016-454a-80c9-777bb55a9b9d)
</sub>

### 📸 DELETE:

<sub>![image](https://github.com/user-attachments/assets/4302e580-5242-4fa4-8cb9-d48bc6f80eec)
</sub>

### 🧭 Próximos passos
Integrar com banco de dados (MySQL)

- Implementar DTOs e validação com @Valid

- Adicionar documentação Swagger

- Testes unitários e integração

"Não precisa ser perfeito, só precisa evoluir todos os dias." 🚀
