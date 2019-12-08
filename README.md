# Services participating in saga

- Order-service
- Inventory-service
- Payment-service
- Shipping-service
- Notification-service

### orchestrator in saga
- orchestration-service

###  Build the project - 
mvn clean </br>
mvn install

### Start transaction in saga by order post endpoint``

POST Endpoint : http://localhost:8891/v1/orders/ </br>
Paylaod - 
{
	"itemId" : 2,
	"customerId" :1
}


### orchestration flow





[![flow](https://techrocking.com/wp-content/uploads/2019/12/orchestrator-pattern.png "flow")](https://techrocking.com/wp-content/uploads/2019/12/orchestrator-pattern.png "flow")

