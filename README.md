# MotorValidacaoAntifrude
Este projeto é um protótipo de motor de validação antifraude. Ele verifica dados como nome, CPF, data de nascimento, telefone, e-mail e CEP, atribuindo uma pontuação para cada um e calculando um grau de confiabilidade final.
📌 Funcionalidades✅ Validação de nome, CPF, data de nascimento, telefone, e-mail e CEP.✅ Gera um grau de confiabilidade com base nas pontuações individuais.✅ Exibe apenas o grau de confiabilidade como resposta da API.✅ Implementado em Java com Spring Boot.
🛠 Tecnologias UtilizadasJava 17
Spring Boot
Maven
API de consulta de CEP
📂 Estrutura do Projeto/motorConfiabilidade
│── src/main/java/com/verificacaoConfiabilidade
│   ├── controller/ValidacaoController.java
│   ├── service/VerificacaoService.java
│   ├── service/ValidaNome.java
│── pom.xml
│── README.md🚀 Como Executar o Projeto1️⃣ Clonar o Repositóriogit clone https://github.com/seu-usuario/motorConfiabilidade.git
cd motorConfiabilidade2️⃣ Construir e Executar o Projetomvn clean install
mvn spring-boot:runO servidor iniciará em http://localhost:8080.
🔥 Endpoints da API1️⃣ Cálculo do Grau de ConfiabilidadeURL: /api/validacao/calcular
Método: POST
Requisição: JSON com os dados a validar
🔹 Exemplo de Requisição{
  "nome": "João Silva",
  "cpf": "12345678909",
  "dataNascimento": "1990-05-15",
  "telefone": "11987654321",
  "email": "joao@email.com",
  "cep": "01001000"
}🔹 Exemplo de Resposta5.57(Apenas o grau de confiabilidade)
