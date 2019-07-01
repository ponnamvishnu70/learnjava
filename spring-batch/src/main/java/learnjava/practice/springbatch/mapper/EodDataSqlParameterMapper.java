package learnjava.practice.springbatch.mapper;

import java.sql.Date;

import org.springframework.batch.item.database.ItemSqlParameterSourceProvider;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import learnjava.practice.springbatch.model.EodData;

public class EodDataSqlParameterMapper implements ItemSqlParameterSourceProvider<EodData> {
	public SqlParameterSource createSqlParameterSource(EodData item) {
		MapSqlParameterSource sps = new MapSqlParameterSource();
		sps.addValue("ticker", item.getTicker());
		sps.addValue("volume", item.getVolume());
		sps.addValue("closePrice", item.getClosePrice());
		sps.addValue("openPrice", item.getOpenPrice());
		sps.addValue("highPrice", item.getHighPrice());
		sps.addValue("lowPrice", item.getLowPrice());
		sps.addValue("adjClosePrice", item.getAdjClosePrice());
		sps.addValue("timeStamp", Date.valueOf(item.getTimeStamp()));
		return sps;
	}

}
