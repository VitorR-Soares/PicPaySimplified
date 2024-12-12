<p align="center" width="100%">
    <img width="50%" src="https://upload.wikimedia.org/wikipedia/commons/5/5e/PicPay_Logogrande.png"> 
</p>


<h3 align="center">
  PicPay Simplificado
</h3>

<p align="center">

  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-java-green">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">
  <img alt="Concluído" src="https://img.shields.io/badge/concluído-OK-green">

</p>

# Descrição
Esse é um projeto que busca simular as operações básicas em um PicPaySimplificado. O objetivo principal foi treinar boas práticas na construção de API's, uso de Jakarta Persistence para mapeamento de entidades, uso de Docker pra configuração de bando de dados MySQL, comunicação com API externa comOpenFeign, validação de dados com Hibernaate e tratamento de exceções com ControllerAdvice e ProblemDetails.

## Índice

- [Funcionalidades](#funcionalidades)
- [Escopo da Aplicação](#escopo-da-aplicação)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Instalação](#instalação)
- [Utilização](#utilização)
- [API Endpoints](#api-endpoints)

## Funcionalidades

- Criar Conta de Wallet
- Realizar Transferências

## Escopo da aplicação

- 2 tipos de usuário: Comum e Lojista

### Regras de Negócio das Entidades
- Ambos os tipos de usuário precisam de Nome Completo, CPF, E-Mail e Senha
- CPF/CNPJ e E-Mails devem ser únicos
- Usuários podem enviar dinheiro tanto para lojistas como para outros usuários
- Lojistas só podem receber dinheiro

### Regras de Negócio de Transferências:
- Deve ser RESTful
- Validar se o usuário tem saldo antes de realizar transferências
- Antes de finalizar a transferência, deve-se consultar um serviço autorizador externo
- A operação de transferência deve ser uma transação reversível
- No recebimento de pagamento, o usuário ou lojista deve receber uma notificação enviada por um serviço de terceiro e eventualmente esse serviço pode estar indisponível

## Tecnologias Utilizadas

- Java
- Spring Boot
- MySQL como banco de dados
- Docker para conteinerização
- Para analisar o banco de dados, utilizei Beekeper
- Para consumir os endpoints da aplicação, utilizei Bruno

## Instalação

1. Clone o Repositório

```bash
git clone https://github.com/VitorR-Soares/TwitterSimplified.git
```

2. Instale as dependências com Maven
3. Garanta que possua o Docker Instalado

## Utilização

1. Inicie o contâiner docker no console, dentro da pasta 'docker
```bash
  docker compose up
```
2. Inicie a aplicação com Maven
3. A API estará acessível no http://localhost:8080


## API Endpoints
A API disponibiliza os seguintes endpoints:

```markdown
POST / createWallet  - Realiza cadastro de carteira na aplicação, com fullname, cpfCnpj, email, password e walletType

POST / transfer - Realiza uma transferência, com value, sender (id do remetente) e receiver (id do destinatário)

```


:mag: Baixe o projeto e teste você mesmo na prática.

### Entre em contato! Estou à disposição

Acesse meu [Linkedin](https://www.linkedin.com/in/vitorr-soares/) 

Para mais projetos, meu [GitHub](https://github.com/VitorR-Soares/)
