package learnjava.practice.test;


import org.apache.commons.lang3.StringUtils;

public class TaxInfo {
	private String employerNum;
	private String taxRate;
	private String fein;
	private String employerName;
	private String reportingId;
	private Integer lineNumber;
	
	enum TaxRateEnum {

		GDOL_ACCOUNT_NUMBER(1, 8), FEIN(25, 33), EMPLOYER_NAME(34, 78), REPORTING_ID(124, 131);

		private final int start;
		private final int end;

		private TaxRateEnum(int start, int end) {
			this.start = start;
			this.end = end;
		}

		public int getStart() {
			return start;
		}

		public int getEnd() {
			return end;
		}

	}
	
	public TaxInfo(){}
	
	
	
	public TaxInfo(String line){
		if(!StringUtils.isEmpty(line) && line.length() == 150 ){
			setEmployerNum(line.substring(TaxRateEnum.GDOL_ACCOUNT_NUMBER.getStart(), TaxRateEnum.GDOL_ACCOUNT_NUMBER.getEnd()));
			setFein(line.substring(TaxRateEnum.FEIN.getStart(), TaxRateEnum.FEIN.getEnd()));
			setEmployerName(line.substring(TaxRateEnum.EMPLOYER_NAME.getStart(), TaxRateEnum.EMPLOYER_NAME.getEnd()));
			setEmployerName(line.substring(TaxRateEnum.REPORTING_ID.getStart(), TaxRateEnum.REPORTING_ID.getEnd()));			
		}
	}
	
	
	
	public String getEmployerNum() {
		return employerNum;
	}

	public void setEmployerNum(String employerNum) {
		this.employerNum = employerNum;
	}

	public String getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(String taxRate) {
		this.taxRate = taxRate;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getFein() {
		return fein;
	}

	public void setFein(String fein) {
		this.fein = fein;
	}

	public String getReportingId() {
		return reportingId;
	}

	public void setReportingId(String reportingId) {
		this.reportingId = reportingId;
	}



	public Integer getLineNumber() {
		return lineNumber;
	}



	public void setLineNumber(Integer lineNumber) {
		this.lineNumber = lineNumber;
	}

}
