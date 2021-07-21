package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.chapter6.LayoutParameter;
import com.example.androidstudy.chapter6.LayoutParameter2;
import com.example.androidstudy.chapter6.LayoutParameter3;
import com.example.androidstudy.R;

import java.util.ArrayList;

public class Chapter6Adapter extends RecyclerView.Adapter<MyHolder6>{
    private ArrayList<String> list;
    private Context context;

    public Chapter6Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder6 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new MyHolder6(view);
    }

    @Override
    public void onBindViewHolder(MyHolder6 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent = new Intent();
            switch (position) {
                case 0 :
                    intent = new Intent(v.getContext(), LayoutParameter.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), LayoutParameter2.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), LayoutParameter3.class);
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
class MyHolder6 extends RecyclerView.ViewHolder {
    TextView tv;
    public MyHolder6(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}