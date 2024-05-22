package org.foden.utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.foden.constants.FrameworkConstants;
import org.foden.exceptions.InvalidPathForExcelFileException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

public final class ExcelUtils {

    private ExcelUtils(){}

    /**
     * Get test details list.
     *
     * @param sheetname the sheetname
     * @return the list
     */
    public static List<Map<String,String>> getTestDetails(String sheetname){
        List<Map<String,String>> list = null;
        FileInputStream fs = null;
        try {
            fs = new FileInputStream(FrameworkConstants.getExcelpath());
            XSSFWorkbook workbook = new XSSFWorkbook(fs);
            XSSFSheet sheet = workbook.getSheet(sheetname);

            Map<String, String> map = null;
            list = new ArrayList<>();

            int lastRowNum = sheet.getLastRowNum();
            int lastColNum = sheet.getRow(0).getLastCellNum();

            for (int i = 1; i <= lastRowNum; i++) {
                map = new HashMap<>();
                for (int j = 0; j < lastColNum; j++) {

                    String key = sheet.getRow(0).getCell(j).getStringCellValue();
                    System.out.println("Key: " + key);

                    String value = sheet.getRow(i).getCell(j).getStringCellValue();
                    System.out.println("Value: " + value);
                    map.put(key,value);
                }
                list.add(map);
            }

        } catch (FileNotFoundException e){
            throw new InvalidPathForExcelFileException("Excel file you trying to read is not found!!!",e);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (Objects.nonNull(fs)){
                    fs.close();
                }
            } catch (IOException e){
                throw new RuntimeException();
            }
        }

        return list;
    }
}
