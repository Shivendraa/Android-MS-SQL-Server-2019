package com.nighteye.demosql;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.Connection;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {
    EditText editRoll, editName;
    private String name;
    private int roll;
    Connection con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.editName);
        editRoll = findViewById(R.id.editRoll);
        Button submit = findViewById(R.id.submit);

        con = new ConnectionHelper().connectionClass();
        if (con == null)
        {
            Toast.makeText(MainActivity.this,"Can not connect to SQL-Server Instance", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(MainActivity.this,"Successfully connected to SQL-Server Instance", Toast.LENGTH_SHORT).show();
        }
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = editName.getText().toString();
                roll = Integer.parseInt(editRoll.getText().toString());
                if(name.isEmpty() | editRoll.getText().toString().isEmpty())
                {
                    Toast.makeText(MainActivity.this,"Can not send empty values to database!", Toast.LENGTH_SHORT).show();
                }
                else {
                    executeStatements();
                    editName.setText("");
                    editRoll.setText("");
                }
            }
        });
    }
    private void executeStatements() {
        Statement stmt;
        int rs;
        try {
            stmt = con.createStatement();
            rs = stmt.executeUpdate("insert into student values (" + roll +" , '" + name + "' )");
            if(rs > 0){
                Toast.makeText(MainActivity.this,"Values inserted to database!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this,"Could't Insert Value", Toast.LENGTH_SHORT).show();
            }
        }
        catch (java.sql.SQLException e) {
            e.printStackTrace();
        }
    }
}
