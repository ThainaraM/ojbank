# 🧃 OrangeJuiceBank

OrangeJuiceBank é uma API REST desenvolvida em Java com Spring Boot durante o Orange Hackathon. O projeto simula um mini banco de investimentos com funcionalidades básicas como criação de contas, autenticação, depósitos, saques e visualização de saldo.

## 📌 Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- Maven
- JPA / Hibernate
- H2 Database (ou outro, se aplicável)
- Postman (para testes)

## 📁 Estrutura do Projeto

src/ <br>
├── main/ <br>
│ ├── java/ <br>
│ │ └── com.orangejuice.bank/ <br>
│ │ ├── controller/ <br>
│ │ ├── service/ <br>
│ │ ├── repository/ <br>
│ │ ├── dto/ <br>
│ │ ├── entity/ <br>
│ │ └── config/ <br>
│ └── resources/ <br>
│ ├── application.properties <br>
│ └── data.sql (opcional) <br>
└── test/ <br>


## 🚀 Funcionalidades

- [x] Cadastro de usuários
- [x] Criação de conta com número e saldo inicial
- [x] Login com autenticação Spring Security
- [x] Depósito e saque de valores
- [x] Visualização de saldo da conta
- [ ] Transferência entre contas (em desenvolvimento)

## 📦 Instalação e Execução

1. Clone o projeto:
   ```bash
   git clone https://github.com/ThainaraM/ojbank.git


## 🔐 Autenticação
A autenticação é feita via Spring Security. Após login, você pode usar o token (se JWT estiver implementado) ou credenciais básicas para testar os endpoints protegidos.

📬 Endpoints Principais <br>
Método	Rota	Descrição <br>
POST	/usuarios	Criar novo usuário <br>
POST	/login	Login <br>
POST	/api/transacoes/depositar	Depositar saldo <br>
POST	/api/transacoes/sacar	Sacar saldo <br>
GET	/api/contas/{id}/saldo	Ver saldo da conta <br>

## 💡 Contribuição
Pull requests são bem-vindos! Para mudanças maiores, abra uma issue primeiro para discutir o que você gostaria de mudar. <br>

## 🧠 Desenvolvedora 
Thainara Costa <br>
Estudante de Engenharia de Software • Participante do Orange Hackathon



