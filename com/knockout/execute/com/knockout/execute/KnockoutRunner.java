package com.knockout.execute;

import com.knockout.core.KnockoutLogic;
import com.knockout.data.RowData;
import com.knockout.excel.read.ExcelReader;
import com.knockout.excel.write.ExcelWriter;

import java.util.List;

public class KnockoutRunner
{
    public static void main(String args[])
    {
        ExcelReader reader = new ExcelReader();
        ExcelWriter writer = new ExcelWriter();
        KnockoutLogic knockoutLogic = new KnockoutLogic();

        List<RowData> data = reader.readFile("C:\\Users\\NK\\IdeaProjects\\Knockout\\tally.xls");
        List<RowData> untalliedData = knockoutLogic.calculateKnockout(data);
        writer.writeToExcel(untalliedData,"untallied.xls");

    }
}
