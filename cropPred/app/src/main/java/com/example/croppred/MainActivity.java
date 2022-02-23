package com.example.croppred;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    EditText ph;
    EditText temperature;
    EditText humidity;
    Button prediction;
    TextView message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ph = findViewById(R.id.ph);
        temperature = findViewById(R.id.temp);
        humidity = findViewById(R.id.humidity);
        prediction = findViewById(R.id.predict);
        message = findViewById(R.id.message);


    }

    public void predictClicked(View view) {

        if (temperature.getText().toString().length() == 0 || ph.getText().toString().length() == 0 ||
                humidity.getText().toString().length() == 0) {
            Toast.makeText(getApplicationContext(), "field cannot be left empty", Toast.LENGTH_SHORT).show();
        } else {

            double t = Double.parseDouble(temperature.getText().toString());
            double p = parseDouble(ph.getText().toString());
            double h = parseDouble(humidity.getText().toString());


            if ((t >= 20.0 & t <= 33.9) & (h >= 50.0 & h <= 89.9) & (p >= 6.0 & p < 7.0)) {
                message.setText(getString(R.string.crop));
            } else if ((t >= 18.0 & t <= 33.9) & (h >= 50.0 & h <= 89.9) & (p >= 5.0 & p <= 6.9)) {
                message.setText("suitable for CROPS like...MILLET,GRAPE,BANANA,POMEGRANATE,RUBBER,SUGAR-CANE,TOBACCO");
            } else if ((t >= 40.0 & t <= 45.9) & (h >= 10.0 & h <= 16.9) & (p >= 5.0 & p <= 7.9)) {
                message.setText("suitable for CROPS like...MAIZE,MILLET,GRAPE");
            } else if ((t >= 16.0 & t <= 22.9) & (h >= 18.0 & h <= 45.9) & (p >= 5.9 & p <= 6.9)) {
                message.setText("suitable for CROPS like...PEAS,KIDNEY BEANS");
            } else if ((t >= 21.0 & t <= 42.9) & (h >= 40.0 & h <= 99.9) & (p >= 5.0 & p <= 7.9)) {
                message.setText("suitable for CROPS like...RICE,SUGAR-CANE,PAPAYA,COCONUT," +
                        "BANANA,GRAPE,APPLE,ORANGE,COTTON");

            } else if ((t >= 25.0 & t <= 42.9) & (h >= 40.0 & h <= 99.9) & (p>= 5.0 & p <= 7.9 )) {
                message.setText("suitable for CROPS like...PAPAYA AND WATERMELON GROUNDNUT");
            } else if ((t >= 21.0 & t <= 42.9) & (h >= 40 & h <= 99.9) & (p >= 4.0 & p <= 6.9)) {
                message.setText("suitable for CROPS like...MANGOE,MAIZE,BANANA");

            } else {
                message.setText("soil not fertile");
                Toast.makeText(getApplicationContext(),"fertilizer needed",Toast.LENGTH_SHORT).show();

            }

        }
    }
}
