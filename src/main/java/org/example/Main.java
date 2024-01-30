package org.example;
// MySQL Task - 2nd Problem - JDBC connectivity and Insert Query
import java.sql.*;


public class Main {
    public static void main(String[] args) throws SQLException {
        // JDBC Connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/employeedb?user=root&password=Root@123$");

        // Table Creation
        String query1 = "create table employee (" +
                "empcode int not null unique,\n" +
                "empname varchar(255),\n" +
                "empage varchar(255),\n" +
                "esalary long)";
        PreparedStatement preparedStatement1 = connection.prepareStatement(query1);
        preparedStatement1.execute();

        // Insert Data
        String query2 = "insert into employee (empcode, empname, empage, esalary) values " +
                "(101, 'Jenny', 25, 10000)," +
                "(102, 'Jacky', 30, 20000), " +
                "(103, 'Joe', 20, 40000), " +
                "(104, 'John', 40, 80000), " +
                "(105, 'Shameer', 25, 90000);";

        PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
        preparedStatement2.execute();

        // Retrieve Added Entries
        String query3 = "select * from employee;";
        PreparedStatement preparedStatement3= connection.prepareStatement(query3);
        preparedStatement3.execute();
        ResultSet resultSet = preparedStatement3.executeQuery();

        System.out.println(resultSet.getMetaData().getColumnName(1) + " " + resultSet.getMetaData().getColumnName(2)
                + " " + resultSet.getMetaData().getColumnName(3) + " " + resultSet.getMetaData().getColumnName(4) );

        while(resultSet.next()) {
            System.out.println(resultSet.getInt(1) + " \t" + resultSet.getString(2)
                    + " \t" + resultSet.getString(3) + " \t" + resultSet.getString(4) );
        }
    }
}


// Intellij Output

//    empcode empname empage esalary
//    101 	Jenny 	25 	10000
//    102 	Jacky 	30 	20000
//    103 	Joe 	20 	40000
//    104 	John 	40 	80000
//    105 	Shameer 	25 	90000