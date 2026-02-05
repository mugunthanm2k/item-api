# E-commerce Item Management API

A simple RESTful API for managing e-commerce items (like Flipkart/Amazon).

# Project Links

👉 GitHub Repository: https://github.com/mugunthanm2k/item-api.git

👉 Live Demo: [Not deployed yet](https://item-api-production-0418.up.railway.app)

## Features
- ✅ Add new items with input validation
- ✅ Get item by ID
- ✅ In-memory data storage using ArrayList
- ✅ Jakarta Bean Validation for input validation
- ✅ Proper HTTP status codes

---

## API Endpoints

| Method | Endpoint          | Description                    |
|--------|-------------------|--------------------------------|
| POST   | `/api/items`      | Add new item (returns 201)     |
| GET    | `/api/items/{id}` | Get item by ID (returns 404 if not found) |
| GET    | `/api/items`      | Get all items (bonus endpoint) |

---

## Input Validation Rules
- `name`: Required, 2-50 characters
- `description`: Required, 10-500 characters  
- `price`: Required, must be a valid number
- `category`: Optional
  
---

## Sample Requests

**Add Item:**
```
  curl -X POST http://localhost:8080/api/items \
    -H "Content-Type: application/json" \
    -d '{
      "name": "iPhone 15 Pro",
      "description": "Latest iPhone with A17 Pro chip and titanium design",
      "price": 999.99,
      "category": "Electronics"
    }'
```
**Get Item:**
```
  curl http://localhost:8080/api/items/1
```
---

#**Quick Start (Local)**

1.Prerequisites:
```
  - Java 17+
  - Maven 3.6+
```
2.Clone & Run:
```
  mvn spring-boot:run

```
3.Test APIs:
```
  Server runs on http://localhost:8080
  Use curl/Postman for testing
```
---

#Validation Error Response
```json
  {
    "timestamp": "...",
    "status": 400,
    "error": "Bad Request",
    "errors": [
      {
        "field": "name",
        "message": "Name is required"
      }
    ]
  }
```
---

#**Test the Live Demo**
Once deployed, test with:

```text
POST [https://your-app.railway.app](https://item-api-production-0418.up.railway.app)/api/items
{
  "name": "Samsung Galaxy S24",
  "description": "Latest Android flagship with AI features",
  "price": 799.99,
  "category": "Mobile"
}

GET [https://your-app.railway.app](https://item-api-production-0418.up.railway.app)/api/items/1
```
