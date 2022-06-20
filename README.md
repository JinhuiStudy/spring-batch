# spring-batch

### Notion: https://highfalutin-giant-304.notion.site/Spring-Batch-be9c44077c59426d82d8c17c0efc4b9a

### 과정
### 메뉴에서 런타임을 클릭 합니다. http-ingest.log 을 클릭합니다. stdout 대시보드의 텍스트 상자에 경로 복사
##### curl http://localhost:20100 -H "Content-type: text/plain" -d "Happy streaming"
##### docker exec -it skipper tail -f 

### Program Argument Add
##### clients=file:files/clients.txt clientsMulti=file:files/clients-multi.txt clientsMultics=file:files/clients-multi-*.txt

### 참고 링크 
#### 1. 스프링 배치 - 개요 
##### https://giuliana-bezerra.medium.com/spring-batch-para-desenvolvimento-de-jobs-1674ec5b9a20
#### 2. 배치 처리를 위해 스프링 배치를 사용해야하는 이유 
##### https://giuliana-bezerra.medium.com/why-you-should-be-using-spring-batch-for-batch-processing-83f5aafb965f
#### 3. Job 
##### https://giuliana-bezerra.medium.com/desenvolvimento-com-spring-batch-jobs-b4363dd6c676
#### 4. Step 
##### https://giuliana-bezerra.medium.com/desenvolvimento-com-spring-batch-steps-4d42af2696ec
#### 5. Reading Information From a REST API 
##### https://www.petrikainulainen.net/programming/spring-framework/spring-batch-tutorial-reading-information-from-a-rest-api/
#### 6. Kafka Spring Batch Tip (Github) 
##### https://github.com/spring-tips/kafka-and-spring-batch/blob/master/src/main/java/com/example/bk/consumer/ConsumerApplication.java

### Query
CREATE TABLE IF NOT EXISTS BILL_STATEMENTS
(
id int,
first_name varchar(50),
last_name varchar(50),
minutes int,
data_usage int,
bill_amount decimal(10,2)
);