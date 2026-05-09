# DEVELOPMENT NOTES

## Overall Approach

Solution uses a layered architecture with clear separation between API(Controller), business logic(Service) and persistence(repository).

The application flow is:

1. Receive loan application request
2. Validate request payload using Bean Validation
3. Get applicant risk band based on credit score
4. Calculate final interest rate based on different criteria
5. Calculate EMI using EMI formula
6. Evaluate eligibility rules
7. Generate approval/rejection decision
8. Persist application details along with final decision state
9. Return API response


---

# Key Design Decisions

## 1. Layered Architecture

The project is organized into:

- Controller layer
- Service layer
- Repository layer
- DTO layer
- Entity layer
- Mapper layer
- Exception handling layer

This separation improves maintainability, readability, and testability.

---

## 2. DTO and Entity Separation

Request/response DTOs were intentionally separated from persistence entities.

Benefits:
- Prevents exposing internal persistence models
- Enables API evolution independently
- Simplifies validation handling

---

## 3. Dedicated Mapper Layer

Manual mapper classes were introduced to transform:

- Request DTO and Response DTO → Entity

This keeps controllers and services free from mapping logic and improves code organization.

---

## 4. BigDecimal for Financial Calculations

All monetary calculations use BigDecimal with:

- scale = 2
- RoundingMode.HALF_UP

This avoids floating-point precision issues common in financial systems.

---

## 5. Centralized Exception Handling

A global exception handler was implemented using:

@RestControllerAdvice

This ensures:
- Consistent API error responses
- Cleaner controller logic
- Better client experience

---

## 6. Audit-Friendly Persistence

Loan application decisions are persisted with:
- application details
- risk band
- rejection reasons
- generated offer
- timestamps

This supports traceability and future compliance requirements.

---

# Trade-offs Considered


## 1. H2 Database vs External Database

Chosen:
- H2 in-memory database

Reason:
- Faster local setup
- Simpler execution for reviewers

Trade-off:
- No persistence across restarts

---

## 2. Simple Service-Based Rules vs Rule Engine

Chosen:
- Service-based business logic

Reason:
- Easier readability
- Less complexity
- Faster implementation

Trade-off:
- Rules become harder to manage as system grows

---

## 3. Synchronous vs Asynchronous Processing

Chosen:
- Synchronous request processing

Reason:
- Simpler architecture
- Immediate response generation

Trade-off:
- Less scalable for very high throughput systems

---

# Assumptions Made

## 1. EMI Calculation

Assumed:
- Monthly compounding interest
- Standard EMI formula

---

## 2. Base Interest Rate

Assumed:
- Base annual interest rate remains fixed at 12%

No external configuration used.

---

## 3. Ambiguity in EMI Rules

The assignment contains two related conditions:

- Reject if EMI > 60% of monthly income
- Offer valid only if EMI ≤ 50%

Implementation assumption:
- Applications with EMI > 50% are rejected and records explicit rejection reason

---

# Improvements with More Time

## 1. Add Swagger/OpenAPI Documentation

Would expose:
- API contracts
- request/response schemas
- error models

---

## 2. Externalize Business Rules

Interest rates and thresholds could be externalized to support dynamic policy changes:
- database tables
- config server

---

## 3. Add Observability

Could introduce:
- structured logging
- distributed tracing
- monitoring dashboards

---

## 4. Add Docker Support

Would improve:
- portability
- local development

---

## 5. Add CI/CD Pipeline

Could include:
- build
- tests
- code coverage reporting
- deploy

---

## 6. Add Security

Future improvements:
- authentication
- authorization
- rate limiting
