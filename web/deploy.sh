rm -rf ./tomcat/webapps/ROOT.war
rm -rf ./tomcat/webapps/ROOT
cp -v -i ./target/infopadron_0.0.1-SNAPSHOT.war ./tomcat/webapps/ROOT.war
ls -lah ./tomcat/webapps
