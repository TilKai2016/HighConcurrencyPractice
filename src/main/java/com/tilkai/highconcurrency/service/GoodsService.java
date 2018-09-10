package com.tilkai.highconcurrency.service;

import com.tilkai.highconcurrency.dao.GoodsDao;
import com.tilkai.highconcurrency.domain.Goods;
import com.tilkai.highconcurrency.domain.MiaoshaGoods;
import com.tilkai.highconcurrency.vo.GoodsVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午4:22
 */
@Service
public class GoodsService {

    @Autowired
    private GoodsDao goodsDao;

    public List<GoodsVo> listGoodsVo() {
        return goodsDao.listGoodsVo();
    }

    public GoodsVo getGoodsVoById(long id) {
        return goodsDao.getGoodsVoById(id);
    }

    /**
     * note 减少库存
     * @param goods
     * @return
     * @author tilkai
     * @date 2018/9/10
     */
    public void reduceStock(GoodsVo goods) {
        MiaoshaGoods g = new MiaoshaGoods();
        g.setGoodsId(goods.getId());
//        g.setStockCount(goods.getGoodsStock() - 1);
        goodsDao.reduceStock(g);
    }
}
