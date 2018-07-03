# Deploy

Para rodar a aplicação é necessário ter o docker instalado, navegue até o diretório raiz do projeto
e rode o comando abaixo: 

`
 docker-compose up -d
`

O docker irá buildar as imagens referentes ao projeto e será possível acessar pelos endereços:

* Front: localhost:8080 ou 192.168.99.100:8080
* Backend: localhost:8000 ou 192.168.99.100:8000

Para visualizar o swagger da api basta acessar:

`
localhost:8000/swagger-ui 
  ou 
192.168.99.100:8000/swagger-ui
`