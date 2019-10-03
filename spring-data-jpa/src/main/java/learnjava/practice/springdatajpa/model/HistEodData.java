package learnjava.practice.springdatajpa.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity(name="HIST_EOD_DATA")
@IdClass(value = HistEodDataId.class)

public class HistEodData {
	@Id
	@Column(name="TICKER")
	private String ticker;
	@Column(name="VOLUME")
	private long volume;
	@Column(name="CLOSE_PRICE")
	private double closePrice;
	@Column(name="HIGH_PRICE")
	private double highPrice;
	@Column(name="LOW_PRICE")
	private double lowPrice;
	@Column(name="OPEN_PRICE")
	private double openPrice;
	@Column(name="ADJ_CLOSE_PRICE")
	private double adjClosePrice;
	@Column(name="TIME_STAMP")
	@Id
	private LocalDate date;

	public HistEodData() {
	}

	public HistEodData(String ticker) {
		this.ticker = ticker;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public long getVolume() {
		return volume;
	}

	public void setVolume(long volume) {
		this.volume = volume;
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

	public double getOpenPrice() {
		return openPrice;
	}

	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}

	public double getAdjClosePrice() {
		return adjClosePrice;
	}

	public void setAdjClosePrice(double adjClosePrice) {
		this.adjClosePrice = adjClosePrice;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
}
