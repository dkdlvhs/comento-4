package com.demo.comentoStatistic.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DepartmentMonthCountDto {
    private String yearMonth;
    private String department;
    private Integer totCnt;
}
