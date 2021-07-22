package com.example.androidstudy.chapter16;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;

public class OrderDialogActivity extends Activity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_test);
        Button btn = findViewById(R.id.call);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final LinearLayout linearLayout = (LinearLayout) View.inflate(this, R.layout.order, null);

        new AlertDialog.Builder(this)
                .setTitle("check your order")
                .setView(linearLayout)
                .setPositiveButton("확인", (dialog, which) -> {
                            EditText product = linearLayout.findViewById(R.id.product);
                            EditText number = linearLayout.findViewById(R.id.number);
                            CheckBox pay = linearLayout.findViewById(R.id.pay);

                            TextView tv = findViewById(R.id.text);
                            tv.setText("주문 정보 " + product.getText() + "상품 " + number.getText() + "개" + (pay.isChecked() ? "착불 결제" : ""));


                        }
                )
                .setNegativeButton("취소 ", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        TextView textView = findViewById(R.id.text);
                        textView.setText("주문을 취소했습니다.");
                    }
                })
                .show();
    }
}
