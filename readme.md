# SOA2019_Groutp10

## How to run it
  * clone project  
    * git clone https://github.com/kukkikkpl/SOA2019_Group10.git  
  * compile  
    * mvnw clean package  
  * run  
    * mvnw spring-boot:run  

## API

| Service | Endpoint |
| ------- | -------- |
| User | POST/user/signup |
| | POST/user/signin |
| | GET/user/infomation |
| | GET/user/signout |
| Wishlist |GET/wishlist/all |
| |POST/wishlist/add |
| |DELETE/wishlist |
| Statement | GET/statement |
| |POST/statement|
| |DELETE/statement|
| Cosmetic |GET/cosmetics |
| |POST/cosmetics|
| |DELETE/cosmetics/{id}|
| |GET/cosmetics/{id}|
| Inventory |GET/inventory/all|
| |DELETE/inventory|
| |POST/inventory|
