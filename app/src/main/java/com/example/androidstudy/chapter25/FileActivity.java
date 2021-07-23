package com.example.androidstudy.chapter25;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

public class FileActivity extends Activity implements View.OnClickListener {
    EditText mEdit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        mEdit = findViewById(R.id.edit_text);
        Button btn1 = findViewById(R.id.save);
        Button btn2 = findViewById(R.id.load);
        Button btn3 = findViewById(R.id.load_res);
        Button btn4 = findViewById(R.id.delete);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.save:
                try {
                    FileOutputStream fos = openFileOutput("test.txt", Context.MODE_PRIVATE);
                    String str = "Android File IO Test";
                    fos.write(str.getBytes());
                    fos.close();
                    mEdit.setText("write success");
                } catch (Exception e) {

                }
                break;
            case R.id.load:
                try {
                    FileInputStream fis = openFileInput("test.txt");
                    byte[] data = new byte[fis.available()];
                    while (fis.read(data) != -1) {

                    }
                    fis.close();
                    mEdit.setText(new String(data));
                } catch (Exception e) {
                    mEdit.setText("file not found");
                }
                break;
            case R.id.load_res:
                try {
                    InputStream fres = getResources().openRawResource(R.raw.test);
                    byte[] data = new byte[fres.available()];
                    while (fres.read(data) != -1) {

                    }
                    fres.close();
                    mEdit.setText(new String(data));
                } catch (Exception e) {

                }
            case R.id.delete:
                if (deleteFile("test.txt")) {
                    mEdit.setText("delete success");
                } else {
                    mEdit.setText("delete failed");
                }
                break;
        }
    }
}
