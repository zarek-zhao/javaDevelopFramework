package com.zarek.transactionspring.domain;

/**
 * @author zhao
 * @date 2021/3/3 11:20
 */
public class Sale {

    private Integer id;
    private Integer gid;
    private Integer nums;

    public Sale()
    {
    }

    public void setId(Integer id)
    {
        this.id = id;
    }

    public void setGid(Integer gid)
    {
        this.gid = gid;
    }

    public void setNums(Integer nums)
    {
        this.nums = nums;
    }

    @Override
    public String toString()
    {
        return "Sale{" +
                "id=" + id +
                ", gid=" + gid +
                ", nums=" + nums +
                '}';
    }
}
