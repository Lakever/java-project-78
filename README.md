

### Hexlet tests and linter status:
[![Actions Status](https://github.com/Lakever/java-project-78/actions/workflows/hexlet-check.yml/badge.svg)](https://github.com/Lakever/java-project-78/actions)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=Lakever_java-project-78&metric=coverage)](https://sonarcloud.io/summary/new_code?id=Lakever_java-project-78)

# Валидатор данных
Это учебный проект Приложение представляет собой библиотеку для валидации данных с поддержкой различных схем (строк, чисел, словарей). 
Проект создан для закрепления навыков работы проектирования и тестирования, а в дальнейшем возможна и интеграция библиотеки с другим приложением.

Были реализованы паттерны проектирования: Fluent interface, Factory.
Закреплена работа с дженериками, лямбда-выражениями и функциональными интерфейсами.

Проект включает в себя:
- Классы для создания схем валидации (`StringSchema`, `NumberSchema`, `MapSchema`).
- Поддержку ограничений (например, `required`, `positive`, `range`).
- Тесты для проверки функциональности с использованием JUnit.

# Использованы
- [Java 23 или выше](https://adoptopenjdk.net/)
- [Gradle](https://gradle.org/install/)

# Установка 
```bash
git clone https://github.com/Lakever/java-project-78.git
cd java-project-78