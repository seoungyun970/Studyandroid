package com.example.androidstudy.chapter11;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

import java.util.ArrayList;

public class ListAddDelActivity extends Activity implements View.OnClickListener {
    ArrayList<String> mItems;
    ArrayAdapter<String> mAdapter;
    ListView mList;
    Button mBtnAdd,mBtnDelete;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_add_del);

        mItems = new ArrayList<>();
        mItems.add("First");
        mItems.add("Second");
        mItems.add("Third");

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice,mItems);
        mList = findViewById(R.id.list);
        mList.setAdapter(mAdapter);
        mList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        mBtnAdd = findViewById(R.id.add);
        mBtnDelete = findViewById(R.id.delete);
        mBtnAdd.setOnClickListener(this);
        mBtnDelete.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        EditText editText = findViewById(R.id.new_item);
        switch (v.getId()) {
            case R.id.add:
                String text = editText.getText().toString();
                if (text.length() != 0) {
                    mItems.add(text);
                    editText.setText("");
                    mAdapter.notifyDataSetChanged();
                }
                break;
            case R.id.delete:
                int pos;
                pos = mList.getCheckedItemPosition();
                if (pos != ListView.INVALID_POSITION) {
                    mItems.remove(pos);
                    mList.clearChoices();
                    mAdapter.notifyDataSetChanged();
                }
                break;
        }
    }
}
