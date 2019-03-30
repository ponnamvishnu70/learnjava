package learnjava.practice.exceptions;

public class ExceptionExample {

	public void throwException() {
		try {
			throw new CustomCheckException("test checked  exception");
		} catch (CustomCheckException e) {
			System.out.println("just printing stack trace....execution will continue");
			e.printStackTrace();
		}
	}

	public void throwExceptionAgain() throws CustomCheckException {
		throw new CustomCheckException("test THROW ");
	}

	public void throwRuntimeException() {
		try {
			throw new CustomCheckException("test throwRuntimeException try catch");
		} catch (CustomCheckException e) {
			e.printStackTrace();
		}
	}

	public void throwRuntimeExceptionAgain() throws CustomCheckException {
		throw new CustomCheckException("test throwRuntimeException THROWS");
	}

	public static void main(String[] args) {
		ExceptionExample exception = new  ExceptionExample();
		exception.throwException();
		try {
			exception.throwExceptionAgain();
		} catch (CustomCheckException e) {
			System.out.println("do nothing");
		}
	}

}
