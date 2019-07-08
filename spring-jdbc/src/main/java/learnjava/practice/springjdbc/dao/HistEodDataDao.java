package learnjava.practice.springjdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import learnjava.practice.springjdbc.model.EodData;

@Repository
public class HistEodDataDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int getHistEodDataCount() {
		String sql ="Select count(*) from HIST_EOD_DATA";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
		return count;
	}
	
	public List<EodData> getHistEodData() {
		String sql ="Select * from HIST_EOD_DATA";		
		List<EodData> histEodData = jdbcTemplate.query(sql,new HistEodDataMapper());
		histEodData.forEach(item->System.out.println(item.getTicker() +" adj close price is  "+item.getAdjClosePrice()));
		return histEodData;
	}
	
	
	class HistEodDataMapper implements RowMapper<EodData>{

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
	

}
