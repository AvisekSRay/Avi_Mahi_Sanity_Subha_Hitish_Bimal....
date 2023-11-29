package gov.in.oupp.training.java.corejavatraining.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcTransactionExample {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    String url="jdbc:mysql://localhost:3306/ouppdb";
    String userName="root";
    String password="system";
    try(Connection connection=DriverManager.getConnection(url,userName,password))
        {
        connection.setAutoCommit(false);
          try
          {
            transferMoney(connection,101,102,500.00);
            connection.commit();
            System.out.println("Connection commited sucessfully");
          }catch(SQLException e)
          {
            connection.rollback();
            System.out.println("Transaction rolled back"+"due to an exception");
            e.printStackTrace();
          }
        }catch(SQLException e)
          {
            e.printStackTrace();
          }
  }

  private static void transferMoney(Connection connection,
		  int fromAccountId, int toAccountId, double amount) throws SQLException{
    // TODO Auto-generated method stub
    //deduct money from account
    updateAccountBalance(connection,fromAccountId,-amount);
    //add money to the source account
    
    updateAccountBalance(connection, toAccountId, amount);
    
  }

  private static void updateAccountBalance(Connection connection
		  , int AccountId, double amount) throws SQLException{
    // TODO Auto-generated method stub
    String sql="Update bank_accounts SET balance ="
    		+ ""+"balance+? WHERE account_id=?";
    try(PreparedStatement prepareStatement=
    		connection.prepareStatement(sql))
    {
      prepareStatement.setDouble(1, amount);
      prepareStatement.setInt(2, AccountId);
      prepareStatement.executeUpdate();
    }
  }

}