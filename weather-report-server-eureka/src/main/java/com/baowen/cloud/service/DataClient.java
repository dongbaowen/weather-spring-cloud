package com.baowen.cloud.service;

import com.baowen.cloud.vo.City;
import com.baowen.cloud.vo.WeatherResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(name = "weather-eureka-zuul", fallback = DataClientFallback.class)
public interface DataClient {

    @RequestMapping("/city/cities")
    List<City> cityList();

    @RequestMapping("/data/weather/cityId/{cityId}")
    WeatherResponse getDataByCityId(@PathVariable("cityId") String cityId);
}
