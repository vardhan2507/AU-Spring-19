package com.accolite.au.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.accolite.au.model.Item;


public class ItemDaoImpl implements ItemDao{
	
	Connection con;
	
	public ItemDaoImpl() throws ClassNotFoundException, SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost/vardhan", "vardhan", "vardhan");
		
	}

	public String addItem(Item item) {
		// TODO Auto-generated method stub
		
		int id = item.getId();
		String name = item.getName();
		int price = item.getPrice();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("insert into item values(?, ?, ?)");

			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.executeUpdate();

			ps.close();
			con.close();
			return "Succesfully Inserted into the database";
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public Item getItem(int id) {
		// TODO Auto-generated method stub
		Item item = null;
		try {
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery("select id,name, price from item where id=" + id);

			while (rs.next()) {
				Integer id1 = rs.getInt(1);
				String name = rs.getString(2);
				Integer price = rs.getInt(3);

				item = new Item(id, name, price);
			}

			s.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;	
		
	}

	public String updateItem(int id, Item item) {
		// TODO Auto-generated method stub
		String name = item.getName();
		int price = item.getPrice();
		
		try {
			PreparedStatement ps = con.prepareStatement("update item set id=?, name=?, price=? where id=?");
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, price);
			ps.setInt(4, id);
			ps.executeUpdate();

			ps.close();
			con.close();
			return "Successfully updated in the database";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public String removeItem(int id, Item item) {
		// TODO Auto-generated method stub
		String name = item.getName();
		int price = item.getPrice();
		
		try {
			
			PreparedStatement ps = con.prepareStatement("delete from item where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();

			ps.close();
			con.close();
			return "Succefully removed in the database";
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> items = new ArrayList<Item>();
		try {
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery("select id, name, price from item");
		while (rs.next()) {
			Integer id = rs.getInt(1);
			String name = rs.getString(2);
			Integer price = rs.getInt(3);

			items.add(new Item(id, name, price));
		}

		s.close();
		con.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	return items;
	}

}
