# Tech Challenge - Projeto de Gestão Hospitalar 

## Pós Tech Arquitetura e Desenvolvimento Java - Fase 3

## O Projeto

## A Arquitetura

## Tecnologias utilizadas

- Java 21  
- Spring Boot 3.4.4  
- Spring Security (JWT)  
- PostgreSQL  
- Flyway  
- Swagger (SpringDoc)  
- Docker & Docker Compose
- MapStruct
- JUnit 5
- Mockito
- MockMvc
- AsserJ
- Rest Assured

## Autenticação com Google OAuth2.0 + JWT

Este projeto utiliza **Google OAuth2.0** para login.  
Após a autenticação com o Google, o sistema gera um **JWT** que deve ser usado no header `Authorization` para acessar rotas privadas.

---

### 1. Criar Client ID e Client Secret no Google

1. Acesse o [Google Cloud Console](https://console.cloud.google.com/)  
2. Vá em **APIs & Services > Credentials**  
3. Clique em **Create Credentials > OAuth client ID**  
4. Selecione o tipo **Web application**  
5. Em **Authorized redirect URIs**, adicione:  

```
http://localhost:8080/hospital/login/oauth2/code/google
```

6. Salve e copie o **Client ID** e o **Client Secret** gerados

---

### 2. Configurar variáveis de ambiente

Antes de rodar o projeto, configure as variáveis:

#### Windows (PowerShell)
```powershell
$env:GOOGLE_CLIENT_ID="seu_client_id.apps.googleusercontent.com"
$env:GOOGLE_CLIENT_SECRET="seu_client_secret"
```

---

### 3. Rodar o projeto

Com as variáveis configuradas, rode:

```bash
mvn clean spring-boot:run
```

O backend estará disponível em:

```
http://localhost:8080/hospital
```

---

### 4. Testar autenticação

#### 4.1 Acessar rota pública
```bash
curl http://localhost:8080/hospital/public
```

Resposta esperada:
```
<h4> PÁGINA PÚBLICA - OK</h4>
```

---

#### 4.2 Fazer login com Google

Abra no navegador:
```
http://localhost:8080/hospital/oauth2/authorization/google
```

Após login, você será redirecionado para:
```
http://localhost:8080/hospital/public?token=<jwt>
```

---

#### 4.3 Usar JWT em rota protegida

Copie o `<jwt>` da URL e teste no terminal:

```bash
curl -H "Authorization: Bearer <jwt>" http://localhost:8080/hospital/usuarios
```
- Se o token for válido, você verá os usuários cadastrados no banco.  
- Se não enviar o token, receberá **401 Unauthorized**.

### Testes

## Documentação da API (Swagger)

Após subir o backend, acesse:

- [Swagger UI](http://localhost:8080/swagger-ui/index.html)


## Configuração de variáveis de ambiente



## Autores

- [Alessandro Schneider](https://github.com/aschneider12)
- [Raquel Morabito](https://github.com/raquelmorabito)
- [Eduardo Serafim](https://github.com/EduardoSerafim)
- [Natan Campos](https://github.com/Tune-SKT)
- [Henrique Danzo](https://github.com/danzobiss)

Desenvolvido como parte do projeto Tech Challenge - FIAP
