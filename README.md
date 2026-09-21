# Sistema de Cinema

Sistema de gerenciamento de cinema desenvolvido em Java.

## Versão

**v1.0 — Primeira versão**

Esta versão representa a primeira etapa do projeto, desenvolvida com Java e interface via console, utilizando uma arquitetura em camadas.

## Funcionalidades

- Cadastro de filmes
- Listagem de filmes
- Cadastro de sessões
- Listagem de sessões
- Cadastro de clientes
- Listagem de clientes
- Compra de ingressos
- Compra de múltiplos ingressos
- Controle de capacidade das sessões
- Consulta de ingressos
- Cancelamento de ingressos

## Estrutura do projeto

O projeto está organizado em camadas:

```text
src/
├── model/
├── repository/
├── service/
└── system/
```

### Model

Contém as entidades e enums utilizados pelo sistema:

- `Filme`
- `Sessao`
- `Cliente`
- `Ingresso`
- `ClassificacaoIndicativa`
- `TipoIngresso`

### Repository

Responsável pelo armazenamento e acesso aos dados durante a execução da aplicação:

- `FilmeRepository`
- `SessaoRepository`
- `ClienteRepository`
- `IngressoRepository`

### Service

Responsável pelas operações e regras de negócio:

- `FilmeService`
- `SessaoService`
- `ClienteService`
- `IngressoService`

### System

Responsável pela interação com o usuário através do menu do sistema:

- `SistemaCinema`

## Conceitos utilizados

- Programação Orientada a Objetos
- Encapsulamento
- Enum
- ArrayList
- Arquitetura em camadas
- Repository
- Service
- Dependency Injection
