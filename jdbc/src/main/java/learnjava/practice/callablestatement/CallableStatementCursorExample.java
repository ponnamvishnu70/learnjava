package learnjava.practice.callablestatement;

public class CallableStatementCursorExample {
	public static void main(String[] args) {
		JdbcCallableStatementCursor jcursor = new JdbcCallableStatementCursor();
		jcursor.getHistoricDataByTicker();
	}

}
