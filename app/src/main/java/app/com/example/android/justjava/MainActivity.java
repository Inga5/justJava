package app.com.example.android.justjava;

/**
 * Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 *
 * package com.example.android.justjava;
 */

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

import app.com.example.android.justjava.R;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        CheckBox checkWhippedCream =  (CheckBox) findViewById(R.id.checkbox_cream);
        boolean hasWhippedCream = checkWhippedCream.isChecked();
     //   Log.v("MainActivity", "has Whipped Cream: " + hasWhippedCream);
        CheckBox checkChocolate =  (CheckBox) findViewById(R.id.checkbox_chocolate);
        boolean hasChocolate = checkChocolate.isChecked();

        int price = calculatePrice();
        String specialOfTheDay = createOrderSummary(price, hasWhippedCream, hasChocolate);
        displayMessage(specialOfTheDay);
    }

    /**
     * This method calculates the price and delivers the text for the Order.
     *
     * @return is orderSummary ( message text )
     */
    public String createOrderSummary(int price, boolean AddWhippedCream, boolean AddChocolate ) {
        String orderSummary = "Name: Ingridh";
        orderSummary += "\nAdd whipped cream? " + AddWhippedCream;
        orderSummary += "\nAdd chocolate? " + AddChocolate;
        orderSummary += "\nQuantity: " + quantity;
        orderSummary += "\nTotal: €" + price;
        orderSummary += "\nThank You!";
        return orderSummary;
    }

    /**
     * This method is called when the + button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the - button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        displayQuantity(quantity);
    }

    /**
     * Calculates the price of the order.
     *
     * is the number of cups of coffee ordered
     *
     * @return is price
     */
    private int calculatePrice() {
        int price = quantity * 5;
        return price;
    }

    /**
     * This method displays the given quantity value on the screen.
     * @param numberOfCoffees
     */
    private void displayQuantity(int numberOfCoffees) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + numberOfCoffees);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        orderSummaryTextView.setText(message);
    }

}