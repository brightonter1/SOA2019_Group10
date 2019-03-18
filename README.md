# SOA2019_Group10

## How to RUN Project
- clone project
  - git clone https://github.com/kukkikkpl/SOA2019_Group10.git
- run project
  - spring-boot:run
- open the localhost
  - http://localhost:8080/ {@RequestMapping}

## API
- User Service
  - GET/user
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
  - GET/user/wishlist
  - GET/user/wishlist/cosmetic
  - DELETE/user/wishlist/cosmetic
  - POST/user/wishlist
- Cosmetic Service
  - GET/cosmetics
  - GET/cosmetic/search
- Catagory Service
  - GET/category
