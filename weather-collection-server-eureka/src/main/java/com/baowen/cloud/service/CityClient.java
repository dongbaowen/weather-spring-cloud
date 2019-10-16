package com.baowen.cloud.service;

import com.baowen.cloud.vo.City;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("weather-city-eureka")
public interface CityClient {

    @RequestMapping("cities")
    List<City> cityList();
}
