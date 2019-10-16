package com.baowen.cloud.job;

import com.baowen.cloud.service.CityClient;
import com.baowen.cloud.service.WeatherDataCollectionService;
import com.baowen.cloud.vo.City;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Weather Data Sync Job.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月23日
 */
public class WeatherDataSyncJob extends QuartzJobBean {

    private final static Logger logger = LoggerFactory.getLogger(WeatherDataSyncJob.class);

    @Autowired
    private WeatherDataCollectionService weatherDataCollectionService;

    @Autowired
    private CityClient cityClient;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        logger.info("Weather Data Sync Job. Start！");
        // 获取城市ID列表
        List<City> cityList = cityClient.cityList();

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            logger.info("Weather Data Sync Job, cityId:" + cityId);

            weatherDataCollectionService.syncDateByCityId(cityId);
        }

        logger.info("Weather Data Sync Job. End！");
    }

}
