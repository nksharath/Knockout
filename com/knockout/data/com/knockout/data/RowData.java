package com.knockout.data;

public class RowData
{
    private final String amount;
    private final String identfier;

    public RowData(final String amount, final String identfier)
    {
        this.amount = amount;
        this.identfier = identfier;
    }

    public String getAmount()
    {
        return amount;
    }

    public String getIdentfier()
    {
        return identfier;
    }
}
