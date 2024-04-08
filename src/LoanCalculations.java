public class LoanCalculations {
    public static double calculateLoanInterest(double baseInterestRate, int creditScore, double income) {
        // Adjust interest rate based on credit score
        double interestRateAdjustment = 0.0;

        if (creditScore >= 750) {
            interestRateAdjustment -= 0.9;
        }else if (creditScore >= 700){
            interestRateAdjustment -= 0.5;
        }else if (creditScore >= 650){
            interestRateAdjustment -= 0.2;
        }
        else if (creditScore >= 600) {
            interestRateAdjustment += 0.0;
        } else if (creditScore >= 550){
            interestRateAdjustment += 0.5;
        }else {
            interestRateAdjustment += 0.8;
        }


        // Adjusting interest rate based on income
        if (income >= 100000) {
            interestRateAdjustment -= 0.7;
        } else if (income >= 80000) {
            interestRateAdjustment -= 0.4;
        } else if (income >= 50000) {
            interestRateAdjustment -= 0.1;
        }
        else {
            interestRateAdjustment += 0.2;
        }

        // Calculate final interest rate
        double finalInterestRate = baseInterestRate + interestRateAdjustment;

        return finalInterestRate;
    }
}
