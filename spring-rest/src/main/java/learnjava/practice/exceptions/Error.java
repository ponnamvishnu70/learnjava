package learnjava.practice.exceptions;

import org.springframework.stereotype.Component;

public class Error {

	private String error_cde;
	private String msg;

	public Error(String error_cde, String msg) {
		this.error_cde = error_cde;
		this.msg = msg;
	}

	public String getError_cde() {
		return error_cde;
	}

	public void setError_cde(String error_cde) {
		this.error_cde = error_cde;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
