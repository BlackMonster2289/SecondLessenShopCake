package com.example.secondlessenshopcake;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

        // задание полей
        private float spongeCakes = 10; // бисквитные коржи
        private int spongeCakesDiscount = 26; // скидка на бисквитные коржи
        private float cream = 14; // сливки
        private int creamDiscount = 5; // скидка на сливки
        private float fruits = 3; // фрукты
        private int fruitsDiscount = 12; // скидка на фрукты
        private float nuts = 5; // орехи
        private int nutsDiscount = 55; // скидка на орехи
        private float berries = 7; // ягоды
        private float account = 45; // баланс на счету

        // создание дополнительных полей для вывода на экран полученных значений
        private TextView possibilityOut; // поле возможности покупки
        private TextView balanceOut; // поле возможности остатка от покупки

        // вывод на экран полученных значений
        @Override
        protected void onCreate(Bundle savedInstanceState) { // создание жизненного цикла активности
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main); // присваивание жизненному циклу активити представления activity_main


            // присваивание переменным активити элементов представления activity_main
            possibilityOut = findViewById(R.id.possibilityOut); // вывод информации о возможности покупки
            balanceOut = findViewById(R.id.balanceOut); // вывод информации о возможном остатке от покупки

            // заполнение экрана
            if (possibility()) { // если имеется возможность купить деловой гардероб
                possibilityOut.setText("Имеется достаточно средств для покупки делового гардероба");
                balanceOut.setText("Остаток от покупки " + balance() + " монет");
            } else { // иначе
                possibilityOut.setText("Недостаточно средств для покупки делового гардерода");
                balanceOut.setText(" - ");
            }
        }

        // метод подсчёта стоимости делового гардероба
        private float calculation() {
            // создание и инициализация переменной подсчёта стоимости
            float count = (spongeCakes * (100 - spongeCakesDiscount) + cream * (100 - creamDiscount)
                    + fruits * (100 - fruitsDiscount) + nuts * (100 - nutsDiscount)) / 100 + berries;
            return count; // возврат подсчитанного значения
        }

        // метод определения возможностей бюджета покупки делового гардероба
        private boolean possibility() {
            if (calculation() <= account) { // если стоимость гардероба меньше имеющихся средств
                return true; // то возврат истинного значения
            } else { // иначе
                return false; // возврат ложного значения
            }
        }

        // метод определения возможной сдачи
        private float balance() {
            if (possibility()) { // если имеется возможность купить деловой гардероб
                return account - calculation(); // то возвращается остаток от покупки
            } else { // иначе
                return -1; // возвращается маркер недостатка денежных средств
            }
        }
    }
