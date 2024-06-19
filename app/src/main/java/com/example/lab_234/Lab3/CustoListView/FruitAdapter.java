package com.example.lab_234.Lab3.CustoListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab_234.R;

import java.util.List;

public class FruitAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Fruits> fruits;

    public FruitAdapter(Context context, int layout, List<Fruits> fruits) {
        this.context = context;
        this.layout = layout;
        this.fruits = fruits;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView txtName, txtDescription;
    }

    @Override
    public int getCount() {
        return fruits.size();
    }

    @Override
    public Object getItem(int position) {
        return fruits.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layout, null);

            holder = new ViewHolder();
            holder.txtName = convertView.findViewById(R.id.txtName);
            holder.txtDescription = convertView.findViewById(R.id.txtDescription);
            holder.imageView = convertView.findViewById(R.id.image);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Fruits fruit = fruits.get(position);
        holder.txtName.setText(fruit.getName());
        holder.txtDescription.setText(fruit.getDescription());
        holder.imageView.setImageResource(fruit.getImage());

        return convertView;
    }
}
