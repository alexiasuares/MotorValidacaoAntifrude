# 🚀 Motor de Confiabilidade Antifraude  
Este projeto implementa um motor de validação antifraude para onboarding de clientes, calculando um **grau de confiabilidade** com base na validação de múltiplos dados do usuário.  

## 📌 Funcionalidades  
- Validação de **CPF**, **telefone**, **nome**, **data de nascimento**, **e-mail**, **nome da mãe** e **CEP**  
- Cálculo do **grau de confiabilidade** baseado na pontuação dos dados  
- API REST para integração com outros sistemas  
- Integração com API de consulta de CEP  

## 🛠 Tecnologias Utilizadas  
- **Java** + **Spring Boot**  
- **Maven**  
- **API Externa** para consulta de CEP  


## 📡 Endpoints da API  
### 1️⃣ Validação de Dados  
**POST /api/validar**  

📥 **Request (JSON):**  
```json
{
  "nome": "João Silva",
  "cpf": "12345678900",
  "dataNascimento": "1990-05-15",
  "email": "joao@email.com",
  "telefone": "11987654321",
  "nomeMae": "Maria Silva",
  "cep": "01001000"
}
```
📤 **Response (JSON):**  
```json
{
  "grauConfiabilidade": 7.2
}
```

## ▶ Como Rodar o Projeto  
1. Clone o repositório  
- git clone https://github.com/alexiasuares/MotorValidacaoAntifrude.git
- cd Case

2. Compile 
- mvn clean install

3. Excute
- cd motorConfiabilidade
- mvn spring-boot:run
   
4.Acesse a API em http://localhost:8080/api/validar

