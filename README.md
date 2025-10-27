# 🛒 Shopping Cart - Hexagonal Architecture (Java 21 + Gradle)

A simple yet clean example of applying **Hexagonal Architecture** in Java, using a shopping cart domain.  
It demonstrates separation between **domain**, **use cases**, and **adapters**, with clear boundaries and unit tests.

---

## 📦 Project Structure

```
shopping-cart/
├── build.gradle
├── settings.gradle
├── src/
│   ├── main/java/co/favelezr/highspring/
│   │   ├── domain/
│   │   │   ├── Item.java
│   │   │   ├── ItemCategory.java
│   │   │   └── ShoppingCart.java
│   │   ├── usecase/
│   │   │   └── CalculateCartTotalUseCase.java
│   │   ├── service/
│   │   │   └── ShoppingCartService.java
│   │   ├── adapter/
│   │   │   ├── ItemRepository.java
│   │   │   └── InMemoryItemRepository.java
│   │   └── Main.java
│   └── test/java/co/favelezr/highspring/
│   │   ├── application.service/
│   │   │   └── ShoppingCartServiceTest.java
│   │   ├── domain.model/
│   │   │   └── ItemTest.java

```

---

## 🚀 How to Run

### Run the application
```bash
./gradlew run
```

### Run tests
```bash
./gradlew test
```

---

## 🧠 Design Highlights

- **Hexagonal Architecture (Ports & Adapters)**  
  Business logic is decoupled from frameworks and external dependencies.

- **Use Cases as entry points**  
  `CalculateCartTotalUseCase` defines the system’s capabilities.

- **BigDecimal for precision**  
  Financial calculations use `BigDecimal` to avoid floating-point rounding errors.

---

## ✅ Example Output

```
Subtotal: $2,479.00
Tax: $210.72
Total: $2,689.72
```

---

## 🧪 Testing

Unit tests ensure:
- Correct subtotal, tax, and total calculations  
- Proper handling of discounts per category  
- Graceful handling of empty carts

---

## 👨‍💻 Requirements

- Java 17+
- Gradle 8+

---

## 🧩 Author
**Fabian Vélez**  
Clean Architecture enthusiast | Java Developer
