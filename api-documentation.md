# API Documentation: Transición Energética Justa

## Authentication

### Login

Authenticate a user and receive a JWT token.

**Endpoint:** `POST /api/v1/auth/login`

**Request:**

```json
{
  "cedula": "1234567890",
  "password": "securepassword"
}
```

**Response:**

```json
{
  "status": 200,
  "data": {
    "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
    "cedula": "1234567890",
    "nombre": "John",
    "apellidos": "Doe",
    "email": "john.doe@example.com",
    "rol": "USER"
  },
  "message": "Login successful",
  "error": null
}
```

### Register

Register a new user.

**Endpoint:** `POST /api/v1/auth/register`

**Request:**

```json
{
  "cedula": "1234567890",
  "nombre": "John",
  "apellidos": "Doe",
  "email": "john.doe@example.com",
  "password": "securepassword"
}
```

**Response:**

```json
{
  "status": 201,
  "data": "User registered successfully",
  "message": null,
  "error": null
}
```

## Energy Data

### Get Production Total by Type and Region

Retrieve the total energy production by type and region for a specific year.

**Endpoint:** `GET /api/v1/energia/produccion-total/{anio}`

**Parameters:**
- `anio`: The year for which to retrieve data (e.g., "2023")

**Response:**

```json
{
  "status": 200,
  "data": [
    {
      "tipoEnergia": "Solar",
      "region": "Europa",
      "produccionTotal": 1500.5
    },
    {
      "tipoEnergia": "Eólica",
      "region": "América del Norte",
      "produccionTotal": 2000.75
    }
  ],
  "message": null,
  "error": null
}
```

### Get Percentage of Renewable Energy by Region

Retrieve the percentage of renewable energy in the total electric consumption for each region.

**Endpoint:** `GET /api/v1/energia/porcentaje-renovable`

**Response:**

```json
{
  "status": 200,
  "data": [
    {
      "region": "Europa",
      "porcentajeRenovable": 35.5
    },
    {
      "region": "América del Norte",
      "porcentajeRenovable": 28.3
    }
  ],
  "message": null,
  "error": null
}
```

### Get Trend of Installed Solar Capacity

Retrieve the trend of installed solar energy capacity over the years.

**Endpoint:** `GET /api/v1/energia/tendencia-capacidad-instalada`

**Response:**

```json
{
  "status": 200,
  "data": [
    {
      "anio": "2020",
      "capacidadInstalada": 580.5
    },
    {
      "anio": "2021",
      "capacidadInstalada": 650.2
    },
    {
      "anio": "2022",
      "capacidadInstalada": 730.8
    }
  ],
  "message": null,
  "error": null
}
```

### Get Top 10 Countries in Wind Energy Production

Retrieve the top 10 countries in wind energy production for a specific year.

**Endpoint:** `GET /api/v1/energia/top-10-eolica/{anio}`

**Parameters:**
- `anio`: The year for which to retrieve data (e.g., "2023")

**Response:**

```json
{
  "status": 200,
  "data": [
    {
      "pais": "China",
      "produccionEolica": 3500.5
    },
    {
      "pais": "Estados Unidos",
      "produccionEolica": 2800.3
    }
  ],
  "message": null,
  "error": null
}
```

### Get Energy Sources and Their Participation

Retrieve all energy sources and their participation in the total energy consumption.

**Endpoint:** `GET /api/v1/energia/fuentes-participacion`

**Response:**

```json
{
  "status": 200,
  "data": [
    {
      "fuenteEnergia": "Solar",
      "participacion": 15.5
    },
    {
      "fuenteEnergia": "Eólica",
      "participacion": 20.3
    },
    {
      "fuenteEnergia": "Hidroeléctrica",
      "participacion": 18.7
    }
  ],
  "message": null,
  "error": null
}
```

## Error Responses

In case of errors, the API will return a response in the following format:

```json
{
  "status": 400,
  "data": null,
  "message": "Error description",
  "error": "Error type"
}
```

Common error status codes:
- 400: Bad Request
- 401: Unauthorized
- 403: Forbidden
- 404: Not Found
- 500: Internal Server Error
```

This documentation provides an overview of the main endpoints in your Transición Energética Justa API, including authentication, energy data retrieval, and error handling. Each endpoint description includes the HTTP method, URL, required parameters (if any), and example responses. This format should help developers understand how to use your API effectively.