package com.creditcalculator.task.api.DTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MonthPayment {
    private String monthYear;
    private double paymentForMainDebt;
    private double paymentForPercents;
    private double remainsOfMainDebt;
    private double amountOfTotalPayment;
}

