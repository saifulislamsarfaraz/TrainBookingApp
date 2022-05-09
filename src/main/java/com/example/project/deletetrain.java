package com.example.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class deletetrain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deletebus);

        EditText trainid = findViewById(R.id.trainid);
        Button deletetrain = findViewById(R.id.deletetrain);
        Button back = findViewById(R.id.button03);
        DBHelper DB = new DBHelper(this);

        deletetrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = trainid.getText().toString();
                if (id.equals(""))
                {
                    Toast.makeText(deletetrain.this, "Please Enter Train ID", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Boolean checkId= DB.checkid(id);
                    if (checkId==true){
                        Boolean delete = DB.deleteTrain(id);
                        if (delete==true){
                            Toast.makeText(deletetrain.this, "Train deleted successfully", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(deletetrain.this, "Entry not deleted", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(deletetrain.this, "ID does not exists", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), adminpanel.class);
                startActivity(intent);
            }
        });

    }
}