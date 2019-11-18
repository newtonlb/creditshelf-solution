# Creditshelf solution
This repository is a solution for the creditshelf code challenge

## How to run

The repository uses Maven for packaging.

``` ./mvnw install ```

This will generate the latest version of the jar

You can simply generate the docker image from the `Dockerfile`

```docker build . -t creditshelf-solution```

And finally start the container

```docker run creditshelf-solution -p 8080:8080```

You can locate the server running on [http://localhost:8080/]


## How to use

In the homepage, there are two forms, one for the Products/Company CSV and another for the Sales CSV.
Please upload them accordingly.


### Get sales by Company

You can get the sales by company through the endpoint

```GET http://localhost:8080/sales?companyName=Name+of+the+company```

This will return an object in this format
```
"response":[  
      {  
         "orderNumber":1,
         "orderDate":1546642800000,
         "total":164.83,
         "products":[  
            {  
               "productId":2,
               "orderId":1,
               "companyName":"Acme corporation",
               "salePrice":18.12,
               "currency":"EUR",
               "quantity":3
            },
            {  
               "productId":4,
               "orderId":1,
               "companyName":"Acme corporation",
               "salePrice":5.43,
               "currency":"EUR",
               "quantity":12
            }
            ...
            ]}
```

### Get Revenue by company

  You can get the revenue report by company through the endpoint:
  
  ```GET http://localhost:8080/revenuesReport?companyName=Name+of+the+company```
  
### Get profit by company

You can get the profit report by company through the endpoint:
  
  ```GET http://localhost:8080/profitReport?companyName=Name+of+the+company```
  
  
## Limitations

Due to the lack of time, there are several limitations in the solution which needs to be addressed if more time is given

- There are no tests
- The CSV parser doesn't support different column names (dictionary table)
- No proper error handling (catch expeptions, return http error codes)
- Interface is not friendly

If possible, I will update this repository with thos improvements.

