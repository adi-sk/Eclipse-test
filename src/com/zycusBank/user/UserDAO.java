package com.zycusBank.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.zycusBank.aditya.CommonDAO;
import com.zycusBank.aditya.ConnectionUtil;
import com.zycusBank.enums.Role;

public class UserDAO implements CommonDAO<User> {

	private static final String SQL_SELECT = "SELECT firstName, lastName, title, age, dob, pass,role, id FROM users";
	private static final String SQL_INSERT = "INSERT INTO users(firstName, lastName, title, age, dob, pass,role, id) values(?,?,?,?,?,?,?,?)";

	@Override
	public void create(User user, String pass) {

		System.out.println(pass);
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);

			String id = String.valueOf(System.nanoTime());
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getTitle());
			ps.setInt(4, user.getAge());
			ps.setDate(5, user.getDob());
			ps.setString(6, pass);
			ps.setInt(7, user.getRole().ordinal());
			ps.setString(8, id);
			ps.executeUpdate();
			System.out.println("Your Id is(use this id to login) : " + id);

			PreparedStatement pslog = con.prepareStatement(
					"Insert into logs(msg)values('New user Added name :" + user.getFirstName() + " Id : " + id + "')");
			pslog.executeUpdate();

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

	}

	@Override
	public List<User> findAll() {
		List<User> users = new LinkedList<>();
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				User user = new User();

				user.setId(rs.getString("id"));
				user.setFirstName(rs.getString(1));
				user.setLastName(rs.getString(2));
				user.setTitle(rs.getString(3));
				user.setAge(rs.getInt(4));
				user.setDob(rs.getDate(5));
				user.setPass(rs.getString("pass"));
				user.setRole(Role.values()[rs.getInt("role")]);

				users.add(user);
			}

			return users;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	@Override
	public User findById(String id) {

		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select firstName, lastName, title, age, dob, pass,role, id from users where id = ? ");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setTitle(rs.getString("title"));
				user.setAge(rs.getInt("age"));
				user.setDob(rs.getDate("dob"));
				user.setPass(rs.getString("pass"));
				user.setRole(Role.values()[rs.getInt("role")]);
			}
			return user;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
