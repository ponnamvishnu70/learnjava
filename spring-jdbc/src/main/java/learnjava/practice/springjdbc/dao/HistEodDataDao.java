package learnjava.practice.springjdbc.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import learnjava.practice.springjdbc.model.EodData;

@Repository
public class HistEodDataDao {

	private JdbcTemplate jdbcTemplate;

	public int getHistEodDataCount() {
		String sql = "Select count(*) from HIST_EOD_DATA";
		int count = jdbcTemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
		return count;
	}

	public List<EodData> getHistEodData() {
		String sql = "Select * from HIST_EOD_DATA";
		List<EodData> histEodData = jdbcTemplate.query(sql, new HistEodDataMapper());
		histEodData.forEach(
				item -> System.out.println(item.getTicker() + " adj close price is  " + item.getAdjClosePrice()));
		return histEodData;
	}

	public void insertHistEodData() {
		String sql="insert into hist_eod_data (TICKER,VOLUME,OPEN_PRICE,CLOSE_PRICE,HIGH_PRICE,LOW_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) " + 
				"values (?,?,?,?,?,?,?,?) " ;
		EodData histEodData = new EodData();
		histEodData.setTicker("MDT");
		histEodData.setAdjClosePrice(90.00);
		histEodData.setClosePrice(90);
		histEodData.setTimeStamp(LocalDate.parse("2018-09-06"));
		histEodData.setHighPrice(90);
		histEodData.setLowPrice(90);
		histEodData.setOpenPrice(90);
		histEodData.setVolume(123456);
		
		jdbcTemplate.update(sql,new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pst) throws SQLException {
				pst.setString(1, histEodData.getTicker());
				pst.setLong(2,histEodData.getVolume());
				pst.setDouble(3,histEodData.getLowPrice());
				pst.setDouble(4,histEodData.getHighPrice());
				pst.setDouble(5,histEodData.getClosePrice());
				pst.setDouble(6,histEodData.getOpenPrice());
				pst.setDouble(7,histEodData.getAdjClosePrice());
				pst.setDate(8, Date.valueOf(histEodData.getTimeStamp()));
				
			}});

	}

	class HistEodDataMapper implements RowMapper<EodData> {

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

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

}
