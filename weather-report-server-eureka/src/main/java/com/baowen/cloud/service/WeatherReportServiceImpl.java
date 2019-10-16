package com.baowen.cloud.service;

import com.baowen.cloud.vo.Weather;
import com.baowen.cloud.vo.WeatherResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Weather Report Service.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月24日
 */
@Slf4j
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private DataClient dataClient;

    @Override
    public Weather getDataByCityId(String cityId) {
        WeatherResponse weather = dataClient.getDataByCityId(cityId);
        return weather != null ? weather.getData() : null;
    }
}
