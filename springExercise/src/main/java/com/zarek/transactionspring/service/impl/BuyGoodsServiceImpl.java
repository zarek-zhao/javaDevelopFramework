package com.zarek.transactionspring.service.impl;

import com.zarek.transactionspring.dao.GoodsDao;
import com.zarek.transactionspring.dao.SaleDao;
import com.zarek.transactionspring.domain.Goods;
import com.zarek.transactionspring.domain.Sale;
import com.zarek.transactionspring.exception.NotEnoughExcepion;
import com.zarek.transactionspring.service.BuyGoodsService;

/**
 * @author zhao
 * @date 2021/3/3 11:52
 */
public class BuyGoodsServiceImpl implements BuyGoodsService {

    private GoodsDao goodsDao;
    private SaleDao saleDao;

    public void setGoodsDao(GoodsDao goodsDao)
    {
        this.goodsDao = goodsDao;
    }

    public void setSaleDao(SaleDao saleDao)
    {
        this.saleDao = saleDao;
    }

//    @Transactional(propagation = Propagation.REQUIRED,
//                    rollbackFor = {NotEnoughExcepion.class,
//                                    NullPointerException.class})
    @Override
    public void buy(Integer goodsId, Integer amount)
    {

        Sale sale = new Sale();
        sale.setGid(goodsId);
        sale.setNums(amount);

        saleDao.insertSale(sale);
        Goods goods = goodsDao.selectGoods(goodsId);
        if(goods == null){
            throw new NullPointerException("无此商品");
        }

        if(goods.getAmount() < amount){
            throw new NotEnoughExcepion("库存不足");
        }

        goods = new Goods();
        goods.setAmount(amount);
        goods.setId(goodsId);
        goodsDao.updateGoods(goods);
    }
}
