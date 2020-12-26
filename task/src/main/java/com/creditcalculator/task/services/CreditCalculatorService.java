package com.creditcalculator.task.services;

import com.creditcalculator.task.api.DTO.CreditInfo;
import com.creditcalculator.task.api.DTO.MonthPayment;
import com.creditcalculator.task.api.responses.PaymentSchedule;
import org.decimal4j.util.DoubleRounder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CreditCalculatorService {

    public List<MonthPayment> calculateCredit(CreditInfo informationAboutCredit) {
        double originalSumOfDebt = informationAboutCredit.getSumOfDebt();
        double balanceOfDebt = informationAboutCredit.getSumOfDebt();
        double countOfPercentsPerYear = DoubleRounder.round((informationAboutCredit.getPercentsPerYear()/100) / 12,2);
        int countOfCreditMonths = informationAboutCredit.getCountOfMonthsOfCredit();

        double paymentPerMonth = originalSumOfDebt *
                (countOfPercentsPerYear + (countOfPercentsPerYear / ((Math.pow((1+countOfPercentsPerYear), countOfCreditMonths)) -1)));
        paymentPerMonth = DoubleRounder.round(paymentPerMonth,2);

        List<MonthPayment> listOfMonthPayment = new ArrayList<>();

        Date today = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(today);

        for (int i = informationAboutCredit.getCountOfMonthsOfCredit(); i >= 1 ; i--) {
            MonthPayment monthPayment = createMonthPayment(calendar,
                                                           balanceOfDebt,
                                                           countOfPercentsPerYear,
                                                           paymentPerMonth);
            balanceOfDebt = monthPayment.getRemainsOfMainDebt();
            listOfMonthPayment.add(monthPayment);
        }

        return listOfMonthPayment;
    }

    private MonthPayment createMonthPayment(Calendar calendar,
                                            double balanceOfDebt,
                                            double countOfPercentsPerYear,
                                            double paymentPerMonth) {
        MonthPayment monthPayment = new MonthPayment();

        int month = calendar.get(Calendar.MONTH) + 1;
        int year = calendar.get(Calendar.YEAR);

        String monthYear = month + "/" + year;

        double percentsForMonth = balanceOfDebt * countOfPercentsPerYear;
        double clearPaymentPerMonth = paymentPerMonth - percentsForMonth;

        balanceOfDebt = DoubleRounder.round(balanceOfDebt - clearPaymentPerMonth,2);
        calendar.add(Calendar.MONTH,1);

        monthPayment.setMonthYear(monthYear);
        monthPayment.setAmountOfTotalPayment(paymentPerMonth);
        monthPayment.setPaymentForPercents(DoubleRounder.round(percentsForMonth,2));
        monthPayment.setPaymentForMainDebt(DoubleRounder.round(clearPaymentPerMonth,2));
        monthPayment.setRemainsOfMainDebt(balanceOfDebt < 0 ? 0 : DoubleRounder.round(balanceOfDebt,2));

        return monthPayment;
    }
}
