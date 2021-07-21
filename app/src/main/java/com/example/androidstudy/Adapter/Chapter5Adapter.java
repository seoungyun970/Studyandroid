package com.example.androidstudy.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.androidstudy.Chapter5.CodeLayout;
import com.example.androidstudy.Chapter5.IfMissing;
import com.example.androidstudy.Chapter5.Frame;
import com.example.androidstudy.Chapter5.Multipage;
import com.example.androidstudy.Chapter5.Inflation;
import com.example.androidstudy.Chapter5.Inflation2;
import com.example.androidstudy.Chapter5.Inflation3;
import com.example.androidstudy.Chapter5.Inflation4;
import com.example.androidstudy.Chapter5.Inflation5;
import com.example.androidstudy.R;

import java.util.ArrayList;

public class Chapter5Adapter extends RecyclerView.Adapter<MyHolder5>{
    private ArrayList<String> list;
    private Context context;

    public Chapter5Adapter(ArrayList<String> list) {
        this.list = list;
    }

    @Override
    public MyHolder5 onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.main_item,parent,false);
        return new MyHolder5(view);
    }

    @Override
    public void onBindViewHolder(MyHolder5 holder, int position) {
        holder.tv.setText(list.get(position));
        holder.tv.setOnClickListener(v -> {
            Intent intent = new Intent();
            switch (position) {
                case 0 :
                    intent = new Intent(v.getContext(), IfMissing.class);
                    v.getContext().startActivity(intent);
                    break;
                case 1:
                    intent = new Intent(v.getContext(), Frame.class);
                    v.getContext().startActivity(intent);
                    break;
                case 2:
                    intent = new Intent(v.getContext(), Multipage.class);
                    v.getContext().startActivity(intent);
                    break;
                case 3:
                    intent = new Intent(v.getContext(), CodeLayout.class);
                    v.getContext().startActivity(intent);
                    break;
                case 4:
                    intent = new Intent(v.getContext(), Inflation.class);
                    v.getContext().startActivity(intent);
                    break;
                case 5:
                    intent = new Intent(v.getContext(), Inflation2.class);
                    v.getContext().startActivity(intent);
                    break;
                case 6:
                    intent = new Intent(v.getContext(), Inflation3.class);
                    v.getContext().startActivity(intent);
                    break;
                case 7:
                    intent = new Intent(v.getContext(), Inflation4.class);
                    v.getContext().startActivity(intent);
                    break;
                case 8:
                    intent = new Intent(v.getContext(), Inflation5.class);
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
class MyHolder5 extends RecyclerView.ViewHolder {
    TextView tv;
    public MyHolder5(View itemView) {
        super(itemView);
        tv = itemView.findViewById(R.id.text);
    }
}