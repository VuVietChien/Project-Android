package com.example.appbanhang.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.appbanhang.R;
import com.example.appbanhang.model.Sanpham;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class LapTopAdapter extends BaseAdapter {

    Context context;
    ArrayList<Sanpham> arrayLaptop;

    public LapTopAdapter(Context context, ArrayList<Sanpham> arrayLaptop) {
        this.context = context;
        this.arrayLaptop = arrayLaptop;
    }

    @Override
    public int getCount() {
        return arrayLaptop.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayLaptop.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public class ViewHolder{
        public TextView txttenLaptop,txtgiaLaptop,txtmotaLaptop;
        public ImageView imgLaptop;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LapTopAdapter.ViewHolder viewHolder = null;
        if(viewHolder==null){
            viewHolder = new LapTopAdapter.ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.dong_laptop,null);
            viewHolder.txttenLaptop = view.findViewById(R.id.textviewLaptop);
            viewHolder.txtgiaLaptop = view.findViewById(R.id.textviewgiaLaptop);
            viewHolder.txtmotaLaptop = view.findViewById(R.id.textviewmotaLaptop);
            viewHolder.imgLaptop = view.findViewById(R.id.imageviewLaptop);
            view.setTag(viewHolder);
        }else {
            viewHolder = (LapTopAdapter.ViewHolder) view.getTag();
        }
        Sanpham sanpham = (Sanpham) getItem(i);
        viewHolder.txttenLaptop.setText(sanpham.getTensanPham());
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtgiaLaptop.setText("Giá: "+decimalFormat.format(sanpham.getGiasanpham())+"Đ");
        viewHolder.txtmotaLaptop.setMaxLines(2);
        viewHolder.txtmotaLaptop.setEllipsize(TextUtils.TruncateAt.END);
        viewHolder.txtmotaLaptop.setText(sanpham.getMotasanpham());
        Glide.with(context).load(sanpham.getHinhanhsanpham()).into(viewHolder.imgLaptop);
        return view;
    }
}
