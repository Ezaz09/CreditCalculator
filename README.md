# Credit calculator
Данное приложение производит расчет графика платежей по кредиту.
Используемый способ расчета начисленных процентов по кредиту - аннуитетный.

Пример расчета и формулы по данному способу можно посмотреть по ссылке - https://www.raiffeisen.ru/wiki/kak-rasschitat-procenty-po-kreditu/.

# Libraries
- backend
    - JDK 11
    - Lombok 1.18.16
    - Spring Boot
    - Decimal4j
- frontend 
    - Vue.js
    
# How to run 
- После загрузки репозитория, в IDE для Java создать проект, выбрать папку "task" из репозитория
- В файле "application.properties", который находиться в папке "task\src\main\resources", указать порт, который будет использоваться проектом

- Если требуется внести какие-либо правки во frontend, то в папке "front_for_task" нужно выполнить команду "npm install"
- В файле "index.js", который находиться в папке "src/api", расскоментировать параметр "baseURL", который помечен комментарием "dev", и указать порт, который использует Java, закомментировать параметр "baseURL", который помечен комментарием "prod"
- Чтобы запустить frontend в тестовом режиме - npm run serve 
- Чтобы выполнить сборку, в файле "index.js" закомментировать параметр "baseURL", который помечен комментарием "dev", и расскоментировать параметр "baseURL", который помечен комментарием "prod". Выполнить команду - npm run build. Все файлы, кроме "index.html", из папки "dist" скопировать в папку "task\src\main\resources\static", index.html скопировать в "task\src\main\resources\templates" 
