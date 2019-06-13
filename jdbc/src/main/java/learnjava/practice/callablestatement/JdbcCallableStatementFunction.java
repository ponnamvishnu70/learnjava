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

/*ORACLE FUNCTIONS
 * create or replace function companyheod(symbol IN varchar2,noofrecords OUT number) return SYS_REFCURSOR as
--variable declarion
companyeodinfo SYS_REFCURSOR;

BEGIN
open companyeodinfo for
select * from HIST_EOD_DATA where ticker =symbol;
update hist_eod_data set adj_close_price=0 where ticker = symbol;
noofrecords := SQL%ROWCOUNT;--non select queries.....no of rows effected
return companyeodinfo;
END;
/
 * */

public class JdbcCallableStatementFunction {
	
	void getCompanyInfo(String symbol){

		Connection conn = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		List<HistEodData> list = new ArrayList<>();
		String output = null;
		try {
			conn = JdbcUtils.getConnection();
			cst = conn.prepareCall("{? = call companyheod(?,?)}");
			cst.registerOutParameter(1, OracleTypes.CURSOR);
			cst.setString(2, symbol);
			cst.registerOutParameter(3, OracleTypes.INTEGER);
			cst.execute();
			rs = (ResultSet)cst.getObject(1);
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
			System.out.println("No of records "+cst.getInt(3));
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn, cst);
		}

	
	}
	

}
