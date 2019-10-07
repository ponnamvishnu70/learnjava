package learnjava.practice.springdatajpa.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;

public class HistEodDataId implements Serializable{
	
	@Column(name="TICKER")
	private String ticker;
	
	@Column(name="TIME_STAMP")
	private LocalDate date;
	
	public HistEodDataId() {}

	public HistEodDataId(String ticker, LocalDate date) {
		this.ticker=ticker;
		this.date=date;
	}
	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}
	
	
	

}
