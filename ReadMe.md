Step 1: docker-compose down && docker-compose up -d\
Step 2: mvn clean install && java -jar target/smartx-iproxy-0.0.1-SNAPSHOT.jar\
Step 3: python3 smartX-iTunnels/tunnelConsumer.py\
Step 4: Launch Postman & launch smartX-iProxy-test/smartX_iProxy_System.postman_collection.json\
Step 5: Hit http://localhost:9090/kafka/publish?message=helloworld17, you will see the message in the console of python3 window\

Module: smartX-iBrains
Introduction:

This module consists of 4 different Modules
- source-module: 
  - Read Data from the data-module/ExperienceSalaryProxyForward_Data.csv, Evaluate and Build the Intelligent Models
  - Data Model: Data Model file gerenarated in model-module/ExperienceSalaryModel.pkl
  - ProxyForward Model: ProxyForward Model file generated in model-module/ExperienceForwardToModel.pkl

Execution Steps:
- python3 source-module/LoadEvaluateModel.py 
- Verify that you have 2 files generated in model-module folder 

api-module
- Run the Model with the command as
- python3 api-module/iBrains-decisions.py

Run the Proxy:
After you run the api-module of smartX-iBrains, you run the SmartXiProxySpringBootApplication.java through IntelliJ Or through the command "mvn clean install && java -jar target/smartx-iproxy-0.0.1-SNAPSHOT.jar"
Hit the URL : http://localhost:9090/proxy/predict/data?message=7.0
You will receive the response as follows:
{
"experience": "7.0",
"forwardTo": "1.728876089370753",
"salary": "91288.29027299365"
}
==================================================================


 
