package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.chapter11.ListAddDelActivity;
import com.example.androidstudy.chapter11.ListAddDelMultiActivity;
import com.example.androidstudy.chapter11.ListItemSelectActivity;
import com.example.androidstudy.chapter11.SpinnerActivity;
import com.example.androidstudy.chapter13.DatePicker;
import com.example.androidstudy.chapter13.DateTimeActivity;
import com.example.androidstudy.chapter13.WebViewActivity;
import com.example.androidstudy.chapter16.DialogActivity;
import com.example.androidstudy.chapter16.OrderDialogActivity;

import java.util.ArrayList;

public class Chapter16Adapter extends RecyclerView.Adapter<MyHolder16> {
    private ArrayList<String> list;

    public Chapter16Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder16 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new MyHolder16(view);
    }

    @Override
    public void onBindViewHolder(MyHolder16 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), DialogActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), OrderDialogActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), WebViewActivity.class);
                    v.getContext().startActivity(intent);
                    break;

            }

        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class MyHolder16 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder16(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}