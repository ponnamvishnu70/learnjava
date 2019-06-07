package learnjava.practice.jdbcstatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import learnjava.practice.Utils.JdbcUtils;
import learnjava.practice.model.HistEodData;

public class JdbcStatementExample {

	public List<HistEodData> getEodData(String symbol) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List<HistEodData> list = new ArrayList<>();
		//This is bad way of writing dynamic query.SQL Injection can be done
		String sqlQuery = "select * from HIST_EOD_DATA where Ticker ='"+symbol+"'";

		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);

			while (rs.next()) {
				//we can get columns by index too like rs.getString(columnIndex)
				HistEodData eodData = new HistEodData();				
				eodData.setTicker(rs.getString("TICKER"));
				eodData.setVolume(rs.getLong("VOLUME"));
				eodData.setLowPrice(rs.getDouble("LOW_PRICE"));
				eodData.setHighPrice(rs.getDouble("HIGH_PRICE"));
				eodData.setClosePrice(rs.getDouble("CLOSE_PRICE"));
				eodData.setOpenPrice(rs.getDouble("OPEN_PRICE"));
				eodData.setAdjClosePrice(rs.getDouble("ADJ_CLOSE_PRICE"));
				eodData.setDate(rs.getDate("TIME_STAMP").toLocalDate());
				list.add(eodData);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn, st, rs);
		}
		return list;
	}
	
	
	public void insertEodData(List<HistEodData> list) throws ClassNotFoundException, SQLException {
		Connection conn = null;
		conn = JdbcUtils.getConnection();
		conn.setAutoCommit(false);
		final Statement st = conn.createStatement();
		try {
		list.forEach(histEodData -> {
			String sql = "insert into HIST_EOD_DATA(TICKER,VOLUME,LOW_PRICE,HIGH_PRICE,CLOSE_PRICE,OPEN_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
					+ "Values ('" +
					histEodData.getTicker() + "'," +
					histEodData.getVolume() + "," +
					histEodData.getLowPrice() + "," + 
					histEodData.getHighPrice() + "," +
					histEodData.getClosePrice() + "," + 
					histEodData.getOpenPrice()  + "," +
					histEodData.getAdjClosePrice() + ",TO_DATE('" + 
					histEodData.getDate() + "','yyyy-mm-dd'))";
			try {
				st.addBatch(sql);
			} catch (SQLException e) {
				System.out.println("batch insert exception" + e);
			}

		});
		int[] insertionResult = st.executeBatch();
		//if you don't commit the transaction the record will not committed 
		//because we have set autocommit to false
		HistEodData heod = new HistEodData();
		heod.setTicker("MDTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
		heod.setAdjClosePrice(90);
		heod.setClosePrice(90);
		heod.setDate(LocalDate.parse("2018-09-06"));
		heod.setHighPrice(90);
		heod.setLowPrice(90);
		heod.setOpenPrice(90);
		heod.setVolume(66666);
		//insertEodData(heod);
		//conn.commit();
		
		}finally {
			JdbcUtils.closeConnection(conn, st);
			
		}
		

	}
	//overloading
	public void insertEodData(HistEodData histEodData) {
		Connection conn = null;
		Statement st = null;
		try {
			conn = JdbcUtils.getConnection();
			System.out.println("connection auto commit value "+conn.getAutoCommit());
			st = conn.createStatement();
			String sql = "insert into HIST_EOD_DATA(TICKER,VOLUME,LOW_PRICE,HIGH_PRICE,CLOSE_PRICE,OPEN_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
					+ "Values ('" + histEodData.getTicker() + "'," + histEodData.getVolume() + ","
					+ histEodData.getLowPrice() + "," + histEodData.getHighPrice() + "," + histEodData.getClosePrice()
					+ "," + histEodData.getOpenPrice() + "," + histEodData.getAdjClosePrice() + ",TO_DATE('"
					+ histEodData.getDate() + "','yyyy-mm-dd'))";
			st.execute(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.closeConnection(conn, st);
		}
	}
}
