# Motor de Confiabilidade Antifraude

Este projeto implementa um motor de validação antifraude que analisa e calcula um grau de confiabilidade com base na validação de diferentes dados do usuário.

## 📌 Funcionalidades

- Validação de **CPF**, **telefone**, **nome**, **data de nascimento**, **e-mail**, **nome da mãe** e **CEP**.
- Cálculo de **grau de confiabilidade** baseado em pontuação de cada dado.
- API REST para integração com outros sistemas.
- Integração com API de consulta de CEP.
- Arquivamento de logs e dados validados.

## 🚀 Tecnologias Utilizadas

- **Java** 
- **Maven** 
- **API Externa** para consulta de CEP


---

## 📡 Endpoints da API  

### 1️⃣ Validação de Dados  

**📍 Rota:** `POST /api/validar`  

📥 **Request (JSON)**:  

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
{
  "grauConfiabilidade": 7.2
}
 ##Como rodar o Projeto
- Clone o repositório
