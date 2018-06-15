package app;

import static app.generated.Tables.*;
import org.jooq.impl.DSL;

import app.generated.tables.records.*;

import java.sql.*;
import java.util.ArrayList;

import org.jooq.*;
import org.jooq.impl.*;

public class DbConnector {
	
	private static DbConnector connection;
	private static DSLContext create;
	private String username = "root";
	private String pwd = "1234";
	int idx = 1;
	//String url = "jdbc:mysql://localhost:3306/weather?useSSL=false?amp;serverTimezone=UTC";
	String url = "jdbc:mysql://localhost:3306/weather?useUnicode=true&serverTimezone=UTC&useSSL=false"; 
	
	private DbConnector() {
		//this.getRecords();
		Connection c;
		try {
			c = DriverManager.getConnection(url, username, pwd);
			create = DSL.using(c, SQLDialect.MYSQL);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized DbConnector getInstance() {
		if(connection == null) {
			connection = new DbConnector();
		}
		
		return connection;
	}
	
	public ArrayList<String> getRecords() {
		//Connection c;
		//try {
			//c = DriverManager.getConnection(url, username, pwd);
			//DSLContext create = DSL.using(c, SQLDialect.MYSQL);
			 Result<Record> result = create.select().from(POGODA).fetch();
			 ArrayList<String> pogoda = new ArrayList();
	         for (Record r : result) {
	             //Integer id = r.getValue(POGODA.ID);
	             //String nazwaMiasta = r.getValue(POGODA.NAZWAMIASTA);
	             //double minTemp = r.getValue(POGODA.MINTEMPERATURA);
	             //double maxTemp = r.getValue(POGODA.MAXTEMPERATURA);
	             //double cisnienie = r.getValue(POGODA.CISNIENIE);
	             
	             pogoda.add(r.getValue(POGODA.ID).toString());
	             pogoda.add(r.getValue(POGODA.NAZWAMIASTA));
	             pogoda.add(r.getValue(POGODA.MINTEMPERATURA).toString());
	             pogoda.add(r.getValue(POGODA.MAXTEMPERATURA).toString());
	             pogoda.add(r.getValue(POGODA.CISNIENIE).toString());
	         }
	         return pogoda;
		//} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
		//	return null;
		//}
	}
	
	public void insertData(String nazwaMiasta, double minT, double maxT, double cisnienie) {
		create.insertInto(POGODA,
				POGODA.NAZWAMIASTA, POGODA.MINTEMPERATURA, POGODA.MAXTEMPERATURA, POGODA.CISNIENIE)
		      .values(nazwaMiasta, minT, maxT, cisnienie)
		      .execute();
		++idx;
	}
	
	public void usunDane() {
		create.delete(POGODA).execute();	
	}
	
	public ArrayList<String> getDataByCityName(String cityname) {
		Result<Record> result = create.select().from(POGODA).where(POGODA.NAZWAMIASTA.eq(cityname)).fetch();
		ArrayList<String> pogoda = new ArrayList();
        for (Record r : result) {
            //Integer id = r.getValue(POGODA.ID);
            //String nazwaMiasta = r.getValue(POGODA.NAZWAMIASTA);
            //double minTemp = r.getValue(POGODA.MINTEMPERATURA);
            //double maxTemp = r.getValue(POGODA.MAXTEMPERATURA);
            //double cisnienie = r.getValue(POGODA.CISNIENIE);
            
            pogoda.add(r.getValue(POGODA.ID).toString());
            pogoda.add(r.getValue(POGODA.NAZWAMIASTA));
            pogoda.add(r.getValue(POGODA.MINTEMPERATURA).toString());
            pogoda.add(r.getValue(POGODA.MAXTEMPERATURA).toString());
            pogoda.add(r.getValue(POGODA.CISNIENIE).toString());
        }
        return pogoda;
	}
}

