package com.changpeng.coustomview;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.changpeng.coustomview.chapt_02.ViewAnimationActivity;
import com.changpeng.coustomview.chapt_03.Chapt3Activity;
import com.changpeng.coustomview.chapt_03.PathAnimationActivity;
import com.changpeng.coustomview.chapt_04.Chapt04Activity;
import com.changpeng.coustomview.chapt_05.Chapt5Activity;
import com.changpeng.coustomview.chapt_06.Chapt6Activity;
import com.changpeng.coustomview.chapt_12.Chapt12Activity;
import com.changpeng.coustomview.chapter_02_demo.ViewAnimationDemoActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startActivity(new Intent(MainActivity.this, Chapt12Activity.class));
    }
}
