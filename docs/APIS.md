## Initial Modeling

### Session

- POST `/api/auth/signup`
- GET `/api/auth/login`

### Artesão (CRUD)

- POST `/api/artesaos`
- GET `/api/artesaos/{id}`
- GET `/api/artesaos`
- PUT `/api/artesaos/{id}`
- DELETE `/api/artesaos/{id}`
- DELETE `/api/artesaos/{id}`

### Produto (CRUD)

- POST `/api/produtos`
- GET `/api/produtos/{id}`
- GET `/api/produtos`
- PUT `/api/produtos/{id}`
- DELETE `/api/produtos/{id}`
- GET `/api/artesao/{id}/produtos`
- GET `/api/produtos/qr/{qrCodeId}`

### Vendas

- POST `/api/vendas`
- GET `/api/vendas/{id}`
- GET `/api/vendas`
- GET `/api/artesaos/{id}/vendas`

---

### CHOICES TO DO

GET /api/produtos?artesaoId=15
GET /api/artesaos/15/produtos

---

tests

curl -i -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "João Silva",
    "telefone": "(11) 99999-9999",
    "identificacao": "123456789",
    "email": "joao@example.com",
    "senha": "senhaSegura123"
  }'


curl -i -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "joao@example.com",
    "senha": "senhaSegura123"
  }'


Using the JWT for authenticated requests
Example of sending the token in Authorization header:

curl -H "Authorization: Bearer eyJhbGciOiJIUzI1Ni...<jwt>" \
  http://localhost:8080/api/some-protected-endpoint