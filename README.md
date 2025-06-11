# 🧾 Projeto API de Produtos com Swagger (Spring Boot)

Este é um projeto de exemplo em **Spring Boot 3** que demonstra a criação de uma **API REST de produtos** utilizando documentação interativa com **Swagger** via **Springdoc OpenAPI**.

---

## 🚀 Tecnologias Utilizadas

- ✅ Java 17+
- ✅ Spring Boot 3.x
- ✅ Spring Web
- ✅ Springdoc OpenAPI (`springdoc-openapi-starter-webmvc-ui`)
- ✅ Maven

---

## 📁 Estrutura do Projeto

```
swaggerexemplo1/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           └── apiswagger/
│   │   │               ├── controller/
│   │   │               │   ├── ProdutoController.java
│   │   │               │   └── AuthProtectedController.java
│   │   │               └── config/
│   │   │                   └── SwaggerConfig.java
│   └── resources/
│       └── application.properties
└── pom.xml
```

---

## 📌 Endpoints Disponíveis

| Verbo | Caminho                     | Descrição                            |
|-------|-----------------------------|--------------------------------------|
| GET   | `/api/produtos`             | Lista todos os produtos              |
| POST  | `/api/produtos`             | Adiciona um novo produto             |
| GET   | `/api/produtos/{indice}`    | Busca um produto pelo índice         |
| PUT   | `/api/produtos/{indice}`    | Atualiza um produto                  |
| DELETE| `/api/produtos/{indice}`    | Remove um produto                    |
| GET   | `/api/seguro`               | Endpoint protegido com JWT (simulado)|

---

## 🌐 Acessando a Documentação Swagger

- Interface Swagger UI:  
  [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

- Documentação em JSON (OpenAPI):  
  [http://localhost:8080/docs](http://localhost:8080/docs)

---

## 🧠 Anotações Swagger Explicadas

| Anotação                       | Para que serve                                                                          |
|-------------------------------|------------------------------------------------------------------------------------------|
| `@Operation(summary = "...")` | Define o **resumo/título** do endpoint na documentação Swagger                           |
| `@ApiResponse(...)`           | Documenta um **código de resposta HTTP** (ex: 200, 201, 400, 404, 204)                   |
| `@ApiResponses({...})`        | Agrupa múltiplos `@ApiResponse` em um só bloco                                          |
| `@RequestBody(description=...)` | Documenta o **corpo da requisição** esperada em POST/PUT                             |
| `@Parameter(...)`             | Descreve parâmetros de entrada (`@PathVariable`, `@RequestParam`)                       |
| `@SecurityRequirement(...)`   | Indica que o endpoint requer **autenticação JWT**                                       |
| `@Schema(...)`                | Descreve atributos de uma classe/DTO na modelagem OpenAPI                               |

---

## 🔐 Autenticação com JWT (Simulada)

- O Swagger foi configurado para aceitar **JWT** na interface.
- Basta clicar em **Authorize** no topo da Swagger UI e inserir o token no formato:

```
Bearer SEU_TOKEN_JWT_AQUI
```

### Configuração no `SwaggerConfig.java`:

```java
.addSecuritySchemes("bearerAuth", 
    new SecurityScheme()
        .type(SecurityScheme.Type.HTTP)
        .scheme("bearer")
        .bearerFormat("JWT"))
```

---

## 🧪 Testando a API

Você pode testar todos os endpoints diretamente pela interface do Swagger. Basta clicar sobre o endpoint desejado, preencher os parâmetros e clicar em **"Try it out"**.

---

## 💡 Exemplos de Retorno

- `200 OK`: Sucesso  
- `201 Created`: Produto adicionado  
- `204 No Content`: Produto removido  
- `400 Bad Request`: Dados inválidos  
- `404 Not Found`: Produto não encontrado

---

## 📘 Referências

- [Springdoc OpenAPI](https://springdoc.org/)
- [Swagger UI](https://swagger.io/tools/swagger-ui/)
- [Spring Boot Docs](https://spring.io/projects/spring-boot)

---

## 🧑‍💻 Autor

**Desenvolvido por [Daniel Abella](https://www.daniel-abella.com)**  
🌐 www.daniel-abella.com
