package com.example.es.demo.entity;

import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.GeoPointField;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;

import java.math.BigDecimal;

/**
 * 景点
 *
 * @author wanzhongsu
 * @date 2020/4/24 16:11
 */
@Data
@Accessors(chain = true)
public class ScenicSpot {
    @GeoPointField
    private GeoPoint location;
    private String scenicName;
    private BigDecimal scenicPrice;
    private String scenicTel;
}
