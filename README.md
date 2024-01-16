# E-Commerce API

This is a simple e-commerce API for managing items.

## Table of Contents

- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [API Endpoints](#api-endpoints)
  - [Get All Items](#get-all-items)
  - [Get Item by ID](#get-item-by-id)
  - [Create New Item](#create-new-item)
  - [Update Item](#update-item)
  - [Delete Item](#delete-item)
- [Contributing](#contributing)
- [License](#license)

## Prerequisites

- Java (version 17)
- Maven (version X.X.X)
- Spring Boot (version 3.0.0)
- PostgreSQL (version X.X)

## Installation

1. Clone the repository:

   ```bash
   git clone git@github.com:kevinliao852/e-commerce.git
   cd e-commerce
   ```

2. Build the project:

   ```bash
   mvn clean install
   ```

3. Run the application:

   ```bash
   ./mvnw spring-boot:run
   ```

The API will be available at [http://localhost:8080](http://localhost:8080).

## API Endpoints

### Get All Items

- **Endpoint:** `GET /items`
- **Description:** Retrieve a list of all items.

### Get Item by ID

- **Endpoint:** `GET /items/{itemId}`
- **Description:** Retrieve details for a specific item.

### Create New Item

- **Endpoint:** `POST /items`
- **Description:** Create a new item.
- **Request Body:**
  ```json
  {
    "name": "Example Item",
    "price": 19.99
  }
  ```

### Update Item

- **Endpoint:** `PUT /items/{itemId}`
- **Description:** Update details for a specific item.
- **Request Body:**
  ```json
  {
    "name": "Updated Item",
    "price": 29.99
  }
  ```

### Delete Item

- **Endpoint:** `DELETE /items/{itemId}`
- **Description:** Delete a specific item.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
