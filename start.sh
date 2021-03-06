mvn package

stop-yarn.sh
stop-dfs.sh

rm -rf ~/hdata/namenode
rm -rf ~/hdata/datanode

mkdir ~/hdata/namenode
mkdir ~/hdata/datanode

hdfs namenode -format

start-dfs.sh
start-yarn.sh

hdfs dfs -rm -r -f /user

hdfs dfs -mkdir /user
hdfs dfs -mkdir /user/julia


hadoop fs -rm -r -f  hdfs://localhost:9000/user/julia/output
hadoop fs -copyFromLocal data/flight.csv
hadoop fs -copyFromLocal data/airport.csv

spark-submit --class iu9.AnalyzeAirportsApp --master yarn-client --num-executors 3 target/spark-examples-1.0-SNAPSHOT.jar
hadoop fs -copyToLocal output