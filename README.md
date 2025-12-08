
post
http://localhost:8080/drivers

{
  "name": "Maria Silva",
  "birthDate": "1990-05-15",
  "numero": 7,
  "placa": "BRA2E19",
  "cnh": "012assas347290",
  "anoCarro": 1886,
  "comentario": "Bom dia."
}

post
http://localhost:8080/passengers

{
  "name": "Evaldo",
  "email": "abc@gamil.com"
}

post
http://localhost:8080/travels/1

{
  "origem":"Rua mato 235",
  "destino": "Rua grama 143"
}

put
http://localhost:8080/travels/1/driver/1

patch
http://localhost:8080/travels/1

{
  "status": "FINISHED"
}