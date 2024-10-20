# Тестовое задание Разработка упрощенной CRM-системы

1. [Описание](#описание)
2. [Примеры использования](#примеры-использования-api)
3. [Зависимости](#зависимости)
4. [Сборка проекта](#сборка-проекта)

## Описание:
CRM-система, которая будет управлять информацией о продавцах и их
транзакциях. Система должна включать возможности для создания, чтения, обновления и
удаления данных о продавцах и транзакциях. Система также должна включать функции аналитики
для обработки и анализа данных.

## Примеры использования api:

### Seller

| Method | Url                      | Decription                     | Sample Valid Request Body    | 
|--------|--------------------------|:-------------------------------|------------------------------|
| GET    | /seller                  | get all sellers                |                              |
| GET    | /seller/{id}             | get seller by id               |                              |
| POST   | /seller/create           | create new seller              | [JSON](#create_seller)       |
| PATCH  | /seller/update/{id}      | update seller by id            | [JSON](#update_seller_by_id) |
| DELETE | /seller/delete/{id}      | delete seller by id            |                              |
| GET    | /seller/mostProductivity | get most productivity seller   | [JSON](#mostProduct)         |
| GET    | /seller/withLessAmount   | get less productivity seller   | [JSON](#lessProduct)         |



### Transaction

| Method | Url                      | Decription          | Sample Valid Request Body   | 
|--------|--------------------------|---------------------|-----------------------------|
| GET    | /transaction             | get all sellers     |                             |
| GET    | /transaction/{id}        | get seller by id    |                             |
| GET    | /transaction/seller/{id} | create new seller   |                             |
| POST   | /transaction/create      | update seller by id | [JSON](#transaction_create) |


## Sample Valid JSON Request Bodys


##### <a id="create_seller">create seller -> /seller/create</a>
```json
{
    "id": 2,
    "name": "Sasha",
    "contactInfo": "dma@company.com",
    "registrationDate": "2024-10-20T04:53:04.347083"
}
```

##### <a id="update_seller_by_id">create seller -> /seller/create</a>
```json
{
  "name": "Sasha"
}
```

```json
{
  "contactInfo": "dma@company.com"
}
```
```json
{
  "name": "Sasha",
  "contactInfo": "dma@company.com"
}
```

##### <a id="mostProduct">get most productivity seller -> /seller/mostProductivity</a>
```json
{
    "startPeriod": "2024-10-20T07:44:03.533779",
    "endPeriod": "2024-10-20T07:55:03.533779"
}
```
##### <a id="lessProduct">get less productivity seller -> /seller/withLessAmount</a>
```json
{
  "startPeriod": "2024-10-20T07:44:03.533779",
  "endPeriod": "2024-10-20T07:55:03.533779",
  "maxAmount": 11
}
```
##### <a id="transaction_create">update seller by id -> /transaction/create</a>
```json
{
  "sellerId": 1,
  "amount": 10,
  "paymentType": "CASH"
}
```


## Зависимости

```
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter'
    implementation 'org.springframework.boot:spring-boot-starter-web'
    implementation 'org.springframework.boot:spring-boot-starter-data-jpa'
    
    implementation 'jakarta.validation:jakarta.validation-api'
    
    implementation 'org.mapstruct:mapstruct:1.6.2'
    annotationProcessor 'org.mapstruct:mapstruct-processor:1.6.2'
    
    implementation 'org.postgresql:postgresql'
    
    compileOnly 'org.projectlombok:lombok'
    annotationProcessor 'org.projectlombok:lombok'
    
    testImplementation 'org.springframework.boot:spring-boot-starter-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```

## Сборка проекта:

Требования
* Установленный JDK (версия 21)
* Установленный Gradle
* Установленный PostgreSql

1. Создание базы данных db_crm и запуск \
Если используя команды postgres:
```
createdb db_crm
initdb db_crm
pg_ctl -D db_crm -l logfile start
```
Название базы данных, username и password базы данных \
можно изменить в файле конфигурации application.properties


2. Сборка и запуск
```
./gradle wrapper
./gradlew bootRun
```

