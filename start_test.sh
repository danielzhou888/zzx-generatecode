echo '---Begin---'

git pull

port=`ps -ef | grep scmd-generagecode-1.0.jar | grep -v grep | awk '{print $2}'`

kill -9 $port

mvn clean install -P beta

cd target/

nohup java -jar scmd-generagecode-1.0.jar &

cd target/

tail -f 199 nohup.out

echo '---End---'
