package com.creditcalculator.task.api.responses;

import com.creditcalculator.task.api.DTO.MonthPayment;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PaymentSchedule {
    private List<MonthPayment> listOfMonthPayment;
}
