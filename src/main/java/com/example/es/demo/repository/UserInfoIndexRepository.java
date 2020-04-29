package com.example.es.demo.repository;

import com.example.es.demo.index.UserInfo;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户信息添加索引
 *
 * @author wanzhongsu
 * @date 2020/4/27 16:37
 */
@Component
public interface UserInfoIndexRepository extends ElasticsearchRepository<UserInfo, Integer> {
    /**
     * 根据用户名称获取用户信息
     *
     * @param userName 用户名称
     * @return 用户列表信息
     */
    List<UserInfo> findByUserNameLike(String userName);

    /**
     * 自定义方法
     * @param userName 用户名称  ?0代表变量的意思
     * @return 列表
     */
    @Query("{\"match_phrase\":{\"userName\":\"?0\"}}")
    List<UserInfo> findByUserNameCustom(String userName);
}
