# FinancialBackend

---

## Technology Used

- Java
- Springboot
- MYSQL v8

## API ENDPOINTS

- Get
  - /{id}: Get Bill by ID
- Post
  - /duration: get bills between begin and end
    - `{ "begin": "yyyy-mm-dd", "end" : "yyyy-mm-dd" }`
  - /save: save Bill to db
    - `{ "name": String, "amount": number, "date":"yyyy-mm-dd", "occurance": String }`
- Put
  - /update: update and existing bill
    - `{ "id": number "name": String, "amount": number, "date":"yyyy-mm-dd", "occurance": String }`
- Delete

  - /delete/{id}: delete by id

## ENV Variables

- DB_PORT = Port to access api
- DB_URL = URL to DB
- USER = DB Username
- DBPASS = DB Password

## Setup

- Setup ENV variables
- build and run application
- make note of port and access url to connect frontend
