package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.R;
import com.example.androidstudy.chapter19.ANR2Activity;
import com.example.androidstudy.chapter19.ANRActivity;
import com.example.androidstudy.chapter19.LongTime2Activity;
import com.example.androidstudy.chapter19.LongTimeActivity;
import com.example.androidstudy.chapter19.LooperTestActivity;
import com.example.androidstudy.chapter19.UpLoadActivity;
import com.example.androidstudy.chapter25.FileActivity;
import com.example.androidstudy.chapter25.FileExplorer;
import com.example.androidstudy.chapter25.PrefTestActivity;
import com.example.androidstudy.chapter26.EnglishWordActivity;
import com.example.androidstudy.chapter26.ProductListActivity;

import java.util.ArrayList;

public class Chapter26Adapter extends RecyclerView.Adapter<MyHolder26> {
    private ArrayList<String> list;

    public Chapter26Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder26 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item, parent, false);
        return new MyHolder26(view);
    }

    @Override
    public void onBindViewHolder(MyHolder26 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent;
            switch (position) {
                case 0:
                    intent = new Intent(v.getContext(), EnglishWordActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), ProductListActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), PrefTestActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), LooperTestActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), UpLoadActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), ANRActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), ANR2Activity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(v.getContext(), LongTimeActivity.class);
                    v.getContext().startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(v.getContext(), LongTime2Activity.class);
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

class MyHolder26 extends RecyclerView.ViewHolder {
    TextView tv;

    public MyHolder26(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}