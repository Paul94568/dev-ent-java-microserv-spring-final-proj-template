# CHEAPER
Spring Final Project 

Cheaper is a microservice that gives the user make informed purchases.
It allows users to compare the prices of products in different stores.

**Get All Products**
----
Returns json data about all products.

* **URL**

    /api/products/

* **Method:**

    `GET`

*  **URL Params**
   
    None

* **Data Params**

    None

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** `[
      {
      "productId": 3,
      "productName": "Coca-Cola Soda Pop Cherry Vanilla",
      "productDescription": "6-16.9 fl oz",
      "stocks": [
      {
      "stockId": 7,
      "storeName": "Safeway",
      "price": 4.99
      }
      ]
      }
      ]`

* **Error Response:**

    * **Code:** 404 Not Found <br />
      **Content:** `{}`

**Get Product By ID**
----
Returns json data about a single product.

* **URL**

  /api/products/:id

* **Method:**

    `GET`

*  **URL Params**

    **Required:**

    `id=[integer]`

* **Data Params**

    None

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** `[
      {
      "productId": 3,
      "productName": "Coca-Cola Soda Pop Cherry Vanilla",
      "productDescription": "6-16.9 fl oz",
      "stocks": [
      {
      "stockId": 7,
      "storeName": "Safeway",
      "price": 4.99
      }
      ]
      }
      ]`

* **Error Response:**

    * **Code:** 404 Not Found <br />
      **Content:** `{}`

**Get Product By Name**
----
Returns json data about all products which contains the specified string in its name.

* **URL**

  /api/products/:name

* **Method:**

  `GET`

*  **URL Params**

   **Required:**

   `name=[string]`

* **Data Params**

  None

* **Success Response:**

    * **Code:** 200 <br />
      **Content:** `[
      {
      "productId": 3,
      "productName": "Coca-Cola Soda Pop Cherry Vanilla",
      "productDescription": "6-16.9 fl oz",
      "stocks": [
      {
      "stockId": 7,
      "storeName": "Safeway",
      "price": 4.99
      }
      ]
      }
      ]`

* **Error Response:**

    * **Code:** 204 No Content <br />
      **Content:** `{}`

**Insert a Product**
----
Adds a new Product.

* **URL**

  /api/products/

* **Method:**

  `POST`

*  **URL Params**

    None
   
* **Data Params**

  **Required:**
  
  `{
  "productName": "Hanes Premium Men's X-Temp Ultra Cushion Crew Socks",
  "productDescription": "Pack of 6 pairs"
  }`

* **Success Response:**

    * **Code:** 201 Created<br />
      **Headers - Location** `http://localhost:8080/api/products/8`

* **Error Response:**

    * **Code:** 500 Internal Server Error <br />
      **Content:** `{}`

**Delete a Product**
----
Deletes an existing Product.

* **URL**

  /api/products/:id

* **Method:**

  `DELETE`

*  **URL Params**

   **Required:**

   `id=[integer]`

* **Data Params**

  None

* **Success Response:**

    * **Code:** 200 OK<br />
      **Content:** `{}`

* **Error Response:**

    * **Code:** 500 Internal Server Error <br />
      **Content:** `{}`
      
**Update a Product**
----
Updates an existing Product.

* **URL**

  /api/products/:id

* **Method:**

  `PUT`

*  **URL Params**

    **Required:**

    `id=[integer]`

* **Data Params**

  **Required:**

  `{
  "productId":9,
  "productName": "Hanes Premium Men's X-Temp Ultra Cushion Crew Socks",
  "productDescription": "Pack of 6 pairs"
  }`

* **Success Response:**

    * **Code:** 200 OK<br />
      **Content:** `{"productId":8,"productName":"Hanes Premium Men's X-Temp Ultra Cushion Crew Socks","productDescription":"Pack of 6 pairs","stocks":[]}`

* **Error Response:**

    * **Code:** 500 Internal Server Error <br />
      **Content:** `{}`