package com.baowen.cloud.service;

import com.baowen.cloud.vo.City;
import com.baowen.cloud.vo.WeatherResponse;
import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DataClientFallback implements DataClient {
    @Override
    public List<City> cityList() {
        City city = new City();
        city.setCityId("101280601");
        city.setCityName("深圳");
        return Lists.newArrayList(city);
    }

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        return null;
    }
}
