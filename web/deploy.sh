rm -rf ./tomcat/webapps/ROOT.war
rm -rf ./tomcat/webapps/ROOT
cp -v -i ./target/agk_web_1.1.0-SNAPSHOT.war ./tomcat/webapps/ROOT.war
ls -lah ./tomcat/webapps
