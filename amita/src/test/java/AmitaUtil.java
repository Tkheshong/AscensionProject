
import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kohli
 */
public class AmitaUtil {
    
    public static AmitaVO getData() throws Exception{
        
        
     FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));

        Workbook workbook = new XSSFWorkbook(inputStream);
        //getting first worksheet
        Sheet firstSheet = workbook.getSheetAt(0);
       //get first row
        Row r =  firstSheet.getRow(0);  //first row
        Cell c = r.getCell(1); //username value
        String citystatezip = c.getStringCellValue();

        AmitaVO amitaVO  = new AmitaVO (citystatezip);

        System.out.println(amitaVO);

        inputStream.close();

        return amitaVO;
    
}
    
     public static AmitaVO1 getData1() throws Exception{
    
          FileInputStream inputStream = new FileInputStream(new File("c:\\data\\Amita.xlsx"));
         Workbook workbook = new XSSFWorkbook(inputStream);
         Sheet secondSheet = workbook.getSheetAt(1);
         for(int i=1; i<=6; i++){
         Row r =  secondSheet.getRow(0);  //first row
        Cell c = r.getCell(i); //username value
        String user = c.getStringCellValue();

        r =  secondSheet.getRow(1);  //second row 
        c = r.getCell(i); //password value
        String lastname = c.getStringCellValue();
        r =  secondSheet.getRow(2);  //third row 
        c = r.getCell(i); //email value
        String dob = c.getStringCellValue();
         r =  secondSheet.getRow(3);  //second row 
        c = r.getCell(i); //password value
        String doby = c.getStringCellValue();
        r =  secondSheet.getRow(4);  //third row 
        c = r.getCell(i); //email value
        String pdob = c.getStringCellValue();
         r =  secondSheet.getRow(5);  //third row 
        c = r.getCell(i); //email value
        String pdoby = c.getStringCellValue();
        
         AmitaVO1 amitaVO1  = new AmitaVO1 (user,lastname,dob,doby,pdob,pdoby);

        System.out.println(amitaVO1);

        inputStream.close();

        return amitaVO1;
         
     }
         return null;
     }
}
