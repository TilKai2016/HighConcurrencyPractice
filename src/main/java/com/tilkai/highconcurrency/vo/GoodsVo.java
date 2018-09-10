package com.tilkai.highconcurrency.vo;

import com.tilkai.highconcurrency.domain.Goods;
import lombok.Data;

import java.util.Date;

/**
 * Note:
 *
 * @author tilkai
 * @date 2018-09-10 下午4:25
 */
@Data
public class GoodsVo extends Goods {

    /**
     * 秒杀价格
     */
    private Double miaoshaPrice;

    /**
     * 库存
     */
    private Integer stockCount;

    /**
     * 秒杀开始时间
     */
    private Date startDate;

    /**
     * 秒杀结束时间
     */
    private Date endDate;
}
