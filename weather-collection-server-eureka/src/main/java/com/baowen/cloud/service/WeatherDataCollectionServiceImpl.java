package com.baowen.cloud.service;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherDataCollectionServiceImpl implements WeatherDataCollectionService {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataCollectionServiceImpl.class);

    @Autowired
    private RestTemplate restTemplate;

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";

    @Override
    public void syncDateByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        this.saveWeatherData(uri);
    }

    /**
     * 把天气数据放在缓存
     *
     * @param uri
     */
    private void saveWeatherData(String uri) {

        // 调用服务接口来获取
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        logger.info("进行缓存 respString: {}", JSON.toJSONString(respString));
    }
}
