package com.demo.comentoStatistic.dao;

import com.demo.comentoStatistic.dto.YearCountDto;
import com.demo.comentoStatistic.dto.YearMonthCountDto;
import com.demo.comentoStatistic.dto.YearMonthDayCountDto;
import com.demo.comentoStatistic.dto.DepartmentMonthCountDto;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Mapper
public interface StatisticMapper {

    YearCountDto selectYearLogin(String year);
    YearMonthCountDto selectYearMonthLogin(String yearMonth);
    YearMonthDayCountDto selectYearMonthDayLogin(String yearMonthDay);
    int selectTotalLoginCount();
    int selectDistinctDaysCount();
    List<DepartmentMonthCountDto> selectDepartmentMonthlyLogin(Map<String, String> params);
    List<YearMonthCountDto> selectMonthLoginsExcludingHolidays(String yearMonth);
}

