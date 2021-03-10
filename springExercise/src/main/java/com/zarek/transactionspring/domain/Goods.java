package com.zarek.transactionspring.domain;

/**
 * @author zhao
 * @date 2021/3/3 11:18
 */
public class Goods {

    private Integer id;
    private String name;
    private Integer amount;
    private float price;

    public Goods()
    {
    }

    public Integer getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public Integer getAmount()
    {
        return amount;
    }

    public float getPrice()
    {
        return price;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAmount(Integer amount)
    {
        this.amount = amount;
    }

    public void setPrice(float price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Goods{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
