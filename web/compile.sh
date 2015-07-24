sh stop.sh
mvn clean
mvn -DskipTests package
sh deploy.sh
sh start.sh
sh tail.sh
