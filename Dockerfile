FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=gazetawroclawska_bot
ENV BOT_TOKEN=1906877601:AAHNACDy8SETXXamT9jUYHqS72f-DP15iA4
#Enviroment bot_db_username and bot_db_password is default. I set username and password in bash-script 'start'
ENV BOT_DB_USERNAME=bot_db_username
ENV BOT_DB_PASSWORD=bot_db_password
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}","-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dbot.username=${BOT_NAME}", "-jar", "/app.jar"]