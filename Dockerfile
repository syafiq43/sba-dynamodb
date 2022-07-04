FROM adoptopenjdk:11-jre

COPY target/*.jar app.jar

ENTRYPOINT ["java"]
CMD ["-jar","/app.jar"]



# docker build -t brainupgrade/sba-dynamodb:1.0.0 .

# k create deploy sba-dynamodb --image brainupgrade/sba-dynamodb:1.0.0

# k set env deploy sba-dynamodb --env reqion  --env access=key --env secret=key --env sqs=endpoint --env aws.dynamodb.endpoint=dynamodb.us-east-1.amazonaws.com

