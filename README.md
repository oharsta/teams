# Teams server

## Getting started

### System Requirements

- Java 8
- Maven 3
- MySQL 5.5+

### Create database

Connect to your local mysql database: `mysql -uroot`

Execute the following:

```sql
CREATE DATABASE teamsserver;
create user 'root'@'localhost';
grant all on teamsserver.* to 'root'@'localhost';
```

## Building and running

http://localhost:8080/teams/api/teams/search/findByNameContaining?name=iders&projection=summary

