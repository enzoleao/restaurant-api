# 🍽️ Restaurant API

API RESTful para gerenciamento de usuários e autenticação em um sistema de restaurante.

Desenvolvida com **Java + Spring Boot + JPA + Spring Security + JWT**, seguindo boas práticas de arquitetura e organização.

---

## 🚀 Tecnologias

- Java 17+
- Spring Boot
- Spring Data JPA
- Spring Security
- JWT (Auth0)
- MySQL
- Maven

---

## 📂 Estrutura do Projeto
```
src/main/java/com/example/basicapi/

├── controller/
│ ├── AuthController.java
│ └── UserController.java
│
├── service/
│ ├── AuthService.java
│ └── UserService.java
│
├── repository/
│ └── UserRepository.java
│
├── entity/
│ └── User.java
│
├── dto/
│ ├── auth/
│ │ ├── LoginDTO.java
│ │ └── AuthResponseDTO.java
│ │
│ └── user/
│ └── UserResponseDTO.java
│
├── security/
│ └── JwtService.java
│
├── config/
│ └── SecurityConfig.java
│
└── exceptions/
├── BadRequestException.java
├── GlobalExceptionHandler.java
└── ErrorResponse.java
```

---

## ⚙️ Funcionalidades implementadas 

- Autenticação com JWT
- Cadastro de Usuário
