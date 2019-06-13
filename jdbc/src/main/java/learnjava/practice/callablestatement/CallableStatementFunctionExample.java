package learnjava.practice.callablestatement;

public class CallableStatementFunctionExample {
	public static void main(String[] args) {
		JdbcCallableStatementFunction jcsf = new JdbcCallableStatementFunction();
		jcsf.getCompanyInfo("MDT");
	}

}
