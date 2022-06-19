Step 1: docker-compose down && docker-compose up -d
Step 2: mvn clean install && java -jar target/smartx-iproxy-0.0.1-SNAPSHOT.jar
Step 3: python3 smartX-iTunnels/tunnelConsumer.py
Step 4: Launch Postman & launch smartX-iProxy-test/smartX_iProxy_System.postman_collection.json
Step 5: Hit http://localhost:9090/kafka/publish?message=helloworld17, you will see the message in the console of python3 window