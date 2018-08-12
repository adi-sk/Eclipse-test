package com.zycusBank.aditya;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.zycusBank.enums.Level;
import com.zycusBank.enums.LogType;

public class LogIt {

	private static final String SQL_INSERT = "INSERT INTO LOGS(msg,customerId,level,logType,transactionId)values(?,?,?,?,?)";

	public static boolean add(String msg) {
		try (Connection con = ConnectionUtil.getConnection()) {
			PreparedStatement ps = con.prepareStatement(SQL_INSERT);
			ps.setString(1, "");
			ps.setString(2, "");
			ps.setInt(3, Level.BANK.ordinal());
			ps.setInt(4, LogType.ADD.ordinal());
			ps.setString(5, "");

			ps.executeUpdate();
			return true;

		} catch (SQLException ex) {
			ex.printStackTrace();
			return false;
		}

	}

}
