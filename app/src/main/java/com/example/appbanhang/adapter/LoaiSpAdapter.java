package com.example.appbanhang.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appbanhang.R;
import com.example.appbanhang.model.LoaiSp;

import java.util.ArrayList;

public class LoaiSpAdapter extends BaseAdapter {
   ArrayList<LoaiSp> arrayList;
   Context context;

    public LoaiSpAdapter(ArrayList<LoaiSp> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        TextView txttenloaisp;
        ImageView imgloaisp;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder=null;
        if(view == null){
            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=layoutInflater.inflate(R.layout.dong_listview_loaisp,null);
            viewHolder.txttenloaisp = view.findViewById(R.id.textviewloaisp);
            viewHolder.imgloaisp = view.findViewById(R.id.imageviewloaisp);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        LoaiSp loaiSp =(LoaiSp) getItem(i);
        viewHolder.txttenloaisp.setText(loaiSp.getTenloaisp());
        Glide.with(context).load(loaiSp.getHinhanhloaisp()).into(viewHolder.imgloaisp);

        return view;
    }
}
