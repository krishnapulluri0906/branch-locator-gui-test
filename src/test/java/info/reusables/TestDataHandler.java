package info.reusables;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.FileUtils;

public class TestDataHandler {
	static HashMap testDataRecordsMapDefault;
	static CSVParser csvParser;
	static String testData;

	public static Map<String, CSVRecord> getDataInstance(String testDataFile) {
		try {
			String env = "uat";
			String dataFilePath = null;
			Reader reader = null;

			dataFilePath = System.getProperty("user.dir") + File.separator + "src" + File.separator + "test"
					+ File.separator + "resources" + File.separator + "testdata" + File.separator + testDataFile + "_"
					+ env + ".csv";

			testDataRecordsMapDefault = new HashMap<String, CSVRecord>();

			File fileCheck = new File(dataFilePath);
			if (fileCheck.exists()) {
				reader = new FileReader(dataFilePath);
			} else {
				String testDataFileTemp = testDataFile + "" + env + ".csv";
				String fileName = "testdata/" + testDataFileTemp;
				File file = File.createTempFile(testDataFileTemp, ".csv");
				InputStream in = ClassLoader.getSystemClassLoader().getResourceAsStream(fileName);
				FileUtils.copyInputStreamToFile(in, file);
				reader = new FileReader(file);
				in.close();
			}

			BufferedReader bufferedReader = new BufferedReader(reader);
			StringBuilder builder = new StringBuilder();
			String line;
			while ((line = bufferedReader.readLine()) != null) {
				builder.append(line.replace("~", ""));
				builder.append("\n");
			}
			final String csvData = builder.toString();
			csvParser = CSVParser.parse(csvData,
					CSVFormat.DEFAULT.withFirstRecordAsHeader().withIgnoreHeaderCase().withTrim());
			Iterable<CSVRecord> csvRecords = csvParser.getRecords();
			for (CSVRecord csvRow : csvRecords) {
				String serviceName = csvRow.get("data_id");
				testDataRecordsMapDefault.put(serviceName, csvRow);

			}

			testData = testDataFile;
			bufferedReader.close();
			reader.close();
			return testDataRecordsMapDefault;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				csvParser.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		testData = testDataFile;
		return testDataRecordsMapDefault;

	}

	public static String getData(String data_ref, String columnName) {
		String columnValue = TestDataHandler.getDataInstance(data_ref.split("\\.")[0]).get(data_ref.split("\\.")[1])
				.get(columnName);
		return columnValue;
	}

}
