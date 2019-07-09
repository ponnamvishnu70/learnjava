package learnjava.practice.springjdbc.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.jar.Attributes.Name;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Repository;

import learnjava.practice.springjdbc.mapper.HistEodDataMapper;
import learnjava.practice.springjdbc.model.EodData;

@Repository
public class HistEodDataDao {

	// we can directly inject jdbcTemplate but this is singleton and thread safe
	// instance. So any modification on fetch size or maxresults will be affected
	// across all the DAOs
	// If this is not your desired behavior then ask spring for prototype or do it
	// like code below
	private JdbcTemplate jdbcTemplate;
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

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
		String sql = "insert into hist_eod_data (TICKER,VOLUME,OPEN_PRICE,CLOSE_PRICE,HIGH_PRICE,LOW_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
				+ "values (?,?,?,?,?,?,?,?) ";
		EodData histEodData = new EodData();
		histEodData.setTicker("MDT");
		histEodData.setAdjClosePrice(90.00);
		histEodData.setClosePrice(90);
		histEodData.setTimeStamp(LocalDate.parse("2018-09-06"));
		histEodData.setHighPrice(90);
		histEodData.setLowPrice(90);
		histEodData.setOpenPrice(90);
		histEodData.setVolume(123456);
		jdbcTemplate.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pst) throws SQLException {
				pst.setString(1, histEodData.getTicker());
				pst.setLong(2, histEodData.getVolume());
				pst.setDouble(3, histEodData.getLowPrice());
				pst.setDouble(4, histEodData.getHighPrice());
				pst.setDouble(5, histEodData.getClosePrice());
				pst.setDouble(6, histEodData.getOpenPrice());
				pst.setDouble(7, histEodData.getAdjClosePrice());
				pst.setDate(8, Date.valueOf(histEodData.getTimeStamp()));

			}
		});

	}

	public List<EodData> getHistEodData(String ticker) {
		String sql = "Select * from HIST_EOD_DATA where ticker=?";
		List<EodData> histEodData = jdbcTemplate.query(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, ticker);

			}
		}, new HistEodDataMapper());
		histEodData.forEach(
				item -> System.out.println(item.getTicker() + " adj close price is  " + item.getAdjClosePrice()));
		return histEodData;
	}

	public void insertHistEodData(List<EodData> eodData) {
		String sql = "insert into hist_eod_data (TICKER,VOLUME,OPEN_PRICE,CLOSE_PRICE,HIGH_PRICE,LOW_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
				+ "values (?,?,?,?,?,?,?,?)";
		jdbcTemplate.batchUpdate(sql, new BatchPreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pst, int i) throws SQLException {
				EodData histEodData = eodData.get(i);
				pst.setString(1, histEodData.getTicker());
				pst.setLong(2, histEodData.getVolume());
				pst.setDouble(3, histEodData.getLowPrice());
				pst.setDouble(4, histEodData.getHighPrice());
				pst.setDouble(5, histEodData.getClosePrice());
				pst.setDouble(6, histEodData.getOpenPrice());
				pst.setDouble(7, histEodData.getAdjClosePrice());
				pst.setDate(8, Date.valueOf(histEodData.getTimeStamp()));

			}

			@Override
			public int getBatchSize() {
				return eodData.size();
			}
		});

	}
	
	
	@SuppressWarnings("unchecked")
	public void insertHistEodData2(List<EodData> eodData) {
		String sql = "insert into hist_eod_data (TICKER,VOLUME,OPEN_PRICE,CLOSE_PRICE,HIGH_PRICE,LOW_PRICE,ADJ_CLOSE_PRICE,TIME_STAMP) "
				+ "values (:ticker,:volume,:lowprice,:closeprice,:highprice,:openprice,:adjcloseprice,:date)";
		
		//Create an array of map
		Map<String, ?>[] params = new HashMap[eodData.size()];
		for(int i=0 ;i<eodData.size();i++) {
			System.out.println(eodData.get(i).getTicker());
			Map m =new HashMap();
			m.put("ticker", eodData.get(i).getTicker());
			m.put("volume",  eodData.get(i).getVolume());
			m.put("lowprice",  eodData.get(i).getLowPrice());
			m.put("closeprice",  eodData.get(i).getLowPrice());
			m.put("openprice",  eodData.get(i).getLowPrice());
			m.put("adjcloseprice",  eodData.get(i).getLowPrice());
			m.put("date",  Date.valueOf(eodData.get(i).getTimeStamp()));
			m.put("highprice",eodData.get(i).getHighPrice());
			 params[i] = m;
		}

	namedParameterJdbcTemplate.batchUpdate(sql, params);

	}

	public List<EodData> getHistEodData2(String ticker) {
		String sql = "Select * from HIST_EOD_DATA where ticker=:ticker";
		MapSqlParameterSource s= new MapSqlParameterSource();
		s.addValue("ticker",ticker);
		List<EodData> eoddatalsit = namedParameterJdbcTemplate.query(sql, s,new HistEodDataMapper() );
		eoddatalsit.forEach(item->{			
			System.out.println(item.getTicker());
		});
		return eoddatalsit;
	}



}
