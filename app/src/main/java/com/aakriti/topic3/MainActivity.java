package com.aakriti.topic3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.PriorityQueue;

public class MainActivity extends AppCompatActivity {
    Button btnSave;
    EditText etName;
    TextView tvResult;
    private Spinner spinCountry;
   private AutoCompleteTextView enterBatch;
   private String[] language= {"22A", "22B", "22C", "22D"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName= findViewById(R.id.etName);
        spinCountry=findViewById(R.id.spinCountry);
        enterBatch= findViewById(R.id.enterBatch);
        btnSave=findViewById(R.id.btnSave);
        tvResult=findViewById(R.id.tvResult);

        String countries[] = {"Nepal", "India", "China"};
        ArrayAdapter adapter= new ArrayAdapter<> (
                this,
                android.R.layout.simple_list_item_1, countries
        );
        spinCountry.setAdapter(adapter);


            ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<>(
                    this,
                    android.R.layout.select_dialog_item, language
            );
            enterBatch.setAdapter(stringArrayAdapter);
            enterBatch.setThreshold(1);


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  if (TextUtils.isEmpty(etFirst.getText())) {
                    etFirst.setError("please enter first no");
                    return;
                }else if (TextUtils.isEmpty(etSecond.getText())){
                    etSecond.setError("please enter second no");
                    return;
                }
*/
                String name,country,batch;
                name= (etName.getText().toString());
                country=spinCountry.getSelectedItem().toString();
                batch= enterBatch.getText().toString();


                String str= "Name" + name + "Country" + country + "Batch " + batch  + "\n";
                tvResult.append(str);
            }
        });

    }
}
