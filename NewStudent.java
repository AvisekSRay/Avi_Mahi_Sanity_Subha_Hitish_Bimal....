package student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class NewStudent {
	private String id;
	private String name;
	private String address;
	private String phonenumber;
	private String password;
	//NewStudent Ns=new NewStudent();
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhonenumber() {
		return phonenumber;
	}
	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "NewStudent [id=" + id + ", name=" + name + ", address=" + address + ", phonenumber=" + phonenumber
				+ ", password=" + password + "]";
	}
	public void add(String id, String name, String address, String phone, String password) throws SQLException {
	    Connection con = null;
	    PreparedStatement ps = null;
	    PreparedStatement ps1 = null;
	    
	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ouppdb", "root", "5518");
	        String query = "INSERT INTO studentdb (id, name, address, phonenumber, password) VALUES (?, ?, ?, ?, ?)";
	        String query2 = "INSERT INTO studentlogin (id,password) VALUES (?, ?)";

	        ps = con.prepareStatement(query);
	        ps.setString(1, id);
	        ps.setString(2, name);
	        ps.setString(3, address);
	        ps.setString(4, phone);
	        ps.setString(5, password);
	        ps1=con.prepareStatement(query2);
	        ps1.setString(1, id);
	        ps1.setString(2, password);
	        
	        // Execute the update (use executeUpdate() for INSERT, UPDATE, DELETE)
	        int rowsInserted = ps.executeUpdate();
	        if (rowsInserted > 0) {
	            System.out.println("A new student is inserted successfully!");
	        } else {
	            System.out.println("Failed to insert the student.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (ps != null) {
	            ps.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	    
	    
	    try {
	        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ouppdb", "root", "5518");
	        //String query = "INSERT INTO studentdb (id, name, address, phonenumber, password) VALUES (?, ?, ?, ?, ?)";
	        String query2 = "INSERT INTO studentlogin (id,password) VALUES (?, ?)";

	        ps1=con.prepareStatement(query2);
	        ps1.setString(1, id);
	        ps1.setString(2, password);
	        
	        // Execute the update (use executeUpdate() for INSERT, UPDATE, DELETE)
	        ps1.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        if (ps1 != null) {
	            ps1.close();
	        }
	        if (con != null) {
	            con.close();
	        }
	    }
	}

}
