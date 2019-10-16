package com.baowen.cloud.controller;

import com.baowen.cloud.service.DataClient;
import com.baowen.cloud.service.WeatherReportService;
import com.baowen.cloud.vo.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Weather Report Controller.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017年11月24日
 */
@RestController
@RequestMapping("/report")
public class WeatherReportController {

    @Autowired
    private WeatherReportService weatherReportService;

    @Autowired
    private DataClient dataClient;

    @GetMapping("/cityId/{cityId}")
    public ModelAndView getReportByCityId(@PathVariable("cityId") String cityId, Model model) throws Exception {
        List<City> cities = dataClient.cityList();
        model.addAttribute("title", "老卫的天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cities);
        model.addAttribute("report", weatherReportService.getDataByCityId(cityId));
        return new ModelAndView("weather/report", "reportModel", model);
    }
}
