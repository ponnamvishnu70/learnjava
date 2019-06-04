package learnjava.practice.jdbcstatement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import learnjava.practice.Utils.JdbcUtils;

public class JdbcStatementExample {

	public List<HistEodData> getEodData(String symbol) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		List list = new ArrayList<>();
		//This is bad of writing dynamic query.SQL Injection can be done
		String sqlQuery = "select * from HIST_EOD_DATA where Ticker ='"+symbol+"'";

		try {
			conn = JdbcUtils.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(sqlQuery);

			while (rs.next()) {
				//we can get columns by index too. rs.getString(columnIndex)
				HistEodData eodData = new HistEodData();				
				eodData.setTicker(rs.getString("TICKER"));
				eodData.setVolume(rs.getLong("VOLUME"));
				eodData.setLowPrice(rs.getDouble("LOW_PRICE"));
				eodData.setHighPrice(rs.getDouble("HIGH_PRICE"));
				eodData.setClosePrice(rs.getDouble("CLOSE_PRICE"));
				eodData.setOpenPrice(rs.getDouble("OPEN_PRICE"));
				eodData.setAdjClosePrice(rs.getDouble("ADJ_CLOSE_PRICE"));
				eodData.setTimeStamp(rs.getTimestamp("TIME_STAMP"));
				list.add(eodData);

			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn, st, rs);
		}
		return list;
	}

}
