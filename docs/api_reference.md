# StrathosNet API Reference

## Overview
This document provides a reference for the APIs available in the StrathosNet-Core framework.

## Authentication API
### Endpoint
`POST /api/auth/login`

### Request
```json
1 {
2   "username": "string",
3   "password": "string"
4 }
```

**Response**
```json
1 {
2   "token": "string",
3   "expires_in": "integer"
4 }
```

## User Management API
- **Get User Profile**
- **Endpoint**
GET /api/users/{userId}

**Response**
```json
1 {
2   "userId": "string",
3   "username": "string",
4   "email": "string",
5   "profile": {
6     "preferences": "object"
7   }
8 }
```

## Satellite Management API
- **List Satellites**
- **Endpoint**
GET /api/satellites

**Response**
```json
1 [
2   {
3     "satelliteId": "string",
4     "status": "string",
5     "location": "string"
6   }
7 ]
```

## Conclusion
For more detailed information on each API, including error codes and examples, please refer to the source code and additional ddocumentation

