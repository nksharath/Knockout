package com.knockout.excel.read;

import com.knockout.data.RowData;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ExcelReader
{

    public List<RowData> readFile(final String fileName)
    {
        List<RowData> readData = new ArrayList<RowData>();
        InputStream inputStreamRead;
        HSSFWorkbook workbook = null;
        try
        {
            inputStreamRead = new FileInputStream(fileName);
            workbook = new HSSFWorkbook(inputStreamRead);
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }

        final HSSFSheet sheetOne = workbook.getSheet("Sheet1");
        final Iterator rowIter = sheetOne.rowIterator();

        while (rowIter.hasNext())
        {
            final HSSFRow row = (HSSFRow) rowIter.next();
            final Iterator cellIter = row.cellIterator();
            final String amount = cellIter.hasNext() ? (cellIter.next()).toString() : "";
            final String identifier = cellIter.hasNext() ? (cellIter.next()).toString() : "";

            if (!amount.equals("") && !identifier.equals(""))
            {
                final String amountClean = amount.trim().replaceAll("$", "");
                final String identifierClean = identifier.trim().replaceAll("$", "");
                readData.add(new RowData(amountClean, identifierClean));
            }
        }

        return readData;
    }

}
