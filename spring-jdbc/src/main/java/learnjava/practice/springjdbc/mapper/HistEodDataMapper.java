package learnjava.practice.springjdbc.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import learnjava.practice.springjdbc.model.EodData;

public class HistEodDataMapper implements RowMapper<EodData> {

	public EodData mapRow(ResultSet rs, int rowNum) throws SQLException {
		EodData ed = new EodData();
		ed.setTicker(rs.getString("TICKER"));
		ed.setVolume(rs.getLong("VOLUME"));
		ed.setTimeStamp(rs.getDate("TIME_STAMP").toLocalDate());
		ed.setOpenPrice(rs.getDouble("OPEN_PRICE"));
		ed.setClosePrice(rs.getDouble("CLOSE_PRICE"));
		ed.setHighPrice(rs.getDouble("HIGH_PRICE"));
		ed.setLowPrice(rs.getDouble("LOW_PRICE"));
		ed.setAdjClosePrice(rs.getDouble("ADJ_CLOSE_PRICE"));
		return ed;
	}

}
