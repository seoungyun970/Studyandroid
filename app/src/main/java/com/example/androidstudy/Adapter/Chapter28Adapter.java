package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.chapter19.LongTime2Activity;
import com.example.androidstudy.chapter28.AsyncDownHtml;
import com.example.androidstudy.chapter28.ConMgrActivity;
import com.example.androidstudy.chapter28.DownHtmlActivity;
import com.example.androidstudy.chapter28.DownImage;
import com.example.androidstudy.chapter28.Downlmage2;
import com.example.androidstudy.chapter28.DownloadManagerActivity;
import com.example.androidstudy.chapter28.JSONArrayActivity;

import java.util.ArrayList;

public class Chapter28Adapter extends RecyclerView.Adapter<MyHolder28> {
    private ArrayList<String> list;

    public Chapter28Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder28 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new MyHolder28(view);
    }

    @Override
    public void onBindViewHolder(MyHolder28 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), ConMgrActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), DownHtmlActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), AsyncDownHtml.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), DownImage.class);
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

class MyHolder28 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder28(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}