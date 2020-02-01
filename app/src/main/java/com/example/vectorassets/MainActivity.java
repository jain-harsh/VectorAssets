package com.example.vectorassets;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button contact;
    ImageView call,web,map,face;
    final int form=1;
    String name="",site="",num="",emoji="",add="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      contact=findViewById(R.id.contact);
      call=findViewById(R.id.call);
      web=findViewById(R.id.web);
      map=findViewById(R.id.map);
      face=findViewById(R.id.face);

      call.setVisibility(View.GONE);
        web.setVisibility(View.GONE);
        map.setVisibility(View.GONE);
        face.setVisibility(View.GONE);

      contact.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
            Intent intent =new Intent(MainActivity.this,com.example.vectorassets.form.class);
            startActivityForResult(intent,form);
          }
      });

      call.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

                Intent intent= new Intent(Intent.ACTION_DIAL, Uri.parse("tel"+num));
                startActivity(intent);
          }
      });
      web.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("https://"+site));
              startActivity(intent);
          }
      });
      map.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {
              Intent intent= new Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q="+add));
              startActivity(intent);
          }
      });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==form){
            if(resultCode==RESULT_OK){
                call.setVisibility(View.VISIBLE);
                web.setVisibility(View.VISIBLE);
                map.setVisibility(View.VISIBLE);
                face.setVisibility(View.VISIBLE);

                name= data.getStringExtra("name");
                site= data.getStringExtra("site");
                num= data.getStringExtra("phone");
                emoji= data.getStringExtra("mood");
                add= data.getStringExtra("add");

                if(emoji.equals("happy")){
                    face.setImageResource(R.drawable.happy);
                }
                else if(emoji.equals("normal")){
                    face.setImageResource(R.drawable.normal);
                }else{
                    face.setImageResource(R.drawable.sad);
                }
            }
            else{
                Toast.makeText(this, "NO EMOJI SELECTED", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
