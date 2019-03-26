# SOA2019_Group10

## How to RUN Project
- Java 11 / Port 8080
- clone project
  - git clone https://github.com/kukkikkpl/SOA2019_Group10.git
- compile
  - mvnw clean package
- run project
  - mvnw spring-boot:run
- open the localhost
  - http://localhost:8080 {/@RequestMapping}

## API
- User Service
  - Data JSON (application/json) / {username:password} -> {"admin:"123456"} {"pimJaidee":"123456"}
    - GET/user
    - GET/user/login
    - GET/user/register
  - GET/user/:id
  - POST/user/:id
  - GET/user/:id/cosmetic
  - POST/user/:id/cosmetic/information
  - GET/user/cosmetic
  - DELETE/user/cosmetic
  - PUT/user/cosmetic
- Statement
  - GET/user/:id/statement
- Wishlist
  - {username} -> {"Pond,"Bright"}
    - GET/{username}/wishlist 
    - POST/{username}/wishlist
    - DELETE/{username}/wishlist
  - Data JSON (application/json)  
    - DELETE/{username}/wishlist/
    - POST/{username}/wishlist
- Cosmetic Service
  - {keyword} -> {"Body","Face","Hair"}
    - GET/cosmetics
    - GET/cosmetic/search/{keyword}
- Catagory Service
  - GET/category
