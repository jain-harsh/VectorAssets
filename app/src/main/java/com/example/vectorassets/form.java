package com.example.vectorassets;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class form extends AppCompatActivity implements View.OnClickListener {
    EditText etname,etphone,etweb,etmap;
    ImageView happy,normal,sad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        etname=findViewById(R.id.etname);
        etphone=findViewById(R.id.etphone);
        etweb=findViewById(R.id.etweb);
        etmap=findViewById(R.id.etmap);
        happy=findViewById(R.id.happy);
        normal=findViewById(R.id.normal);
        sad=findViewById(R.id.sad);

        happy.setOnClickListener(this);
        normal.setOnClickListener(this);
        sad.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        Intent intent=new Intent();
        intent.putExtra("name",etname.getText().toString());
        intent.putExtra("phone",etphone.getText().toString());
        intent.putExtra("site",etweb.getText().toString());
        intent.putExtra("add",etmap.getText().toString());

        if(view.getId()==R.id.happy){
            intent.putExtra("mood","happy");
        }
        else if(view.getId()==R.id.normal){
            intent.putExtra("mood","normal");
        }
        else if(view.getId()==R.id.sad){
            intent.putExtra("mood","sad");
        }

        setResult(RESULT_OK,intent);
        form.this.finish();
    }

}
