package com.example.poetry;

import com.example.poetry.base.entity.Echarts;
import com.example.poetry.dao.GushiDao;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class PoetryApplicationTests {
    @Resource
    private GushiDao gushiDao;

    @Test
    public void test1(){
        List<Echarts> countryCount = gushiDao.getCountryCount();
//        for (int i = 0; i < countryCount.size(); i++) {
//            System.out.println(countryCount.get(i));
//        }
//        System.out.println(countryCount);
        Map<String,Object> maps = new HashMap<>();
        maps.put("series",countryCount);
        for (int i = 0; i < maps.size(); i++) {
            System.out.println(maps.get(i));
        }
    }

}
