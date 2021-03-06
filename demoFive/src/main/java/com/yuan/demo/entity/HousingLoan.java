package com.yuan.demo.entity;


import lombok.Data;


@Data
public class HousingLoan {
    private double unitPrice;
    private double area;
    private double mortgageRatio;
    private double MortgageYears;
    private double lendingRate;





    @Override
    public String toString() {
        double x= ((unitPrice * area * mortgageRatio) * lendingRate * Math.pow(1 + lendingRate, MortgageYears  * 12)) / (Math.pow(1 + lendingRate, MortgageYears * 12) - 1) * MortgageYears * 12 -(unitPrice * area);
        String s = "HousingLoan{ 房款总额:" + unitPrice * area +
                "\r贷款总额:" + unitPrice * area * mortgageRatio +
                "\n贷款月数:" + MortgageYears * 12 +
                "\n等额本息每月还款金额" + ((unitPrice * area * mortgageRatio) * lendingRate * Math.pow(1 + lendingRate, MortgageYears * 12))/(Math.pow(1 + lendingRate, MortgageYears * 12) - 1) +
                "\n还款总额:" + ((unitPrice * area * mortgageRatio) * lendingRate * Math.pow(1 + lendingRate, MortgageYears * 12)) / (Math.pow(1 + lendingRate, MortgageYears * 12) - 1) * MortgageYears* 12 +
                "\n支付利息款:" +x
                + "}";
        return s;
    }
}
