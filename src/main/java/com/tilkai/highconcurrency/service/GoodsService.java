package com.tilkai.highconcurrency.service;

import com.tilkai.highconcurrency.dao.GoodsDao;
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
}
