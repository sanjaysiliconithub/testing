package com.vidit_sql_lite_demo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by android4 on 2/9/16.
 */
public class Add_user extends Fragment implements View.OnClickListener {
    String name, email, mobile, city, gender;
    String[] spi_city = {"Ahmedabad", "Jamnagar", "Rajkot"};
    private EditText ed_name, ed_email, ed_mobile;
    private Spinner spi_spinner;
    private Button submit, reset;
    private RadioButton male, female;
    private SQLiteDatabase db;

    private RadioGroup rg_gender;
    private DBHandler dbHandler;

    public Add_user() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_add_user, container, false);

       // createDatabase();
        dbHandler = new DBHandler(getActivity());

        ed_name = (EditText) view.findViewById(R.id.name);
        ed_email = (EditText) view.findViewById(R.id.email);
        ed_mobile = (EditText) view.findViewById(R.id.mobile);
        spi_spinner = (Spinner) view.findViewById(R.id.city);
        male = (RadioButton) view.findViewById(R.id.male);
        female = (RadioButton) view.findViewById(R.id.female);

        rg_gender = (RadioGroup) view.findViewById(R.id.gender);


        submit = (Button) view.findViewById(R.id.submit);
        reset = (Button) view.findViewById(R.id.reset);

        submit.setOnClickListener(this);
        reset.setOnClickListener(this);


        rg_gender.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.male) {
                    gender = male.getText().toString().trim();

                } else if (i == R.id.female) {
                    gender = female.getText().toString().trim();

                }
            }
        });


        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.spi, spi_city);
        spi_spinner.setAdapter(adapter);
        spi_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                city = spi_spinner.getSelectedItem().toString().trim();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        return view;
    }

    protected void createDatabase() {
        db = getActivity().openOrCreateDatabase("userDB", Context.MODE_PRIVATE, null);
        db.execSQL("CREATE TABLE IF NOT EXISTS user(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR,email VARCHAR, mobile VARCHAR, city VARCHAR, gender VARCHAR);");
    }

    protected void insertIntoDB() {
        name = ed_name.getText().toString().toString().trim();
        email = ed_email.getText().toString().trim();
        mobile = ed_mobile.getText().toString().trim();


/*
        if (TextUtils.isEmpty(name)) {

            ed_name.setError("Please Fill Your name");
        }
        else if(TextUtils.isEmpty(email)){
            ed_email.setError("Please Enter Email Id");
        }
        else if(TextUtils.isEmpty(mobile)){
            ed_mobile.setError("Please Enter The Mobile Num");
        }
        else {
            String query = "INSERT INTO user (name,email,mobile,city,gender) VALUES('" + name + "', '" + email + "','" + mobile + "','" + city + "','" + gender + "');";


            db.execSQL(query);
            Toast.makeText(getActivity(), "Saved Successfully", Toast.LENGTH_LONG).show();

            Toast.makeText(getActivity(), city, Toast.LENGTH_SHORT).show();
        }*/

        dbHandler.addUser(new User(name,email,mobile,city,gender));

    }

    @Override
    public void onClick(View view) {
        if (view == submit) {
            insertIntoDB();
        }

        if (view == reset) {
            ed_name.setText("");
            ed_email.setText("");
            ed_mobile.setText("");


            if (male.isSelected() == true) {
                Toast.makeText(getActivity(), male.getText().toString(), Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getActivity(), female.getText().toString(), Toast.LENGTH_SHORT).show();
            }


        }


    }
}
