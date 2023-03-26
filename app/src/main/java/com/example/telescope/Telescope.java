package com.example.telescope;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal=true, level=AccessLevel.PRIVATE)

public class Telescope {
    @Getter
    @Setter
    private static int telescopePrice;
    @Getter
    @Setter
    private static int savings;
    @Getter
    @Setter
    private static int monthlySalary;
    @Getter
    @Setter
    private static double bankInterestRate;
    //Мне кажется что тут что-то не так с формулами, но я не понимаю как сделать по другому,
    // поэтому оставлю так, я решил не использовать,
    // и даже не смотреть код примера а сделать все сам.
    public int calculateMonthlySavings() {
        return monthlySalary;
    }
    public int calculateTotalSavings(int years) {
        int totalSavings = savings;
        for (int i = 1; i <= years*12; i++) {
            totalSavings += calculateMonthlySavings();
            totalSavings += (int)(totalSavings * bankInterestRate / 12);
        }
        return totalSavings;
    }
    public int calculateYearsToSave() {
        int years = 0;
        int totalSavings = savings;
        while (totalSavings < telescopePrice) {
            years++;
            totalSavings += calculateMonthlySavings();
            totalSavings += (int)(totalSavings * bankInterestRate / 12);
        }
        return years;
    }

}
