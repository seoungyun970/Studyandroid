package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.chapter16.OrderDialogActivity;
import com.example.androidstudy.chapter17.CommActivity;
import com.example.androidstudy.chapter17.subActivity;
import com.example.androidstudy.chapter19.HandlerActivity;
import com.example.androidstudy.chapter19.LooperTestActivity;
import com.example.androidstudy.chapter19.ThreadTest2Activity;
import com.example.androidstudy.chapter19.ThreadTestActivity;

import java.util.ArrayList;

public class Chapter19Adapter extends RecyclerView.Adapter<MyHolder19> {
    private ArrayList<String> list;

    public Chapter19Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder19 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new MyHolder19(view);
    }

    @Override
    public void onBindViewHolder(MyHolder19 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), ThreadTestActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), ThreadTest2Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), HandlerActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), LooperTestActivity.class);
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

class MyHolder19 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder19(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}