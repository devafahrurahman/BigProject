import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class dataDriven {

//    Identify testcases coloum by scanning the entire 1st row
//    once coloun is identify then scan entire coloum to identify puechase testcase row
//     after you drive purchase testcas erow = pull all the data of taht row and feed into test

    public static void main(String[] args) throws IOException {

//        FileInputStream argument
        FileInputStream fis = new FileInputStream("E:\\QA\\Big Project\\DataDriven\\demodata.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(fis);

        int sheets = workbook.getNumberOfSheets();
        for (int i=0; i<sheets; i++){
            if (workbook.getSheetName(i).equalsIgnoreCase("testdata")) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                //    Identify testcases coloum by scanning the entire 1st row
                Iterator<Row> rows = sheet.iterator();
                Row firstrow = rows.next();
                Iterator<Cell> ce = firstrow.cellIterator();
                int k = 0;
                int coloum = 0;
                while (ce.hasNext()){
                    Cell value = ce.next();
                    if (value.getStringCellValue().equalsIgnoreCase("Data2")){
//                        desired coloumn
                        coloum = k;

                    }
                    k++;
                }
                System.out.println(coloum);

            }
        }
    }
}
