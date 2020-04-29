package com.example.es.demo.controller;

import com.example.es.demo.index.UserInfo;
import com.example.es.demo.repository.UserInfoIndexRepository;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.geo.Point;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 前端控制器
 *
 * @author wanzhongsu
 * @date 2020/4/24 16:22
 */
@RestController
@RequestMapping("/es")
public class EsController {

    @Resource
    private UserInfoIndexRepository repository;

    @PostMapping("/add")
    public Object add(@RequestBody UserInfo userInfo) {
        return repository.save(userInfo);
    }

    @PostMapping("/update")
    public Object update(@RequestBody UserInfo userInfo) {
        return repository.save(userInfo);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Integer id) {
        repository.deleteById(id);
    }

    @GetMapping("/get/{id}")
    public Object getById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    @GetMapping("/search")
    public Object search(@RequestParam("userName") String userName) {
        List<UserInfo> userInfos = repository.findByUserNameLike(userName);
        return userInfos;
    }

    @GetMapping("/test1")
    public void test1() {
        GeoPoint geoPoint = GeoPoint.fromPoint(new Point(26.3786639200, 106.6315412500));
        UserInfo userInfo = new UserInfo().setUserAge(24).setUserId(1).setUserName("花溪大学城")
                .setUserTel("13565987852").setBirthDay("1995-01-11 23:23:54").setLocation(geoPoint);
        repository.save(userInfo);
    }
}
