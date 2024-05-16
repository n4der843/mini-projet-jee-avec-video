package DAO;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import Beans.user;

public class UserDao implements userInterface{
	@Override
	public void addUser(user user)
	{
		String sql ="insert into user (name,prenom,email,mdp,image) values (?,?,?,?,?)";
		try
		(
			Connection maconnexion=dbc.createConnection();
			PreparedStatement stmt= maconnexion.prepareStatement(sql))
			{
			stmt.setString(1, user.getName());
		    stmt.setString(2, user.getPrenom());
		    stmt.setString(3, user.getEmail());
		    stmt.setString(4, user.getMdp());
		    stmt.setBytes(5, user.getImage()); 
		    stmt.executeUpdate(); 
			}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public ArrayList<user> getAll() {
		try {
			Connection maconnexion=dbc.createConnection();
			java.sql.PreparedStatement ps = maconnexion.prepareStatement("Select * from user");
			ResultSet rs = ps.executeQuery();
			ArrayList <user> users= new ArrayList();
			while(rs.next())
			{
				user user = new user (rs.getInt(1),rs.getString(2), rs.getString(3),rs.getString(4));
				users.add(user);
			}
			return users;
		} catch (Exception e) {
			e.printStackTrace(); 
			return null; }
		}
	@Override
	public int findUser(String name) {
	    try (Connection maconnexion = dbc.createConnection();
	         PreparedStatement ps = maconnexion.prepareStatement("SELECT COUNT(*) FROM user WHERE name = ?")) {
	        ps.setString(1, name); 
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	@Override
	public int CountUser()
	{
		try (Connection maconnexion = dbc.createConnection();
		         PreparedStatement ps = maconnexion.prepareStatement("SELECT COUNT(*) FROM user")) { 
		        try (ResultSet rs = ps.executeQuery()) {
		            if (rs.next()) {
		                return rs.getInt(1);
		            }
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return 0;
	}
	@Override
	public user findUserById(int id) {
	    try (Connection maconnexion = dbc.createConnection();
	         PreparedStatement ps = maconnexion.prepareStatement("SELECT * FROM user WHERE id = ?")) {
	        ps.setInt(1, id); 
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	               user user = new user(rs.getInt(1),rs.getString(2), rs.getString(3));
	               return user;
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	@Override
	public int findUserByLetter(String name) {
	    try (Connection maconnexion = dbc.createConnection();
	         PreparedStatement ps = maconnexion.prepareStatement("SELECT COUNT(*) FROM user WHERE name like ?")) {
	        ps.setString(1, name + "%");
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                return rs.getInt(1);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return 0;
	}
	@Override
	public void updateUser(user user) {
	    String sql = "UPDATE user SET name = ?, prenom = ?, email = ? WHERE idUser = ?";
	    try (Connection maconnexion = dbc.createConnection();
	         PreparedStatement stmt = maconnexion.prepareStatement(sql)) {
	        stmt.setString(1, user.getName());
	        stmt.setString(2, user.getPrenom());
	        stmt.setString(3, user.getEmail());
	        stmt.setInt(4, user.getIdUser());
	        int rowsAffected = stmt.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("User updated successfully.");
	        } else {
	            System.out.println("No user found with this ID.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
		
	@Override
	public void deleteUser(int id) {
	    try (Connection maconnexion = dbc.createConnection();
	         PreparedStatement ps = maconnexion.prepareStatement("DELETE FROM user WHERE idUser = ?")) {
	        ps.setInt(1, id);
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("User deleted successfully.");
	        } else {
	            System.out.println("No user found with this ID.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

}
