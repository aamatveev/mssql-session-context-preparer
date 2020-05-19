mssql-session-context-preparer
=====================

[on GitHub](https://github.com/aamatveev/mssql-session-context-preparer)

#### Steps

Configure MS SQL SERVER as in this [article](https://docs.microsoft.com/ru-ru/sql/relational-databases/security/row-level-security?view=sql-server-ver15#c-scenario-for-users-who-connect-to-the-database-through-a-middle-tier-application)

1. Create a table to hold data.
```
CREATE TABLE sales (  
      order_id int IDENTITY(1,1) NOT NULL,  
      app_user_id int,  
      product varchar(10),  
      qty int  
);
```
2. Populate
```
INSERT Sales VALUES
      (1, 'Valve', 5),
      (1, 'Wheel', 2),
      (1, 'Valve', 4),  
      (2, 'Bracket', 2),
      (2, 'Wheel', 5),
      (2, 'Seat', 5);
```
2. Create schema and func
```
CREATE SCHEMA Security;  
GO  
CREATE FUNCTION Security.fn_securitypredicate(@AppUserId int)  
 RETURNS TABLE  
 WITH SCHEMABINDING  
AS  
 RETURN SELECT 1 AS fn_securitypredicate_result  
 WHERE  
     CAST(SESSION_CONTEXT(N'UserId') AS int) = @AppUserId;
GO
```
3. Create predicate
```
CREATE SECURITY POLICY Security.SalesFilter  
 ADD FILTER PREDICATE Security.fn_securitypredicate(app_user_id)
     ON dbo.Sales,  
 WITH (STATE = ON);
```
4. run app
5. open url http://localhost:8080/sales/1 and http://localhost:8080/sales/2
6 . compare results
