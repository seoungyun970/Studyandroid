package com.example.androidstudy.chapter25;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.io.File;
import java.util.ArrayList;

public class FileExplorer extends Activity implements AdapterView.OnItemClickListener, View.OnClickListener {
    String mCurrent;
    String mRoot;
    TextView mCurrentTxt;
    ListView mFileList;
    ArrayAdapter<String> mAdapter;
    ArrayList<String> arFiles;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.file_explorer);

        mCurrentTxt = findViewById(R.id.current);
        mFileList = findViewById(R.id.filelist);

        arFiles = new ArrayList<String>();
        mRoot = Environment.getExternalStorageDirectory().getAbsolutePath();
        mCurrent = mRoot;

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arFiles);
        mFileList.setAdapter(mAdapter);
        mFileList.setOnItemClickListener(this);

        Button btn1 = findViewById(R.id.btnroot);
        Button btn2 = findViewById(R.id.btnup);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnroot:
                if (mCurrent.compareTo(mRoot) != 0) {
                    mCurrent = mRoot;
                    refreshFiles();
                }
                break;
            case R.id.btnup:
                if (mCurrent.compareTo(mRoot) != 0) {
                    int end = mCurrent.lastIndexOf("/");
                    String uppath = mCurrent.substring(0, end);
                    mCurrent = uppath;
                    refreshFiles();
                }
                break;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String name = arFiles.get(position);
        if (name.startsWith("[") && name.endsWith("]")) {
            name = name.substring(1, name.length() - 1);
        }
        String path = mCurrent + "/" + name;
        File f = new File(path);

        if (f.isDirectory()) {
            mCurrent = path;
            refreshFiles();
        } else {
            Toast.makeText(FileExplorer.this, arFiles.get(position), Toast.LENGTH_SHORT).show();
        }
    }

    public void refreshFiles() {
        mCurrentTxt.setText(mCurrent);
        arFiles.clear();

        File current = new File(mCurrent);
        String[] files = current.list();
        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                String path = mCurrent + "/" + files[i];
                String name = "";
                File f = new File(path);
                if (f.isDirectory()) {
                    name = "[" + files[i] + "]";
                } else {
                    name = files[i];
                }
                arFiles.add(name);
            }
        }
        mAdapter.notifyDataSetChanged();
    }
}
