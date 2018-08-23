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

	private static final String SQL_SELECT = "SELECT firstName, lastName, title, mobile, dob, pass,role, id,aadhaarNo FROM users";
	private static final String SQL_INSERT = "INSERT INTO users(firstName, lastName, title, mobile, dob, pass,role, id,aadhaarNo) values(?,?,?,?,?,?,?,?,?)";

	private static final String SQL_INSERT_USER_RELATION = "INSERT INTO userBankRelation(id,role,bankCode,branchCode) values(?,?,?,?)";

	@Override
	public void create(User user, String pass) {

		System.out.println(pass);
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);

			String id = String.valueOf(System.nanoTime());
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getTitle());
			ps.setString(4, user.getMobile());
			ps.setDate(5, user.getDob());
			ps.setString(6, pass);
			ps.setInt(7, user.getRole().ordinal());
			ps.setString(8, id);
			ps.setString(9, user.getAadhaarNo());

			ps.executeUpdate();
			System.out.println("Your Id is(use this id to login) : " + id);

			/*
			 * PreparedStatement pslog = con.prepareStatement(
			 * "Insert into logs(msg)values('New user Added name :" +
			 * user.getFirstName() + " Id : " + id + "')");
			 * pslog.executeUpdate();
			 */

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
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setTitle(rs.getString("title"));
				user.setMobile(rs.getString("mobile"));
				user.setDob(rs.getDate("dob"));
				user.setPass(rs.getString("pass"));
				user.setRole(Role.values()[rs.getInt("role")]);
				user.setAadhaarNo(rs.getString("aadhaarNo"));

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
					"select firstName, lastName, title, mobile, dob, pass,role, id,aadhaarNo from users where id = ? ");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			User user = new User();
			if (rs.next()) {
				user.setId(rs.getString("id"));
				user.setFirstName(rs.getString("firstName"));
				user.setLastName(rs.getString("lastName"));
				user.setTitle(rs.getString("title"));
				user.setMobile(rs.getString("mobile"));
				user.setDob(rs.getDate("dob"));
				user.setPass(rs.getString("pass"));
				user.setRole(Role.values()[rs.getInt("role")]);
				user.setAadhaarNo(rs.getString("aadhaarNo"));
				return user;
			}
			return null;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

	public boolean assignUser(String id, Role role, String bankCode, String branchCode) {

		try (Connection con = ConnectionUtil.getConnection();
				PreparedStatement ps = con.prepareStatement(SQL_INSERT_USER_RELATION);) {

			ps.setString(1, id);
			ps.setInt(2, role.ordinal());
			ps.setString(3, bankCode);
			ps.setString(4, branchCode);

			ps.executeUpdate();

			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
