package com.example.androidstudy.chapter16;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class DialogActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_test);
        Button btn = findViewById(R.id.call);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        AlertDialog.Builder bld = new AlertDialog.Builder(this);
        bld.setTitle("----");
        bld.setMessage("new message ");
        bld.setPositiveButton("open", null);
        bld.setNegativeButton("close", null);
        bld.show();
//        Dialog dlg = new Dialog(this);
//        TextView tv = new TextView(this);
//        tv.setText("대화 상자를 열었습니다.");
//        dlg.setContentView(tv);
//        dlg.setTitle("알립니다.");
//        dlg.show();
    }
}
