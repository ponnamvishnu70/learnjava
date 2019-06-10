package learnjava.practice.callablestatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import learnjava.practice.Utils.JdbcUtils;
import learnjava.practice.model.HistEodData;

public class JdbcCallableStatement {

	public String getCompanyName() {
		Connection conn = null;
		CallableStatement cst = null;
		ResultSet rs = null;
		List<HistEodData> list = new ArrayList<>();
		String output = null;
		try {
			conn = JdbcUtils.getConnection();
			cst = conn.prepareCall("{call findCompanyName(?,?)}");
			cst.setString(1, "MDT");
			cst.registerOutParameter(2, Types.VARCHAR);
			cst.execute();
			output = cst.getString(2);
			System.out.println();

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtils.closeConnection(conn, cst);
		}

		return output;
	}

}
