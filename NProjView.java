import java.io.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class StudView extends Frame implements ActionListener 
{
	List l;
	Button back;

	public StudView() {
		super("View Student Details");
		l=new List(10);		
		back=new Button("Go  Back");
		
		setLayout(new GridLayout(6,2,50,50));
		
		add(l);
		add(back);
		
		back.addActionListener(this);
		setSize(800,800);
		setVisible(true);
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","nisha","root");
			System.out.println("Connected....."+con);
			PreparedStatement stmt=con.prepareStatement("select * from STUDENT"); 
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				String no=Integer.toString(rs.getInt("STUDENT_NO"));
				String nam=rs.getString("STUDENT_NAME");
				String db=rs.getString("STUDENT_DOB");
				String dj=rs.getString("STUDENT_DOJ");

				l.add("      "+no+"       -       "+nam+"       -       "+db+"       -       "+dj);
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==back) {
			CRUD obj=new CRUD();
			setVisible(false);
		}
	}
}

class NProjView {
	public static void main(String args[]) {
		StudView obj=new StudView();
	}
}