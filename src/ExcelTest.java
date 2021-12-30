
//import org.apache.poi.xssf.usermodel.XSSFCell;
//import org.apache.poi.xssf.usermodel.XSSFRow;
//import org.apache.poi.xssf.usermodel.XSSFSheet;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class ExcelTest {

    public static void readFile(){
//        try {
//            String filePath = "/Users/yjw8459/Desktop/Project/Dream /excelTest.xlsx" ;
//            File file = new File(filePath);
//            System.out.println(file.getName());
//
//
//            //엑셀 파일 로딩
//            FileInputStream fis = new FileInputStream(file);
//            XSSFWorkbook workBook = new XSSFWorkbook(fis);
//            System.out.println(fis);
//
//            //XSSFSheet xSheet = workBook.createSheet("test시트");        //시트 생성
//            int sheeetNum = workBook.getNumberOfSheets();                //시트 갯수 얻기
//            System.out.println(sheeetNum);
//
//            /**
//             *
//             */
//            for (int loop = 0; loop < sheeetNum; loop++){
//                XSSFSheet sheet = workBook.getSheetAt(loop);   //i 번째 sheet 부터 작업 시작
//                int rows = sheet.getPhysicalNumberOfRows();//행 갯수 출력
//                System.out.println(rows);
//                for ( int rowNum = 0; rowNum < rows; rowNum ++ ){
//                    XSSFRow row = sheet.getRow(rowNum);
//                    if ( row != null ){
//                        int cells = row.getPhysicalNumberOfCells();
//                        for ( int cellNum = 0; cellNum < cells; cellNum++ ){
//                            System.out.println(cells);
//                            XSSFCell cell = row.getCell(cellNum);
//                        }
//                    }
//                }
//            }
//
//            FileOutputStream fos = new FileOutputStream(file);  //FileOutStream
//            workBook.write(fos);                                //작성 내용 저장
//        }
//        catch (Exception e){ e.printStackTrace(); }
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
