package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.chapter35.LoginActivity;
import com.example.androidstudy.R;
import com.example.androidstudy.chapter34.CoroutineSimple;

import java.util.ArrayList;

public class Chapter35Adapter extends RecyclerView.Adapter<com.example.androidstudy.Adapter.MyHolder35> {
    private ArrayList<String> list;

    public Chapter35Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public com.example.androidstudy.Adapter.MyHolder35 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new com.example.androidstudy.Adapter.MyHolder35(view);
    }

    @Override
    public void onBindViewHolder(com.example.androidstudy.Adapter.MyHolder35 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), LoginActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), CoroutineSimple.class);
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

class MyHolder35 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder35(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}
