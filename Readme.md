# 📄 README — Sistema de Biblioteca (Projeto POO)

## 📚 Sobre o Projeto
Este projeto implementa um Sistema de Biblioteca, focado em demonstrar de forma clara os principais conceitos de Programação Orientada a Objetos (POO) em Java.

Ele simula uma biblioteca real, permitindo:

- 👤 Cadastro e gerenciamento de usuários
- 📦 Cadastro de itens no acervo (Livros, Filmes, Jogos e Equipamentos)
- 🔁 Registro de empréstimos
- 📊 Emissão de relatórios
- 🧩 Organização modular baseada em serviços e entidades

O sistema é totalmente navegável por menu interativo no console, ideal para aprendizado e prática de POO.

---

## 🧠 Pilares da POO Aplicados

### 🟦 Abstração
A classe `ItemBiblioteca` representa um item genérico, servindo como base para todos os tipos de itens do acervo.

### 🟩 Encapsulamento
Cada classe possui seus atributos privados e expostos apenas através de métodos acessores (`get`/`set`).

### 🟧 Herança
As entidades `Livro`, `Filme`, `JogoTabuleiro` e `Equipamento` herdam de `ItemBiblioteca`.

### 🟥 Polimorfismo
O acervo trata todos os itens de forma unificada usando o tipo `ItemBiblioteca`.

---

## 🏛 Arquitetura do Sistema

### 🔧 Serviços (Regras de Negócio)
- `UsuarioServicos` → gerenciamento de usuários
- `AcervoServicos` → controle do acervo
- `EmprestimoServicos` → registro de empréstimos
- `RelatorioServicos` → geração de relatórios

### 🧱 Entidades
- `Usuario`
- `ItemBiblioteca` (abstrata)
- `Livro`, `Filme`, `JogoTabuleiro`, `Equipamento`
- `TicketEmprestimo`

---

## 📊 Funcionalidades

### 👥 Gerenciamento de Usuários
Cadastro, consulta, bloqueio, verificação.

### 📚 Acervo
Cadastro e controle de disponibilidade dos itens.

### 🔁 Empréstimos
Registro de empréstimos com validação completa.

### 📑 Relatórios
Relatórios de usuários, itens e empréstimos ativos.

---

## 💻 Execução
O projeto é executado diretamente na IDE NetBeans, através da classe:

`Biblioteca.java`

---

## 🚀 Próximas Melhorias
- Sistema de devoluções
- Histórico do usuário
- Persistência em arquivos
- Interface gráfica

---

## 👨‍💻 Autores
- Guilherme Miller Gama Cardoso
- Victor Henrick Santos Andrade
- Henrique Oliveira Rodrigues
