package learnjava.practice.springbatch.model;


import java.sql.Date;
import java.time.LocalDate;

import learnjava.practice.springbatch.BaseResourceAware;


public class EodData extends BaseResourceAware {

	private long volume;
	private double openPrice;
	private double closePrice;
	private double highPrice;
	private double lowPrice;
	private Double adjClosePrice;
	private String ticker;
	private LocalDate timeStamp;

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
	}

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getClosePrice() {
		return closePrice;
	}

	public void setClosePrice(double closePrice) {
		this.closePrice = closePrice;
	}

	public double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(double highPrice) {
		this.highPrice = highPrice;
	}

	public double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(double lowPrice) {
		this.lowPrice = lowPrice;
	}

	public Double getAdjClosePrice() {
		return adjClosePrice;
	}

	public void setAdjClosePrice(Double adjClosePrice) {
		this.adjClosePrice = adjClosePrice;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public LocalDate getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(LocalDate timeStamp) {
		this.timeStamp = timeStamp;
	}

}
