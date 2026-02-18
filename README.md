# Учебный Java-проект

Минимальный проект для изучения Java и запуска тестов. Работает на Windows и macOS.

## Что нужно установить

1. **Java 21** — язык, на котором написан проект.
2. **Maven** — программа для сборки проекта и запуска тестов.

---

## Шаг 1: Проверить, что Java установлена

Откройте терминал (командную строку) и введите:

**Windows (cmd или PowerShell):**
```cmd
java -version
```

**macOS (Терминал):**
```bash
java -version
```

Должна появиться строка с версией, например: `openjdk version "21"` или `java version "21"`.  
Если команда не найдена — установите [Java 21](https://adoptium.net/).

---

## Шаг 2: Проверить, что Maven установлен

В том же терминале введите:

**Windows:**
```cmd
mvn -version
```

**macOS:**
```bash
mvn -version
```

Должна появиться информация о Maven.  
Если команда не найдена — установите [Maven](https://maven.apache.org/download.cgi).

---

## Шаг 3: Сборка проекта

Перейдите в папку проекта (там, где лежит файл `pom.xml`), затем выполните:

**Windows:**
```cmd
mvn compile
```

**macOS:**
```bash
mvn compile
```

Команда `mvn compile` скомпилирует код. В конце должно быть `BUILD SUCCESS`.

---

## Шаг 4: Запуск приложения

Сначала соберите проект (если ещё не собирали), затем запустите класс:

**Windows:**
```cmd
mvn compile
java -cp target/classes com.learning.App
```

**macOS:**
```bash
mvn compile
java -cp target/classes com.learning.App
```

Вы должны увидеть:
- «Проект успешно запущен!»
- Пример: 2 + 3 = 5

---

## Шаг 5: Запуск тестов

**Windows:**
```cmd
mvn test
```

**macOS:**
```bash
mvn test
```

Команда запустит тесты JUnit 5. В конце должно быть `BUILD SUCCESS` и сообщение о количестве пройденных тестов.

---

## Структура проекта

```
java-learning-project/
├── README.md
├── pom.xml
├── .gitignore
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/learning/
│   │           └── App.java
│   └── test/
│       └── java/
│           └── com/learning/
│               └── AppTest.java
```

- **pom.xml** — настройки проекта и зависимости (в том числе JUnit 5).
- **App.java** — класс с методом `main` и методом `add` (сложение двух чисел).
- **AppTest.java** — тест, который проверяет метод `add`.

Удачи в обучении!
