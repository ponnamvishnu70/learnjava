package learnjava.practice.jdbcstatement;

import java.util.List;

public class StatementExample {

	public static void main(String[] args) {
		JdbcStatementExample js = new JdbcStatementExample();
		List<HistEodData> list = js.getEodData("AAPL");
		list.forEach(s -> {
			System.out.println(s.getTicker());
			System.out.println(s.getClosePrice());
		});
	}
}
