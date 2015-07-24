sh stop.sh
mvn clean
/Users/willynx/git/agriket-web/scripts/lib/mvn -DskipTests package
sh deploy.sh
sh start.sh
sh tail.sh
