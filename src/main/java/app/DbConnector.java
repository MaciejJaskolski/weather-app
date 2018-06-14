package app;

import static app.generated.Tables.*;
import org.jooq.impl.DSL;

import app.generated.tables.records.*;

import java.sql.*;

import org.jooq.*;
import org.jooq.impl.*;

public class DbConnector {
	
	private static DbConnector connection;
	private String username = "root";
	private String pwd = "1234";
	//String url = "jdbc:mysql://localhost:3306/weather?useSSL=false?amp;serverTimezone=UTC";
	String url = "jdbc:mysql://localhost:3306/weather?useUnicode=true&serverTimezone=UTC&useSSL=false"; 
	
	private DbConnector() {
		//this.getRecords();
	}
	
	public static synchronized DbConnector getInstance() {
		if(connection == null) {
			connection = new DbConnector();
		}
		
		return connection;
	}
	
	public void getRecords() {
		Connection c;
		try {
			c = DriverManager.getConnection(url, username, pwd);
			DSLContext create = DSL.using(c, SQLDialect.MYSQL);
			 Result<Record> result = create.select().from(POGODA).fetch();

	         for (Record r : result) {
	             Integer id = r.getValue(POGODA.ID);
	             String nazwaMiasta = r.getValue(POGODA.NAZWAMIASTA);
	             double minTemp = r.getValue(POGODA.MINTEMPERATURA);

	             System.out.println("ID: " + id + " nazwa miasta: " + nazwaMiasta + " minTemp: " + minTemp);
	         }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void insertData(int id, String nazwaMiasta, double minT, double maxT, double cisnienie) {
	/*	create.insertInto(AUTHOR,
		        AUTHOR.ID, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
		      .values(100, "Hermann", "Hesse")
		      .execute();*/
	}
	
}

