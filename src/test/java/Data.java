import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Data {

	
	public ArrayList<String> getdata(String testcasename) throws IOException {
		
		
		ArrayList<String> a=new ArrayList<String>();
		
		FileInputStream fis=new FileInputStream("E://Anand.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		
	int sheets=workbook.getNumberOfSheets();
	
		for (int i = 0; i < sheets; i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet=workbook.getSheetAt(i);
				//identify testcases column  by scanning the entire first row
				
				Iterator<Row> rows=sheet.iterator();//sheet is collection or rows
				
				Row firstrow=rows.next();
				
				Iterator<Cell> ce=firstrow.cellIterator();//row is collection of cells
				int k=0;
				int column=0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						
						column=k;
					}
					k++;
					
				}
				System.out.println(column);
				while (rows.hasNext()) {
					Row R =rows.next();
					
					if(R.getCell(column).getStringCellValue().equalsIgnoreCase(testcasename))
					{
						Iterator<Cell> cv=R.cellIterator();
						while (cv.hasNext()) {
							
							Cell c=cv.next();
							
							if(c.getCellType()==CellType.STRING)
							{
						a.add(c.getStringCellValue());
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							}
						}
					}
				}
			}
		
	
		return a;
	}
	
}