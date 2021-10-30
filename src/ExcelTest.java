
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelTest {

    public static void readFile(){
        try {
            String filePath = "/Users/yjw8459/Desktop/Project/Dream /excelTest.xlsx" ;
            File file = new File(filePath);
            System.out.println(file.getName());


            //엑셀 파일 로딩
            FileInputStream fis = new FileInputStream(file);
            //POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
            XSSFWorkbook workBook = new XSSFWorkbook(fis);
            System.out.println(fis);

            int sheeetNum = workBook.getNumberOfSheets();   //시트 갯수 얻기
            System.out.println(sheeetNum);

            for (int loop = 0; loop < sheeetNum; loop++){
                XSSFSheet sheet = workBook.getSheetAt(loop);   //i 번째 sheet 부터 작업 시작
                int rows = sheet.getPhysicalNumberOfRows();//행 갯수 출력
                for ( int rowNum = 0; rowNum < rows; rowNum ++ ){
                    XSSFRow row = sheet.getRow(rowNum);
                    if ( row != null ){
                        int cells = row.getPhysicalNumberOfCells();
                        for ( int cellNum = 0; cellNum < cells; cellNum++ ){
                            XSSFCell cell = row.getCell(cellNum);

                        }
                    }
                }

            }

        }
        catch (Exception e){ e.printStackTrace(); }
    }


//    public static void excelParsing(){
//        Workbook wb = new HSSFWorkbook();
//        Sheet sheet = wb.createSheet("테스트1");
//        Row row = null;
//        Cell cell = null;
//        int rowNo = 0;
//
//
//    }
}
