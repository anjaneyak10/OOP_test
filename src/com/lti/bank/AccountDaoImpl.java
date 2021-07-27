package com.lti.bank;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountDaoImpl implements AccountDAO {

	Connection conn;
	String sql;
	PreparedStatement stmt;
	CallableStatement cstmt;

	public AccountDaoImpl() {
		conn = ConnectionFactory1.getConnection();

	}

	@Override
	public boolean addAnAccount(Accounts account) {
		// TODO Auto-generated method stub
		sql = "insert into bank_account values(ac_no.nextval,?,?,?)";
		int i = 0;
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setString(1, account.getAccPass());
			cstmt.setDouble(2, account.getAccBal());
			cstmt.setString(3, account.getBankName());
			i = cstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return i > 0;
	}

	@Override
	public void withdraw(String accountNumber, double amount) {
		// TODO Auto-generated method stub
		System.out.println("Enter Acc Number");
		Scanner sc = new Scanner(System.in);
//		String accountNumber = sc.next();
		Accounts acc = null;
		int acNo = Integer.parseInt(accountNumber);
		sql = "select account_balance from bank_account where account_no=?";
		double i=0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, acNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			i=rs.getDouble(1);
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
		if(i<amount) {
			try {
				throw new InsufficientFundException("Sorry!! not enough balance");
				}
				catch(InsufficientFundException e){
					System.out.println(e.getMessage());
				}
			return;
		}
		double x = i-amount;
		sql = "update bank_account set account_balance = ? where account_no = ?";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(2, acNo);
			cstmt.setDouble(1, x);
			i = cstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		

	}

	@Override
	public double checkBalance() {
		// TODO Auto-generated method stub
		System.out.println("Enter Acc Number");
		Scanner sc = new Scanner(System.in);
		String accountNumber = sc.next();
		Accounts acc = null;
		int acNo = Integer.parseInt(accountNumber);
		sql = "select account_balance from bank_account where account_no=?";
		double i=0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, acNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			i=rs.getDouble(1);
			System.out.println("Account Balance = "+i);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return i;
	}

	@Override
	public void changePassword(String accountNumber, String oldPassword, String newPassword) {
		// TODO Auto-generated method stub
		int acNo = Integer.parseInt(accountNumber);
		String oldpass="";
		sql = "select account_pass from bank_account where account_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, acNo);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			oldpass=rs.getString(1);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		if(!oldpass.equals(oldPassword)) {
			System.out.println("Wrong pass");
			return;
		}
		sql = "update bank_account set account_pass = ? where account_no = ?";
		try {
			cstmt = conn.prepareCall(sql);
			cstmt.setInt(2, acNo);
			cstmt.setString(1,newPassword );
			cstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
			

	}

	@Override
	public List<Accounts> viewAllAccounts() {
		// TODO Auto-generated method stub
		sql = "select * from bank_account ";
		List<Accounts> ls = new ArrayList<Accounts>();
		Accounts acc = null;
		try {
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				acc = new SavingsAccount(String.valueOf(rs.getInt(1)), rs.getDouble(3), rs.getString(2),
						rs.getString(4));
				ls.add(acc);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return ls;
	}

	@Override
	public Accounts getAccountDetails(String accountNumber) {
		// TODO Auto-generated method stub

		Accounts acc = null;
		int acNo = Integer.parseInt(accountNumber);
		sql = "select * from bank_account where account_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, acNo);
			ResultSet rs = stmt.executeQuery();
			System.out.println("1.Savings 2.Current");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			if (rs.next())
				if (ch == 1)
					acc = new SavingsAccount(String.valueOf(rs.getInt(1)), rs.getDouble(3), rs.getString(2),
							rs.getString(4));
				else
					acc = new CurrentAccount(String.valueOf(rs.getInt(1)), rs.getDouble(3), rs.getString(2),
							rs.getString(4));
			return acc;
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return null;
	}

}
