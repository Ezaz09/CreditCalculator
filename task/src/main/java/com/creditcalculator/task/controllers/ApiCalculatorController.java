package com.creditcalculator.task.controllers;

import com.creditcalculator.task.api.DTO.CreditInfo;
import com.creditcalculator.task.api.DTO.MonthPayment;
import com.creditcalculator.task.api.responses.PaymentSchedule;
import com.creditcalculator.task.services.CreditCalculatorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/calculate")
@CrossOrigin(origins = "*")
public class ApiCalculatorController {
    private CreditCalculatorService creditCalculatorService;

    public ApiCalculatorController(CreditCalculatorService creditCalculatorService) {
        this.creditCalculatorService = creditCalculatorService;
    }

    @GetMapping(path = "")
    public ResponseEntity<PaymentSchedule> calculateCredit(@RequestParam int sumOfCredit,
                                                           @RequestParam int countOfMonthsOfCredit,
                                                           @RequestParam double percentsPerYear) {
        CreditInfo creditInfo = new CreditInfo();
        creditInfo.setSumOfDebt(sumOfCredit);
        creditInfo.setCountOfMonthsOfCredit(countOfMonthsOfCredit);
        creditInfo.setPercentsPerYear(percentsPerYear);

        List<MonthPayment> listOfMonthPayments = creditCalculatorService.calculateCredit(creditInfo);

        PaymentSchedule paymentSchedule = new PaymentSchedule();
        paymentSchedule.setListOfMonthPayment(listOfMonthPayments);

        return new ResponseEntity<>(paymentSchedule, HttpStatus.OK);
    }
}
