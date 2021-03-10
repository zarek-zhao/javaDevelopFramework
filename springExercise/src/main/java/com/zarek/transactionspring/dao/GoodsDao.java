package com.zarek.transactionspring.dao;

import com.zarek.transactionspring.domain.Goods;

/**
 * @author zhao
 * @date 2021/3/3 11:21
 */
public interface GoodsDao {

    int updateGoods(Goods goods);
    Goods selectGoods(Integer goodsId);

}
