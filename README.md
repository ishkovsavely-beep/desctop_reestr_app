## 🚀 Работа с проектом

### Для новых участников команды:

1. **Клонируйте репозиторий:**
   ```bash
   git clone https://github.com/ВАШ-ЛОГИН/reestr-fx.git
   cd reestr-fx
   ```

2. **Настройте базу данных:**
   ```bash
   docker run --name reestr-postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=reestr -p 5432:5432 -d postgres:latest
   ```

3. **Настройте конфигурацию:**
   ```bash
   cp src/main/resources/application-example.properties src/main/resources/application.properties
   ```
   Отредактируйте `application.properties` - укажите свой пароль

4. **Соберите проект:**
   ```bash
   mvn clean install
   ```

5. **Запустите приложение:**
   - Запустите класс `Launcher.java` в IDE
   - Или выполните: `mvn javafx:run`

### Работа с Git

- **Перед началом работы:** `git pull` (получить обновления)
- **После изменений:** 
  ```bash
  git add .
  git commit -m "описание изменений"
  git push
  ```
