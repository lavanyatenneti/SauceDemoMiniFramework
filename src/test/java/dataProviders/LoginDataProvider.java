package dataProviders;

import java.util.List;

import org.testng.annotations.DataProvider;

import utils.CSVReaderUtil;

public class LoginDataProvider
{

	@DataProvider(name="loginCredentialsfromCSV")
	public Object[][] getLoginDataCSV()
	{
		String path="src/test/resources/testdata.csv";
		List<String[]> records=CSVReaderUtil.readCSV(path);
		
		Object[][] data=new Object[records.size()][2];
		for(int i=0;i<records.size();i++)
		{
			data[i][0]=records.get(i)[0];
			data[i][1]=records.get(i)[1];
		}
		return data;
	}
}
