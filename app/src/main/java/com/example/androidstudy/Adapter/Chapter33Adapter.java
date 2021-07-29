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
import com.example.androidstudy.GoogleActivity;
import com.example.androidstudy.R;
import com.example.androidstudy.ReadLocationActivity;
import com.example.androidstudy.chapter28.Downlmage2;
import com.example.androidstudy.chapter28.DownloadManagerActivity;
import com.example.androidstudy.chapter28.JSONArrayActivity;
import com.example.androidstudy.chapter33.LoginActivity;
import com.example.androidstudy.chapter33.SimpleSharedPreferences;

import java.util.ArrayList;

public class Chapter33Adapter extends RecyclerView.Adapter<com.example.androidstudy.Adapter.MyHolder33> {
    private ArrayList<String> list;

    public Chapter33Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public com.example.androidstudy.Adapter.MyHolder33 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new com.example.androidstudy.Adapter.MyHolder33(view);
    }

    @Override
    public void onBindViewHolder(com.example.androidstudy.Adapter.MyHolder33 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), SimpleSharedPreferences.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), LoginActivity.class);
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

class MyHolder33 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder33(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}
