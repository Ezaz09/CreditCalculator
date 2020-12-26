package com.creditcalculator.task.api.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreditInfo {
    private int sumOfDebt;
    private int countOfMonthsOfCredit;
    private double percentsPerYear;
}
