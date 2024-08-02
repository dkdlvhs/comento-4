package com.demo.comentoStatistic.controller;
import com.demo.comentoStatistic.dto.DepartmentMonthCountDto;
import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import com.demo.comentoStatistic.service.StatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
public class StatisticController {

    @Autowired
    StatisticService statisticService;


    @RequestMapping(value="/api/v1/logins/{year}", produces = "application/json")
    @ResponseBody
    public ResponseEntity<YearCountDto> getYearLoginCount(@PathVariable("year") String year){

        return ResponseEntity.ok(statisticService.getYearLogins(year));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthLoginCount(@PathVariable("year") String year, @PathVariable("month") String month){

        return ResponseEntity.ok(statisticService.getYearMonthLogins(year, month));
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}//{department}")
    @ResponseBody
    public ResponseEntity<List<DepartmentMonthCountDto>> getDepartmentMonthlyLogins(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("department") String department) {

        List<DepartmentMonthCountDto> result = statisticService.getDepartmentMonthlyLogins(year, month, department);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}/{day}", produces = "application/json")
    @ResponseBody
    public Object getYearMonthDayLoginCount(@PathVariable("year") String year, @PathVariable("month") String month, @PathVariable("day") String day){

        return ResponseEntity.ok(statisticService.getYearMonthDayLogins(year, month, day));
    }

    @RequestMapping(value = "/api/v1/logins/average-daily", produces = "application/json")
    @ResponseBody
    public ResponseEntity<Double> getAverageDailyLogins() {

        return ResponseEntity.ok(statisticService.getAverageDailyLogins());
    }

    @RequestMapping(value="/api/v1/logins/{year}/{month}/exclude-holiday", produces = "application/json")
    @ResponseBody
    public ResponseEntity<List<YearMonthCountDto>> getMonthLoginsExcludingHolidays(
            @PathVariable("year") String year,
            @PathVariable("month") String month) {

        List<YearMonthCountDto> result = statisticService.getMonthLoginsExcludingHolidays(year, month);
        return ResponseEntity.ok(result);
    }

}
