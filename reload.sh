docker compose down
# maven clean will remove the "target" directory. This directory contains build artifacts, such as class and jar files
./mvnw clean

# maven compile will create a "target" directory if one does not already exist and will fill it with class files.
./mvnw compile

# maven package creates a jar file
./mvnw package

docker compose up --force-recreate --build