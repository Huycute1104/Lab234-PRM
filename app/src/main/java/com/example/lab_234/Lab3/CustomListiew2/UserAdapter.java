package com.example.lab_234.Lab3.CustomListiew2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab_234.R;

import java.util.List;

public class UserAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private List<Users> users;

    public UserAdapter(Context context, int layout, List<Users> users) {
        this.context = context;
        this.layout = layout;
        this.users = users;
    }

    private static class ViewHolder {
        ImageView avatar, flag;
        TextView txtName, txtDescription;
    }


    @Override
    public int getCount() {
        return users.size();
    }

    @Override
    public Object getItem(int position) {
        return users.get(position);
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
            holder.avatar = convertView.findViewById(R.id.imageAvatar);
            holder.flag = convertView.findViewById(R.id.imageFlag);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Users user = users.get(position);
        holder.txtName.setText(user.getName());
        holder.txtDescription.setText(user.getDescription());
        holder.avatar.setImageResource(user.getAvatar());
        holder.flag.setImageResource(user.getFlag());

        return convertView;
    }
}