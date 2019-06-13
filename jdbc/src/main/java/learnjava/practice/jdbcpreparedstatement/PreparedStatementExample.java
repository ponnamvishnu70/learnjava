package learnjava.practice.jdbcpreparedstatement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import learnjava.practice.Utils.JdbcUtils;
import learnjava.practice.model.HistEodData;

public class PreparedStatementExample {
	
	public static void insertEodData(HistEodData histEodData) {
		Connection conn = null;
		PreparedStatement pst = null;
		try {
			conn = JdbcUtils.getConnection();
			System.out.println("connection auto commit value "+conn.getAutoCommit());
			String sql = "insert into HIST_EOD_DATA(TICKER,VOLUME,LOW_PRICE,HIGH_PRICE,CLOSE_PRICE,OPEN_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
					+ "Values (?,?,?,?,?,?,?,?)";//for different date formats : TO_DATE(?,'yyyy-mm-dd') 
			pst = conn.prepareStatement(sql);
			pst.setString(1, histEodData.getTicker());
			pst.setLong(2,histEodData.getVolume());
			pst.setDouble(3,histEodData.getLowPrice());
			pst.setDouble(4,histEodData.getHighPrice());
			pst.setDouble(5,histEodData.getClosePrice());
			pst.setDouble(6,histEodData.getOpenPrice());
			pst.setDouble(7,histEodData.getAdjClosePrice());
			pst.setDate(8, Date.valueOf(histEodData.getDate()));
		
			pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, pst);
		}
	}
	
	public static void main(String[] args) {
		
		HistEodData heod = new HistEodData();
		heod.setTicker("MDT");
		heod.setAdjClosePrice(90);
		heod.setClosePrice(90);
		heod.setDate(LocalDate.parse("2018-09-06"));
		heod.setHighPrice(90);
		heod.setLowPrice(90);
		heod.setOpenPrice(90);
		heod.setVolume(123456);
		insertEodData(heod);
	}

}
