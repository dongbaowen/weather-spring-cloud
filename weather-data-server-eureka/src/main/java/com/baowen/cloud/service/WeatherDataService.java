package com.baowen.cloud.service;

import com.baowen.cloud.vo.WeatherResponse;

/**
 * Weather Data Service.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月22日
 */
public interface WeatherDataService {
    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    WeatherResponse getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @return
     */
    WeatherResponse getDataByCityName(String cityName);
}
