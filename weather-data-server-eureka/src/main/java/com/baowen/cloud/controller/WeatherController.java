package com.baowen.cloud.controller;

import com.alibaba.fastjson.JSON;
import com.baowen.cloud.service.WeatherDataService;
import com.baowen.cloud.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Weather Controller.
 */
@Slf4j
@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping("/cityId/{cityId}")
    public WeatherResponse getWeatherByCityId(@PathVariable("cityId") String cityId) {
        WeatherResponse dataByCityId = weatherDataService.getDataByCityId(cityId);
        return dataByCityId;
    }

    @GetMapping("/cityName/{cityName}")
    public WeatherResponse getWeatherByCityName(@PathVariable("cityName") String cityName) {
        WeatherResponse dataByCityId = weatherDataService.getDataByCityName(cityName);
        return dataByCityId;
    }
}
