package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Chapter11Activity;
import com.example.androidstudy.Chapter12Activity;
import com.example.androidstudy.Chapter13Activity;
import com.example.androidstudy.Chapter16Activity;
import com.example.androidstudy.Chapter17Activity;
import com.example.androidstudy.Chapter19Activity;
import com.example.androidstudy.Chapter20Activity;
import com.example.androidstudy.Chapter21Activity;
import com.example.androidstudy.Chapter25Activity;
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
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), Chapter4Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), Chapter5Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), Chapter6Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), Chapter7Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), Chapter11Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), Chapter12Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), Chapter13Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(v.getContext(), Chapter16Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(v.getContext(), Chapter17Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 9:
                    intent = new Intent(v.getContext(), Chapter19Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 10:
                    intent = new Intent(v.getContext(), Chapter20Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 11:
                    intent = new Intent(v.getContext(), Chapter21Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 12:
                    intent = new Intent(v.getContext(), Chapter25Activity.class);
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