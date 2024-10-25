# DSCommerce
DSCommerce é uma aplicação de e-commerce desenvolvida para gerenciar produtos, categorias e pedidos, integrando funcionalidades de segurança e autenticação de usuários. O projeto foi construído utilizando o framework Spring Boot e Java, oferecendo uma API RESTful para interações com o sistema.

## _**Stack utilizada**_:
- **_Back-end:_** 
    - Linguagem: Java;
    - Banco de dados: H2;
    - Framework: Spring Boot.
    - **Spring Security**
    - **Spring Data JPA**

## _**Endpoints**_

### **Categories**
- **Listar todas as categorias**
  - **Método:** GET
  - **Endpoint:** `/categories`
  - **Descrição:** Retorna uma lista de todas as categorias.

### **Orders**
- **Buscar pedido por ID**
  - **Método:** GET
  - **Endpoint:** `/orders/{id}`
  - **Autorização:** `ROLE_ADMIN` ou `ROLE_CLIENT`
  - **Descrição:** Retorna os detalhes de um pedido específico.

- **Criar novo pedido**
  - **Método:** POST
  - **Endpoint:** `/orders`
  - **Autorização:** `ROLE_CLIENT`
  - **Descrição:** Cria um novo pedido.

### **Products**
- **Buscar produto por ID**
  - **Método:** GET
  - **Endpoint:** `/products/{id}`
  - **Descrição:** Retorna os detalhes de um produto específico.

- **Listar todos os produtos**
  - **Método:** GET
  - **Endpoint:** `/products`
  - **Descrição:** Retorna uma lista de todos os produtos, com possibilidade de filtro pelo nome.

- **Criar novo produto**
  - **Método:** POST
  - **Endpoint:** `/products`
  - **Autorização:** `ROLE_ADMIN`
  - **Descrição:** Cria um novo produto.

- **Atualizar produto**
  - **Método:** PUT
  - **Endpoint:** `/products/{id}`
  - **Autorização:** `ROLE_ADMIN`
  - **Descrição:** Atualiza os detalhes de um produto existente.

- **Deletar produto**
  - **Método:** DELETE
  - **Endpoint:** `/products/{id}`
  - **Autorização:** `ROLE_ADMIN`
  - **Descrição:** Remove um produto do sistema.

### **Users**
- **Obter detalhes do usuário autenticado**
  - **Método:** GET
  - **Endpoint:** `/users/me`
  - **Autorização:** `ROLE_ADMIN` ou `ROLE_CLIENT`
  - **Descrição:** Retorna os detalhes do usuário autenticado.


