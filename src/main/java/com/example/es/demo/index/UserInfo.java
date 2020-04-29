package com.example.es.demo.index;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 用户信息展示
 *
 * @author wanzhongsu
 * @date 2020/4/27 16:31
 */

@Data
@Accessors(chain = true)
@Document(indexName = "user_info", type = "user")
public class UserInfo {

    @Id
    private Integer userId;
    @Field(type = FieldType.Integer)
    private Integer userAge;
    @Field(type = FieldType.Keyword)
    private String userName;
    @Field(type = FieldType.Keyword)
    private String userTel;
    @Field(type = FieldType.Date, format = DateFormat.custom, pattern = "yyyy-MM-dd HH:mm:ss")
    private String birthDay;
    /**
     * 经纬度坐标 lat 维度  lon经度
     */
    @GeoPointField
    private GeoPoint location;
}
