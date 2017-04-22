package com.example.spinner2;

import java.util.ArrayList;
import java.util.List;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity{
    private static final String[] countriesStr = { "广州", "从化", "武汉", "汕头" };
    private TextView myTextView;
    private EditText myEditText;
    private Button myButton_add;
    private Button myButton_remove;
    private Spinner mySpinner;
    private ArrayAdapter adapter;
    private List allCountries;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);allCountries = new ArrayList();
        for (int i = 0; i < countriesStr.length; i++)
        {
            allCountries.add(countriesStr[i]);
        }
        adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,allCountries);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        myTextView = (TextView) findViewById(R.id.myTextView);
        myEditText = (EditText) findViewById(R.id.myEditText);
        myButton_add = (Button) findViewById(R.id.myButton_add);
        myButton_remove = (Button) findViewById(R.id.myButton_remove);
        mySpinner = (Spinner) findViewById(R.id.mySpinner);


        mySpinner.setAdapter(adapter);
        myButton_add.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View arg0)
            {
                String newCountry = myEditText.getText().toString();

                for (int i = 0; i < adapter.getCount(); i++)
                {
                    if (newCountry.equals(adapter.getItem(i)))
                    {
                        return;
                    }
                }
                if (!newCountry.equals(""))
                {
					adapter.add(newCountry);

                    int position = adapter.getPosition(newCountry);
                    mySpinner.setSelection(position);
                    myEditText.setText("");
                }
            }
        });

        myButton_remove.setOnClickListener(new Button.OnClickListener()
        {
            public void onClick(View arg0)
            {
                if (mySpinner.getSelectedItem() != null)
                {
                    adapter.remove(mySpinner.getSelectedItem().toString());
                    myEditText.setText("");
                    if (adapter.getCount() == 0)
                    {
                        myTextView.setText("");
                    }
                }
            }
        });
        mySpinner.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {
            public void onItemSelected(AdapterView arg0, View arg1,int arg2, long arg3)
            {
                myTextView.setText(arg0.getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView arg0)
            {
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.demo, menu);
        return true;
    }

}
