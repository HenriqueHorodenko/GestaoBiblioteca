# 📚 Sistema de Biblioteca em Java

Sistema de gerenciamento de biblioteca desenvolvido em Java, com suporte a cadastro de usuários, livros, funcionários, exemplares e controle de empréstimos.

---

## 📌 Objetivo

Simular o funcionamento básico de uma biblioteca, permitindo:

- Cadastro e listagem de usuários, livros e funcionários
- Controle de exemplares de livros
- Registro de empréstimos e devoluções

---

## 🧠 Estrutura do Projeto

- `Main.java` → Interface principal (menu interativo)
- `Biblioteca.java` → Classe central de controle (lógica do sistema)
- `Pessoa.java` → Classe base para usuários e funcionários
- `Usuario.java` → Representa usuários da biblioteca
- `Funcionario.java` → Representa funcionários
- `Livro.java` → Representa livros cadastrados
- `Exemplar.java` → Representa cópias físicas de livros
- `Emprestimo.java` → Representa o vínculo de empréstimo

---

## ⚙️ Funcionalidades

### 👤 Usuários e Funcionários
- Cadastro automático com ID incremental
- Geração automática de email

### 📚 Livros e Exemplares
- Cadastro de livros
- Associação de múltiplos exemplares a um livro
- Controle de disponibilidade dos exemplares

### 🔄 Empréstimos
- Registro de empréstimo com data atual
- Prazo automático de devolução (15 dias)
- Registro de devolução

### 📋 Listagens
- Usuários cadastrados
- Livros cadastrados
- Funcionários
- Exemplares disponíveis por livro

---

## 📚 Aviso

Este projeto foi desenvolvido como parte de um trabalho acadêmico para a faculdade, com fins educacionais.

## ▶️ Como executar

### 1. Compilar
```bash
javac *.java
```

### 2. Executar
```bash
java Main
```
