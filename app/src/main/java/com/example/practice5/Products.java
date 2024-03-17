package com.example.practice5;

import java.util.ArrayList;
import java.util.List;

public class Products {
    public List<String> products = new ArrayList<String>();
    private Integer count = 0;
    public void addItem(String nameItem)
    {
        products.add(nameItem);
        count+=1;
    }
    public String[] getAllItem()
    {
//        String[] arrProducts = new String[count];
//        for(int i = 0; i < count; i++)
//        {
//            arrProducts[i] = products.get(i);
//        }
        return products.toArray(new String[count]);
    }
    public Integer getCount()
    {
        return count;
    }
//    public void remove(int index)
//    {
//        products.remove(index);
//        count--;
//    }
public void remove(List<Integer> index)
    {
        for(int i = 0; i < index.size(); i++)
        {
            products.remove(Math.abs(i-index.get(i)));
        }
        count = count - index.size();
    }
}
