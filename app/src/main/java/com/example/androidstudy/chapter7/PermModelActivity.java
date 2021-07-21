package com.example.androidstudy.chapter7;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class PermModelActivity extends Activity implements View.OnClickListener {
    TextView mResult;
    Button mBtnRead,mBtnReset;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perm_model);
        mResult = findViewById(R.id.tv_result);
        mBtnRead = findViewById(R.id.btn_read);
        mResult = findViewById(R.id.btn_reset);

        mBtnRead.setOnClickListener(this);
        mResult.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_read:
                outContact();
                break;
            case R.id.btn_reset:
                mResult.setText("주소록");
                break;
        }
    }
    private void outContact() {
        ContentResolver cr = getContentResolver();
        Cursor cursor = cr.query(
                ContactsContract.Contacts.CONTENT_URI,null,null,null,null,null
        );
        int nameIdx = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);

        if (cursor.moveToNext()) {
            mResult.setText(cursor.getString(nameIdx));
        } else {
            mResult.setText("주소록이 비어 있습니다.");
        }
        cursor.close();
    }
}
