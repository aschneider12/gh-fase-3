#!/bin/bash
set -e

BASE_URL="http://localhost:8080/hospital"
GRAPHQL_URL="http://localhost:8083/hospital/graphql"

echo "=============================================="
echo "TESTE AUTOMÁTICO - SISTEMA HOSPITALAR FIAP"
echo "=============================================="

# PASSO 1 - ️⃣ LOGIN COMO ADMIN
echo -e "\n [1] LOGIN ADMINISTRADOR (a1/a1)"
TOKEN_ADMIN=$(curl -s -X POST "$BASE_URL/auth/login" \
  -H "Content-Type: application/json" \
  -d '{"username": "a1", "password": "a1"}' | jq -r .token)

if [ "$TOKEN_ADMIN" == "null" ] || [ -z "$TOKEN_ADMIN" ]; then
  echo "Falha no login do admin."
  exit 1
fi
echo "Token recebido: ${TOKEN_ADMIN:0:30}..."

# PASSO 2 -  LISTAR USUÁRIOS
echo -e "\n [2] LISTAR USUÁRIOS (GET /usuarios)"
curl -s -X GET "$BASE_URL/usuarios" \
  -H "Authorization: Bearer $TOKEN_ADMIN" | jq

# 3️PASSO 3 - AGENDAR CONSULTA
echo -e "\n [3] AGENDAR CONSULTA (POST /agendamento)"
curl -s -X POST "$BASE_URL/agendamento" \
  -H "Authorization: Bearer $TOKEN_ADMIN" \
  -H "Content-Type: application/json" \
  -d '{"dataConsulta": "15-10-2025 10:00", "pacienteId": 1, "medicoId": 2}'


# 4️Passo 4 -  VALIDAR FILA RABBITMQ
echo -e "\n [4] VERIFICAR SE MENSAGEM FOI PUBLICADA"
docker logs notificacao-service --since 10s | grep "email" || echo "ℹ️ Verifique logs do notificacao-service"

# PASSO 5-  TESTAR GRAPHQL HISTÓRICO
echo -e "\n [5] CONSULTA GRAPHQL (buscarTodasConsultasPaciente)"
curl -s -X POST "$GRAPHQL_URL" \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $TOKEN_ADMIN" \
  -d '{"query":"{ buscarTodasConsultasPaciente(idPaciente: 1) { id dataConsulta medicoNome pacienteNome } }"}' | jq

echo -e "\n TODOS OS TESTES EXECUTADOS!"

