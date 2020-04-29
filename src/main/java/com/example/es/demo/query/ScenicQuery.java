package com.example.es.demo.query;

import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

/**
 * todo
 *
 * @author wanzhongsu
 * @date 2020/4/24 16:24
 */
@Data
@Accessors(chain = true)
public class ScenicQuery {
    private double lng;
    private double lat;
    private String name;
    private BigDecimal price;
    private String tel;
}
