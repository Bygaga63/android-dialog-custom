package com.example.dialogwindow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.TextureView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<TextView> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list.add( findViewById(R.id.tv1));
        list.add(findViewById(R.id.tv2));
        list.add(findViewById(R.id.tv3));


        list.forEach(tv -> tv.setOnClickListener(this));
    }

    @Override
    public void onClick(View v) {
        MyDialog myDialog = new MyDialog();

        Bundle args = new Bundle();

        args.putString("text", (((TextView)v).getText().toString()));
        myDialog.setArguments(args);
        myDialog.show(getSupportFragmentManager(), "custom");
    }

    public void  remove(String text){
        list.forEach(textView -> {
            if (textView.getText().equals(text))
                ((RelativeLayout)textView.getParent()).removeView(textView);
        });
    }
}
