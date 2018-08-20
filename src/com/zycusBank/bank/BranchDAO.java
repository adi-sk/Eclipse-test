package com.zycusBank.bank;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.zycusBank.aditya.ConnectionUtil;

public class BranchDAO {

	private static final String SQL_SELECT = "select branchCode,bankCode,branchName from branches";
	private static final String SQL_INSERT = "insert into branches(branchCode,bankCode,branchName) values(?,?,?)";

	public boolean create(Branch branch) {

		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);

			System.out.println(branch.getBranchCode());
			System.out.println(branch.getBankCode());
			System.out.println(branch.getBranchName());

			ps.setString(1, branch.getBranchCode());
			ps.setString(2, branch.getBankCode());
			ps.setString(3, branch.getBranchName());

			ps.executeUpdate();
			System.out.println("New Branch Added  : " + branch.getBranchCode());
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

	public List<Branch> findAll() {
		List<Branch> branches = new LinkedList<>();
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_SELECT);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Branch branch = new Branch();

				branch.setBranchCode(rs.getString("branchCode"));
				branch.setBankCode(rs.getString("bankCode"));
				branch.setBranchName(rs.getString("branchName"));
				branches.add(branch);
			}

			return branches;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public List<Branch> findAllByBank(String bankCode) {
		List<Branch> branches = new LinkedList<>();
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con
					.prepareStatement("select branchCode,bankCode,branchName from branches WHERE bankCode = ?");
			ps.setString(1, bankCode);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Branch branch = new Branch();

				branch.setBranchCode(rs.getString("branchCode"));
				branch.setBankCode(rs.getString("bankCode"));
				branch.setBranchName(rs.getString("branchName"));
				branches.add(branch);
			}

			return branches;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}

	}

	public Branch findByCode(String branchCode, String bankCode) {

		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(
					"select branchCode,bankCode,branchName from branches where branchCode = ? AND bankCode = ? ");
			ps.setString(1, branchCode);
			ps.setString(2, bankCode);
			ResultSet rs = ps.executeQuery();
			Branch branch = new Branch();
			if (rs.next()) {
				branch.setBranchCode(rs.getString("branchCode"));
				branch.setBankCode(rs.getString("bankCode"));
				branch.setBranchName(rs.getString("branchName"));

			}
			return branch;
		} catch (SQLException ex) {
			ex.printStackTrace();
			return null;
		}
	}

}
