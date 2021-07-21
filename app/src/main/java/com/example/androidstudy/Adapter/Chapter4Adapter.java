package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.chapter4.ButtonEdit;
import com.example.androidstudy.R;
import com.example.androidstudy.chapter4.TestViewTest;

import java.util.ArrayList;

public class Chapter4Adapter extends RecyclerView.Adapter<MyHolder>{
    private ArrayList<String> list;
    private Context context;

    public Chapter4Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent = new Intent();
            switch (position) {
                case 0 :
                    intent = new Intent(v.getContext(), ButtonEdit.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1 :
                    intent = new Intent(v.getContext(), TestViewTest.class);
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

class MyHolder extends RecyclerView.ViewHolder {
    TextView tv;
    public MyHolder(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}