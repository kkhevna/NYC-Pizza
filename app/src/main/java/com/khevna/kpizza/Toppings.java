package com.khevna.kpizza;

public class Toppings {
        String toppings;
        boolean isChecked;

        public Toppings(String toppings) {
            this.toppings = toppings;
        }

        public Toppings(String toppings, boolean isChecked) {
            this.toppings = toppings;
            this.isChecked = isChecked;
        }

        public String getToppings() {
            return toppings;
        }

        public void setToppings(String toppings) {
            this.toppings = toppings;
        }

        public boolean isChecked() {
            return isChecked;
        }

        public void setChecked(boolean checked) {
            isChecked = checked;
        }
}
