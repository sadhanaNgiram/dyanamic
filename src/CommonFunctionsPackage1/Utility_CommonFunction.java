package CommonFunctionsPackage1;
import java.io.File;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utility_CommonFunction {
	public static void EvidenceFileCreator(String filename,String requestBody,String responseBody) throws IOException
	{
		File newfile=new File("C:\\Users\\dell\\Downloads\\New folder\\" +filename+".txt" );
		System.out.println("A new text file is created to record request and response of API :" +newfile.getName());
		//To find file created or not use getName() method
		
		FileWriter datawrite=new FileWriter(newfile); 
		datawrite.write("request Body"+requestBody+ "\n\n");
		datawrite.write("response Body"+responseBody);
		datawrite.close();
		System.out.println("requestbody and resposebody are saved in :" +newfile.getName());
	}

	public static ArrayList<String> readDataExcel(String sheetname,String testcasename) throws IOException
	{
		ArrayList<String> ArrayData=new ArrayList<String>();
		//step1: create the object of File input stream
		FileInputStream fis=new FileInputStream("C:\\Users\\dell\\Downloads\\New folder\\Testdata.xlsx");
		//step2: access the excel file 
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		//step3: access the sheet name
		int countofsheet=workbook.getNumberOfSheets();
		for (int i=0;i<countofsheet;i++)
		{
			String filesheetname=workbook.getSheetName(i);
			if(filesheetname.equalsIgnoreCase(sheetname))
			{
				//step4: access the row from where the data is suppose to fetch
				XSSFSheet sheet=workbook.getSheetAt(i);
				Iterator<Row> rows=sheet.iterator();
			// Row r=rows.next();
				while(rows.hasNext())
				{
					Row r2=rows.next();
					if(r2.getCell(0).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell>cellvalues=r2.cellIterator();
						while(cellvalues.hasNext())
						{
							String Testdata=cellvalues.next().getStringCellValue();
							//System.out.println(Testdata);
							ArrayData.add(Testdata);
						}
					}
				}
			}
		}
		workbook.close();
		return ArrayData;
		
	}

}

 
