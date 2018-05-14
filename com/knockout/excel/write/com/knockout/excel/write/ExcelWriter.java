package com.knockout.excel.write;

import com.knockout.data.RowData;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ExcelWriter
{
    public void writeToExcel(final List<RowData> data, final String fileName)
    {

        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet sheet = workbook.createSheet("Sheet1");
        int rowNum = 0;
        for (final RowData currentData : data)
        {
            final Row row = sheet.createRow(rowNum++);
            final Cell amountCell = row.createCell(0);
            final Cell identifierCell = row.createCell(1);
            amountCell.setCellValue(Double.parseDouble(currentData.getAmount()));
            identifierCell.setCellValue(currentData.getIdentfier());
        }
        try
        {
            FileOutputStream outputStream = new FileOutputStream(fileName);
            workbook.write(outputStream);
            workbook.close();
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
