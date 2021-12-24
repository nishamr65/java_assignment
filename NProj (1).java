import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class CRUD extends Frame implements ActionListener 
{
	Label lsname,lsno,lsod,lsoj;
	TextField tsname,tsno,tsod,tsoj;
	Button bins,bupd,bdel,bview,bexit;
	public CRUD() {
		super("Home Page");
		lsno= new Label("STUDENT NUMBER");
		lsname= new Label("STUDENT NAME");
		lsod= new Label("DATE OF BIRTH");
		lsoj= new Label("DATE OF JOIN");
		
		tsno=new TextField(20);
		tsname=new TextField(20);
		tsod=new TextField(20);
		tsoj=new TextField(20);
		
		bins= new Button("Insert");
		bupd= new Button("Update");
		bdel= new Button("Delete");
		bview=new Button("View");
		bexit=new Button("Exit");
		
		setLayout(new GridLayout(7,2,20,20));
		
		add(lsno);
		add(tsno);
		add(lsname);
		add(tsname);
		add(lsod);
		add(tsod);
		add(lsoj);
		add(tsoj);
		add(bins);
		add(bupd);
		add(bdel);
		add(bview);
		add(bexit);
		
		bins.addActionListener(this);
		bupd.addActionListener(this);
		bdel.addActionListener(this);
		bview.addActionListener(this);
		bexit.addActionListener(this);
		setSize(800,800);
		setVisible(true);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==bins) {
			try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","nisha","root");
					System.out.println("Connected....."+con);
					PreparedStatement stmt=con.prepareStatement("insert into STUDENT values(?,?,?,?)"); 
						
					stmt.setString(1,tsno.getText());
					stmt.setString(2,tsname.getText());
					stmt.setString(3,tsod.getText());
					stmt.setString(4,tsoj.getText());
					
					stmt.execute();
					System.out.println("Data Inserted Successfully");
					tsno.setText("");
					tsname.setText("");
					tsod.setText("");
					tsoj.setText("");
					con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()==bupd) {
			try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","nisha","root");
					System.out.println("Connected....."+con);
					PreparedStatement stmt=con.prepareStatement("update STUDENT set STUDENT_NAME=? , STUDENT_DOB=? , STUDENT_DOJ=? where STUDENT_NO=?"); 
						
					stmt.setString(4,tsno.getText());
					stmt.setString(1,tsname.getText());
					stmt.setString(2,tsod.getText());
					stmt.setString(3,tsoj.getText());
					
					stmt.execute();
					System.out.println("Data Updated Successfully");
					tsno.setText("");
					tsname.setText("");
					tsod.setText("");
					tsoj.setText("");
					con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()==bdel) {
			try {
					Class.forName("oracle.jdbc.OracleDriver");
					Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","nisha","root");
					System.out.println("Connected....."+con);
					PreparedStatement stmt=con.prepareStatement("delete from STUDENT where STUDENT_NO=?"); 
						
					stmt.setString(1,tsno.getText());
					
					stmt.execute();
					System.out.println("Data Deleted Successfully");
					tsno.setText("");
					tsname.setText("");
					tsod.setText("");
					tsoj.setText("");
					con.close();
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
		else if(ae.getSource()==bview) {
			try {
				StudView obj=new StudView();
				setVisible(false);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		}
	}
}
class NProj {
	public static void main(String args[]) {
		CRUD obj=new CRUD();
	}
}