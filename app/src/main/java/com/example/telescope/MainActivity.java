package com.example.telescope;

import android.annotation.SuppressLint;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Telescope.setTelescopePrice(14000);
        Telescope.setSavings(1000);
        Telescope.setMonthlySalary(2500);
        Telescope.setBankInterestRate(0.05);

        Telescope telescope = new Telescope();


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView time = findViewById(R.id.time);
        time.setText("Вы накопите на телескоп через "
                +telescope.calculateYearsToSave()+" лет, в месяц вы копите по: "
                + telescope.calculateMonthlySavings()+"У вас будет в общей сложности: "
                +telescope.calculateTotalSavings(telescope.calculateYearsToSave())
                +" монет");

    }
}