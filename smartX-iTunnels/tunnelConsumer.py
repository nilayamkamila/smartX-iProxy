# Import KafkaConsumer from Kafka library
from kafka import KafkaConsumer

# Import sys module
import sys

# Define server with port
bootstrap_servers = ['localhost:39092']

# Define topic name from where the message will recieve
topicName = 'iProxy_Topic'

# Initialize consumer variable
consumer = KafkaConsumer (topicName, group_id ='iProxy_Group_Id',bootstrap_servers =
   bootstrap_servers)

# Read and print message from consumer
print("hello")
for msg in consumer:
#print(msg)
    print("Topic Name=%s,Message=%s"%(msg.topic,msg.value))

# Terminate the script
sys.exit()