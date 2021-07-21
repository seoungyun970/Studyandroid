package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Chapter4Activity;
import com.example.androidstudy.Chapter5Activity;
import com.example.androidstudy.Chapter6Activity;
import com.example.androidstudy.Chapter7Activity;
import com.example.androidstudy.R;

import java.util.ArrayList;

public class MainActivityAdapter extends RecyclerView.Adapter<Holder> {
    private ArrayList<String> list;
    public MainActivityAdapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent = new Intent();
            switch (position) {
                case 0 :
                    intent = new Intent(v.getContext(), Chapter4Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1 :
                    intent = new Intent(v.getContext(), Chapter5Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), Chapter6Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3 :
                    intent = new Intent(v.getContext(), Chapter7Activity.class);
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

class Holder extends RecyclerView.ViewHolder {
    TextView tv;
    public Holder(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}