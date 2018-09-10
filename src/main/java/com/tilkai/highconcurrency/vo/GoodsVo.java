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

    private Double miaoshaPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
