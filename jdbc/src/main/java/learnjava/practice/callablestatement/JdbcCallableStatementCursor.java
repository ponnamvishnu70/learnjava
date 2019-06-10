package learnjava.practice.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import learnjava.practice.Utils.JdbcUtils;
import learnjava.practice.model.HistEodData;
import oracle.jdbc.internal.OracleTypes;

public class JdbcCallableStatementCursor {
	
	List<HistEodData> getHistoricDataByTicker(){

		Connection conn = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		List<HistEodData> list = new ArrayList<>();
		String output = null;
		try {
			conn = JdbcUtils.getConnection();
			cst = conn.prepareCall("{call getHistoricDataByTicker(?,?)}");
			cst.setString(1, "P");
			cst.registerOutParameter(2, OracleTypes.CURSOR);
			cst.execute();
			rs = (ResultSet)cst.getObject(2);
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
			list.forEach(hist->{
     			System.out.println(hist.getTicker());
	            System.out.println(hist.getClosePrice());		
			});
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn, cst);
		}

		return list;
	
	}

}
