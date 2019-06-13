package learnjava.practice.jdbcstatement;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import learnjava.practice.model.HistEodData;

//Use PreparedStatement instead of Statement
public class StatementExample {

	public static List<HistEodData> readHistEodDataCsv(final String fileLoc) throws IOException {
		String ticker = fileLoc.substring(fileLoc.lastIndexOf("\\") + 1, fileLoc.lastIndexOf("."));
		System.out.println(ticker);
		BufferedReader br = new BufferedReader(new FileReader(fileLoc));

		List<HistEodData> historicData = new ArrayList<>();

		String currentLine;
		if ((currentLine = br.readLine()) != null) {
			System.out.println(currentLine);
		}
		while ((currentLine = br.readLine()) != null) {
			String[] data = currentLine.split(",");
			HistEodData historicEodData = new HistEodData(ticker);
			for (int i = 0; i < data.length; i++) {
				switch (i) {
				case 0: {
					LocalDate ldt = LocalDate.parse(data[0]);
					historicEodData.setDate(ldt);
				}
				case 1: {
					historicEodData.setOpenPrice(Double.parseDouble(data[1]));
				}
				case 2: {
					historicEodData.setHighPrice(Double.parseDouble(data[2]));
				}
				case 3: {
					historicEodData.setLowPrice(Double.parseDouble(data[3]));
				}
				case 4: {
					historicEodData.setClosePrice(Double.parseDouble(data[4]));
				}
				case 5: {
					historicEodData.setAdjClosePrice(Double.parseDouble(data[5]));
				}
				case 6: {
					historicEodData.setVolume(Long.parseLong(data[6]));
					;
				}
				}

			}
			historicData.add(historicEodData);

		}
		return historicData;
	}

	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException {
		JdbcStatementExample js = new JdbcStatementExample();
		List<HistEodData> list = js.getEodData("AAPL");
		System.out.println("list size" + list.size());
		list.forEach(s -> {
			System.out.println(s.getTicker());
			System.out.println(s.getClosePrice());
		});
		String fileLocation = "C:\\Workspace\\MDT.csv";
		 List<HistEodData> histEodData = readHistEodDataCsv(fileLocation);
		js.insertEodData(histEodData);
		HistEodData heod = new HistEodData();
		heod.setTicker("MDT");
		heod.setAdjClosePrice(90);
		heod.setClosePrice(90);
		heod.setDate(LocalDate.parse("2018-09-06"));
		heod.setHighPrice(90);
		heod.setLowPrice(90);
		heod.setOpenPrice(90);
		heod.setVolume(66666);
		js.insertEodData(heod);

	}
}
