package com.example.practice5;

public class Products {
    private String[] prosucts;
    private Integer count;
    public void addItem(String nameItem)
    {
        prosucts[count] = nameItem;
        count+=1;
    }
    public String[] getAllItem()
    {
        return prosucts;
    }
    public Integer getCount()
    {
        return count;
    }
}
