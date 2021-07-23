package com.example.androidstudy.chapter19;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.androidstudy.R;

public class LongTime2Activity extends Activity implements View.OnClickListener {
    int mValue;
    TextView mText;
    ProgressDialog mProgress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.long_time_activity);

        mText = findViewById(R.id.text);
        Button btn = findViewById(R.id.update);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        new accumulateTask().execute(100);
    }

    private class accumulateTask extends AsyncTask<Integer, Integer, Integer> {

        @Override
        protected Integer doInBackground(Integer... arg0) {
            while (isCancelled() == false) {
                mValue++;
                if (mValue <= 100) {
                    publishProgress(mValue);
                } else {
                    break;
                }
                try {
                    Thread.sleep(50);
                } catch (Exception e) {

                }

            }
            return mValue;
        }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            super.onProgressUpdate(progress);
            mProgress.setProgress(progress[0]);
            mText.setText(Integer.toString(progress[0]));
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            mProgress.dismiss();
        }

        @Override
        protected void onCancelled() {
            super.onCancelled();
            mProgress.dismiss();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mValue = 0;
            mProgress = new ProgressDialog(LongTime2Activity.this);
            mProgress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mProgress.setTitle("upDating");
            mProgress.setMessage("waiting");
            mProgress.setCancelable(false);
            mProgress.setProgress(0);
            mProgress.setButton("cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    cancel(true);
                }
            });
            mProgress.show();
        }
    }
}
