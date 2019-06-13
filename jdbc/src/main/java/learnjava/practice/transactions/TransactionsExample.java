package learnjava.practice.transactions;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import learnjava.practice.Utils.JdbcUtils;
import learnjava.practice.model.HistEodData;

//By default AutoCommit is true
//i.e after every call to statement.execute data is committed to database 
//if you want to commit it as single entity(transaction) like DO ALL or DO NONE
//we have make AutoCommit to false and if execution id successful  call conn.commit.
//if execution is unsuccessful call connection.rollback
//if you don't call conn.commit or conn.rollback after setting autoCommit to false then 
//during connection close successful data will be committed 
//when closing connection the data will be committed (this statement is true for oracle driver).
//This behavior on connection close depends on implementing driver

public class TransactionsExample {
	
	public void insertHistData(){

		Connection conn = null;
		Statement st = null;
		try {
			conn = JdbcUtils.getConnection();
			conn.setAutoCommit(false);//true by default
			HistEodData histEodData = new HistEodData();
			histEodData.setTicker("AAPL");
			histEodData.setAdjClosePrice(90);
			histEodData.setClosePrice(90);
			histEodData.setDate(LocalDate.parse("2018-09-06"));
			histEodData.setHighPrice(90);
			histEodData.setLowPrice(90);
			histEodData.setOpenPrice(90);
			histEodData.setVolume(66666);
			System.out.println("connection auto commit value "+conn.getAutoCommit());
			st = conn.createStatement();
			String sql = "insert into HIST_EOD_DATA(TICKER,VOLUME,LOW_PRICE,HIGH_PRICE,CLOSE_PRICE,OPEN_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
					+ "Values ('" + histEodData.getTicker() + "'," + histEodData.getVolume() + ","
					+ histEodData.getLowPrice() + "," + histEodData.getHighPrice() + "," + histEodData.getClosePrice()
					+ "," + histEodData.getOpenPrice() + "," + histEodData.getAdjClosePrice() + ",TO_DATE('"+ histEodData.getDate() + "','yyyy-mm-dd'))";
			st.execute(sql);
			//if Auto Commit is true then the above query  inserted data is committed to DB
			//if Auto Commit is false then the above query inserted data is NOT-committed to DB..until conn.commit is called
			histEodData.setTicker("MSFT");
			histEodData.setAdjClosePrice(90);
			histEodData.setClosePrice(90);
			histEodData.setDate(LocalDate.parse("2018-09-06"));
			histEodData.setHighPrice(90);
			histEodData.setLowPrice(90);
			histEodData.setOpenPrice(90);
			histEodData.setVolume(77777);
			
			String sql2 = "insert into HIST_EOD_DATA(TICKER,VOLUME,LOW_PRICE,HIGH_PRICE,CLOSE_PRICE,OPEN_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
					+ "Values ('" + histEodData.getTicker() + "'," + histEodData.getVolume() + ","
					+ histEodData.getLowPrice() + "," + histEodData.getHighPrice() + "," + histEodData.getClosePrice()
					+ "," + histEodData.getOpenPrice() + "," + histEodData.getAdjClosePrice() + ",TO_DATE('"
					+ histEodData.getDate() + "','yyyy-mm-dd'))";
			st.execute(sql2);
			conn.commit();//if this is not called .during connection close the successfully inserted data is committed to DB
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, st);
		}
	
		
	}
	
	public static void main(String[] args) {
		
	}

}
