package com.example.harvey.memo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener,AdapterView.OnItemLongClickListener{

    String[] aMemo={"1.编辑","2.长按清除","3.","4."};
    ListView lv;
    ArrayAdapter<String> adp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lv);
        adp=new ArrayAdapter<>(this,android.R.layout.simple_spinner_dropdown_item,aMemo);
        lv.setAdapter(adp);

        lv.setOnItemClickListener(this);
        lv.setOnItemLongClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent it=new Intent(this,Main2Activity.class);
        it.putExtra("编号",position+1);
        it.putExtra("备忘",aMemo[position]);
       // startActivity(it);
        startActivityForResult(it,position);

    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        return false;
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent it){
        aMemo[requestCode]=it.getStringExtra("备忘");
        adp.notifyDataSetChanged();

    }
}
