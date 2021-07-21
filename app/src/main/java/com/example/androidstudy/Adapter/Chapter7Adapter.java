package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.chapter7.PermModelActivity;

import java.util.ArrayList;

public class Chapter7Adapter extends RecyclerView.Adapter<MyHolder7>{
    private ArrayList<String> list;
    private Context context;

    public Chapter7Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder7 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new MyHolder7(view);
    }

    @Override
    public void onBindViewHolder(MyHolder7 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            switch (position) {
                case 0 :
                    Intent intent = new Intent(v.getContext(), PermModelActivity.class);
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

class MyHolder7 extends RecyclerView.ViewHolder {
    TextView tv;
    public MyHolder7(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}
