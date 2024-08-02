package com.demo.comentoStatistic.service;

import com.demo.comentoStatistic.dao.StatisticMapper;
import com.demo.comentoStatistic.dto.DepartmentMonthCountDto;
import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import com.demo.comentoStatistic.dto.YearMonthDayCountDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StatisticService {


    @Autowired
    StatisticMapper statisticMapper;

    public YearCountDto getYearLogins(String year){

        return statisticMapper.selectYearLogin(year);
    }

    public YearMonthCountDto getYearMonthLogins(String year, String month){

        return statisticMapper.selectYearMonthLogin(year+month);
    }

    public YearMonthDayCountDto getYearMonthDayLogins(String year, String month, String day){

        return statisticMapper.selectYearMonthDayLogin(year+month+day);
    }

    public List<DepartmentMonthCountDto> getDepartmentMonthlyLogins(String year, String month, String department) {
        String yearMonth = year + month;
        Map<String, String> params = new HashMap<>();
        params.put("yearMonth", yearMonth);
        params.put("department", department);

        return statisticMapper.selectDepartmentMonthlyLogin(params);
    }

    public double getAverageDailyLogins() {
        Integer totalLogins = statisticMapper.selectTotalLoginCount();
        Integer totalDays = statisticMapper.selectDistinctDaysCount();

        if (totalDays == 0) {
            return 0.0;
        }

        return totalLogins / (double) totalDays;
    }

    public List<YearMonthCountDto> getMonthLoginsExcludingHolidays(String year, String month) {
        String yearMonth = year + month;
        return statisticMapper.selectMonthLoginsExcludingHolidays(yearMonth);
    }


}

