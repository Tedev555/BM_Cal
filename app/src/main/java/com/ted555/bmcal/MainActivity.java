package com.ted555.bmcal;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Define view
    EditText weightText;
    EditText heightText;
    Button btnCalculate ;

    float weightValue;
    float heightValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Blinding
        weightText = (EditText)findViewById(R.id.weight_value);
        heightText = (EditText)findViewById(R.id.height_value);
        btnCalculate = (Button)findViewById(R.id.btnCal);

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //get value from editText

                if (weightText.getText().toString().trim().length() != 0 && heightText.getText().toString().trim().length() != 0){
                    weightValue = Float.parseFloat(weightText.getText().toString());
                    heightValue = Float.parseFloat(heightText.getText().toString());

                    final String bmiValue = String.valueOf(calBMI(weightValue,heightValue));

                        //setup dialog
                        builder.setTitle("Result");
                        builder.setMessage(bmiValue);
                        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });

                }else {

                    //setup dialog
                    builder.setTitle("Result");
                    builder.setMessage("Your input incorrect");
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
                }
                builder.show();
            }
        });
    }

    public static float calBMI(float weight, float height){

        float bmi;
        bmi = weight/(height*height);

        return bmi;
    }
}
