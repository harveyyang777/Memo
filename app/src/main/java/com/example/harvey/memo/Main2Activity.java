package com.example.harvey.memo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    TextView txv;
    EditText edt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent it=getIntent();
        int no=it.getIntExtra("编号",0);
        String s=it.getStringExtra("备忘");

        txv=(TextView)findViewById(R.id.textView);
        txv.setText(no+".");
        edt=(EditText)findViewById(R.id.editText2);
        edt.setText(s.substring(2));

    }
    public void onSave(View v){
        Intent it2=new Intent();
        it2.putExtra("备忘",txv.getText()+" "+edt.getText());
        setResult(RESULT_OK,it2);
        finish();
    }
}
