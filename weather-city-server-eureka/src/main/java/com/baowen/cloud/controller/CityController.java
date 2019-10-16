package com.baowen.cloud.controller;

import com.baowen.cloud.service.CityDataService;
import com.baowen.cloud.vo.City;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/cities")
public class CityController {

    @Resource
    private CityDataService cityDataService;

    @GetMapping
    public List<City> listCity() throws Exception {
        return cityDataService.listCity();
    }
}
