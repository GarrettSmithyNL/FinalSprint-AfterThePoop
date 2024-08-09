# FinalSprint-AfterThePoop
Final Sprint for Advanced Java 2024 - After The Poop Ecommerce CLI program

This program is based off of our teams previous sprint project made from a Database named "No more Poop",
which was based of a pet waste business that collected and cleaned pet waste. This program is about a second business that turns that waste into fertilizer, hence "After The Poop".

#Team Members: Garret Smith, Zach Ropson, and Rodney Stead

---
## User Documentation

### Overview
**After The Poop** is a Java-based application designed to facilitate the buying and selling of products, specifically fertilizer made from pet waste. Users can log in, register, and perform various actions based on their roles (e.g., buyer). The application uses a PostgreSQL database to store user and transaction data.

### Features
- **User Registration and Login**: Users can create accounts and log in to access the application.
- **Buyer Submenu**: Buyers can view all postings and purchase products.
- **Database Integration**: The application uses PostgreSQL for data storage.

### Class Descriptions

#### `MainMenu`
- **Purpose**: Entry point of the application where users can log in, register, or exit.
- **Methods**:
    - `mainMenu()`: Displays the main menu and handles user input for login, registration, and exit.
    - `main(String[] args)`: Main method to start the application.

#### `LoginMenu`
- **Purpose**: Handles user login functionality.
- **Methods**:
    - `loginMenu()`: Prompts the user for login credentials and validates them against the database.

#### `RegistrationMenu`
- **Purpose**: Handles user registration functionality.
- **Methods**:
    - `registrationMenu()`: Prompts the user for registration details and stores them in the database.

#### `SubMenu`
- **Purpose**: Displays options for buyers after they log in.
- **Methods**:
    - `subMenu(int userId)`: Displays the buyer submenu and handles user input for viewing postings and purchasing products.

#### `DBConnection`
- **Purpose**: Manages the database connection.
- **Methods**:
    - `getConnection()`: Establishes and returns a connection to the PostgreSQL database.

### How to Start the Application
1. Ensure you have Java and PostgreSQL installed on your system.
2. Clone the repository and navigate to the project directory.
3. Open the project in IntelliJ IDEA.
4. Configure the database connection in the application.
5. Run the `MainMenu` class to start the application.

### Class Diagram
Below is the class diagram showing the associations between the classes:

```plaintext
+------------------+       +------------------+
|    MainMenu      |<----->|    LoginMenu     |
+------------------+       +------------------+
| - running: bool  |       | - loginMenu()    |
| - mainMenu()     |       +------------------+
| - main()         |
+------------------+
       |
       |
       v
+------------------+       +------------------+
| RegistrationMenu |<----->|     SubMenu      |
+------------------+       +------------------+
| - registrationMenu() |   | - subMenu(int)   |
+------------------+       +------------------+
       |
       |
       v
+------------------+
|   DBConnection   |
+------------------+
| - getConnection()|
+------------------+
```
---
## Development Documentation

### Javadocs
To generate Javadocs for your project, you can use the following command in your terminal:

```sh
javadoc -d doc -sourcepath src -subpackages menu,utility
```

This command will generate the Javadocs in the `doc` directory for the `menu` and `utility` packages.

### Source Code Directory Structure
The source code directory structure for the project is as follows:

```
AfterThePoop/
├── src/
│   ├── menu/
│   │   ├── MainMenu.java
│   │   ├── LoginMenu.java
│   │   ├── RegistrationMenu.java
│   │   └── SubMenu.java
│   └── utility/
│       └── DBConnection.java
├── .idea/
│   ├── dataSources.local.xml
│   └── ...
├── README.md
└── ...
```

### Build Process
To compile the project, follow these steps:

1. Open the project in IntelliJ IDEA.
2. Ensure that the PostgreSQL JDBC driver is added to the project dependencies.
3. Navigate to the `MainMenu` class.
4. Click on the `Run` button or use the shortcut `Shift + F10` to compile and run the project.

### Compiler Time Dependencies
The project has the following compiler time dependencies:

- Java Development Kit (JDK) 8 or higher
- PostgreSQL JDBC Driver

### Development Standards
- **Code Formatting**: Follow standard Java coding conventions.
- **Comments**: Use Javadoc comments for classes and methods.
- **Version Control**: Use Git for version control. Commit changes with meaningful messages.

### Setting Up the Database for Development
1. Install PostgreSQL on your system.
2. Create a new database named `AfterThePoop`.
3. Update the database connection details in the `DBConnection` class: Be sure to replace "YourPassowrd" with yours.

```java
private static final String URL = "jdbc:postgresql://localhost:5432/AfterThePoop";
private static final String USER = "postgres";
private static final String PASSWORD = "YourPassword";
```

4. Run the SQL scripts to create the necessary tables and insert initial data.
- order of the tables is:
- 1. Users
- 2. Products
- 3. Orders
- 4. Transactions

```sql

### Getting the Source Code from the Repository
To get the source code from the repository, follow these steps:

1. Open a terminal.
2. Clone the repository using the following command:

```sh
git clone https://github.com/GarrettSmithyNL/FinalSprint-AfterThePoop.git
```

3. Navigate to the project directory:

```sh
cd FinalSprint-AfterThePoop
```

4. Open the project in IntelliJ IDEA.

---
## Deployment Documentation

### Prerequisites
- 1. **Java Development Kit (JDK) 8 or higher**: Ensure that JDK is installed on your system.
- 2. **PostgreSQL**: Install PostgreSQL on your system.
- 3. **IntelliJ IDEA**: Install IntelliJ IDEA for development and running the application.

### Installation Steps

#### 1. Clone the Repository
Open a terminal and run the following command to clone the repository:
```sh
git clone https://github.com/GarrettSmithyNL/FinalSprint-AfterThePoop.git
cd FinalSprint-AfterThePoop
```

#### 2. Set Up the Database
- 1. **Create Database**: Open PostgreSQL and create a new database named `AfterThePoop`.
- 2. **Update Database Connection**: Update the database connection details in the `DBConnection` class located at `src/utility/DBConnection.java`:
    ```java
    private static final String URL = "jdbc:postgresql://localhost:5432/AfterThePoop";
    private static final String USER = "postgres";
    private static final String PASSWORD = "YourPassword";
    ```
- 3. **Create Tables**: Run the following SQL scripts to create the necessary tables in the database:
    ```sql
    -- Create Users Table
    CREATE TABLE Users (
        user_id SERIAL PRIMARY KEY,
        username VARCHAR(50) NOT NULL UNIQUE,
        password VARCHAR(255) NOT NULL,
        role VARCHAR(20) NOT NULL
    );

    -- Create Products Table
    CREATE TABLE Products (
        product_id SERIAL PRIMARY KEY,
        product_name VARCHAR(100) NOT NULL,
        description TEXT,
        price DECIMAL(10, 2) NOT NULL
    );

    -- Create Postings Table
    CREATE TABLE Postings (
        posting_id SERIAL PRIMARY KEY,
        user_id INT NOT NULL,
        product_id INT NOT NULL,
        quantity INT NOT NULL,
        FOREIGN KEY (user_id) REFERENCES Users(user_id),
        FOREIGN KEY (product_id) REFERENCES Products(product_id)
    );

    -- Create Transactions Table
    CREATE TABLE Transactions (
        transaction_id SERIAL PRIMARY KEY,
        posting_id INT NOT NULL,
        buyer_id INT NOT NULL,
        transaction_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
        FOREIGN KEY (posting_id) REFERENCES Postings(posting_id),
        FOREIGN KEY (buyer_id) REFERENCES Users(user_id)
    );
    ```

#### 3. Configure IntelliJ IDEA
- 1. **Open Project**: Open IntelliJ IDEA and navigate to `File > Open` to open the cloned project directory.
- 2. **Add Dependencies**: Ensure that the PostgreSQL JDBC driver and jBCrypt library are added to the project dependencies. If using Maven, add the following to your `pom.xml`:
    ```xml
    <dependency>
        <groupId>org.postgresql</groupId>
        <artifactId>postgresql</artifactId>
        <version>42.2.5</version>
    </dependency>
    <dependency>
        <groupId>org.mindrot</groupId>
        <artifactId>jbcrypt</artifactId>
        <version>0.4</version>
    </dependency>
    ```

#### 4. Build and Run the Application
- 1. **Build Project**: Navigate to `Build > Build Project` in IntelliJ IDEA.
- 2. **Run Application**: Navigate to the `MainMenu` class located at `src/menu/MainMenu.java` and click the `Run` button or use the shortcut `Shift + F10`.

### Additional Notes
- Ensure that the PostgreSQL service is running before starting the application.
- Verify that the database connection details are correct and that the necessary tables are created in the database.

---
## Team Contributions

### All Team Members
  - All team members participated in daily stand-up meetings.
  - All team members meet to discuss the project and assign tasks.
  - All team members contributed to the project board by creating and moving cards.
  - All team members reviewed each other's code and provided feedback.
  - All team members participated in the final presentation.

### Garret Smith

#### Branches Worked On:
    - init-project#1
    - adding-admin/Registration
    - add-posting-transaction#13
    - Garret-Branch
    - Create-Connection-to-DB#3
    - Create-admin-menu
    - Adding-Main-Menu

#### Cards assigned on project board:
    - #1 Project Init
    - #2 Create PostgreSQL database
    - #3 Connect PostGreSQL Database to the application
    - #6 Create Main Menu for application
    - #9 Create Admin Sub Menu
    - #10 Add login functionality
    - #13 Add the Transaction and Posting objects

#### Other Contributions:
    - Assembled the menu, making sure the teams code worked
    - Restructured the project files structure

---
### Zach Ropson

#### Branches Worked On:
    - Zach-SellerSubMenu
    - Zach-ProductObj-ServiceImpl
    - Zach-Branch

#### Cards assigned on project board:
    - #4 Create Product object and product service interface
    - #7 Create Seller Sub Menu
---
### Rodney Stead

#### Branches Worked On:
    - Rodney
    - Rodney-UserObjects
    - Rodney-CompanyObject
    - Rodney-BuyerMenu
    - Rodney-AddressObject

#### Cards assigned on project board:
    - #5 Create UserService And Accompanying User objects
    - #8 Create Buyer Sub Menu
    - #14 Add Company and Address objects

#### Other Contributions:
    - Created the README.md file