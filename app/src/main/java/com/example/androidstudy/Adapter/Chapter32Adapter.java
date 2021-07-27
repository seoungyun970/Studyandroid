package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.GeoCodingActivity;
import com.example.androidstudy.GetProvider;
import com.example.androidstudy.R;
import com.example.androidstudy.ReadLocationActivity;
import com.example.androidstudy.chapter28.DownImage;
import com.example.androidstudy.chapter28.Downlmage2;
import com.example.androidstudy.chapter28.DownloadManagerActivity;
import com.example.androidstudy.chapter28.JSONArrayActivity;
import com.example.androidstudy.chapter30.CalcClientActivity;
import com.example.androidstudy.chapter30.NewsController2;
import com.example.androidstudy.GoogleActivity;

import java.util.ArrayList;

public class Chapter32Adapter extends RecyclerView.Adapter<com.example.androidstudy.Adapter.MyHolder32> {
    private ArrayList<String> list;

    public Chapter32Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public com.example.androidstudy.Adapter.MyHolder32 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new com.example.androidstudy.Adapter.MyHolder32(view);
    }

    @Override
    public void onBindViewHolder(com.example.androidstudy.Adapter.MyHolder32 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), GoogleActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), GetProvider.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), ReadLocationActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), GeoCodingActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), Downlmage2.class);
                    v.getContext().startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), DownloadManagerActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), JSONArrayActivity.class);
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

class MyHolder32 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder32(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}
