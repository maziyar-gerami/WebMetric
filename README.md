
# WebMetricCodeChallenge

## Overview
The **WebMetricCodeChallenge** is a Java-based code challenge project designed to analyze and process web metrics. The primary objective is to manage advertiser data and calculate recommendations based on metrics such as revenue per impression for different apps and countries.

## Project Structure

- **Java**: The primary programming language used for backend logic.
- **Hibernate**: ORM (Object-Relational Mapping) tool used for interacting with the database.
- **MySQL**: The database used for storing data, with UUIDs stored as `char(36)`.

## Getting Started

### Prerequisites

Before running this project, you will need the following:

- **Java JDK 8 or later** installed on your machine.
- **MySQL** installed and running.
- Basic knowledge of Hibernate ORM and MySQL.

### Database Setup

1. Create a new MySQL database.  
   You can use the following SQL command to create it:

   ```sql
   CREATE DATABASE webmetric_challenge;
   ```

2. Import the provided SQL file into the MySQL database to set up the required tables and initial data.

   ```bash
   mysql -u yourUsername -p webmetric_challenge < path_to_sql_file.sql
   ```

### Configuring Database Connection

The database connection configuration is done via the `hibernate.cfg.xml` file. Before running the application, ensure you have updated the following settings in `hibernate.cfg.xml` to match your local MySQL setup:

```xml
<property name="hibernate.connection.username">yourUsername</property>
<property name="hibernate.connection.password">yourPassword</property>
<property name="hibernate.connection.url">jdbc:mysql://localhost:3306/webmetric_challenge</property>
```

### Running the Project

Since this project does not have a web interface or executable file, there is no command to run. The logic can be executed by running the Java code directly from your IDE (such as IntelliJ IDEA, Eclipse, etc.) after configuring the database.

### How it Works

The core functionality revolves around processing advertiser metrics and generating recommendations for the top 5 advertisers based on revenue per impression for a specific app and country combination.

