package com.example.appbanhang.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.R;
import com.example.appbanhang.adapter.DienthoaiAdapter;
import com.example.appbanhang.model.Sanpham;
import com.example.appbanhang.ultil.Checkconnection;
import com.example.appbanhang.ultil.server;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DienThoaiActivity extends AppCompatActivity {
    ListView lvdt;
    DienthoaiAdapter dienthoaiAdapter;
    ArrayList<Sanpham> mangdt;
    int iddt = 0;
    int page = 1;
    View footerview;
    boolean isLoading = false;
    boolean limitData = false;
    mHandler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dien_thoai);
        if (Checkconnection.haveNetworkConnection(getApplicationContext())) {
            Anhxa();
            GetIDLoaisp();
            ActionToolbar();
            GetData(page);
            LoadMoreData();

        } else {
            Checkconnection.ShowToast_Short(getApplicationContext(), "Bạn hãy kiểm tra lại kết nối");
            finish();
        }

    }

    private void LoadMoreData() {
        lvdt.setOnItemClickListener(((adapterView, view, i, l) -> {
            Intent intent = new Intent(getApplicationContext(), ChiTietSanPham.class);
            intent.putExtra("thongtinsanpham", mangdt.get(i));
            startActivity(intent);
        }));
        lvdt.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {

            }

            @Override
            public void onScroll(AbsListView absListView, int FirstItem, int VisibleItem, int TotalItem) {
                if (FirstItem + VisibleItem == TotalItem && TotalItem != 0 && isLoading == false && limitData == false) {
                    isLoading = true;
                    ThreadData threadData = new ThreadData();
                    threadData.start();
                }
            }
        });
    }

    private void GetData(int page) {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        String duongdan = server.Duongdandienthoai + String.valueOf(page);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, duongdan, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                int id = 0;
                String Tendt = "";
                int Gaidt = 0;
                String Hinhanhdt = "";
                String Mota = "";
                int Idspdt = 0;
                if (response != null && response.length() != 2) {
                    lvdt.removeFooterView(footerview);
                    try {
                        JSONArray jsonArray = new JSONArray(response);
                        for (int i = 0; i < jsonArray.length(); i++) {
                            JSONObject jsonObject = jsonArray.getJSONObject(i);
                            id = jsonObject.getInt("id");
                            Tendt = jsonObject.getString("tensanpham");
                            Gaidt = jsonObject.getInt("giasanpham");
                            Hinhanhdt = jsonObject.getString("hinhanhsanpham");
                            Mota = jsonObject.getString("motasanpham");
                            Idspdt = jsonObject.getInt("idsanpham");
                            mangdt.add(new Sanpham(id, Tendt, Gaidt, Hinhanhdt, Mota, Idspdt));
                            dienthoaiAdapter.notifyDataSetChanged();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    limitData = true;
                    lvdt.removeFooterView(footerview);
                    Checkconnection.ShowToast_Short(getApplicationContext(), "Đã hết dữ liệu");
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                HashMap<String, String> param = new HashMap<String, String>();
                param.put("idsanpham", String.valueOf(iddt));
                return param;
            }
        };
        requestQueue.add(stringRequest);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.menugiohang:
                Intent intent  = new Intent(getApplicationContext(), com.example.appbanhang.activity.Giohang.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }
    private void ActionToolbar() {

        ImageView iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DienThoaiActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void GetIDLoaisp() {
        iddt = getIntent().getIntExtra("idloaisanpham", -1);
        Log.d("giatriloaisanpham", iddt + "");
    }

    private void Anhxa() {
        lvdt = findViewById(R.id.listviedienthoai);
        mangdt = new ArrayList<>();
        dienthoaiAdapter = new DienthoaiAdapter(getApplicationContext(), mangdt);
        lvdt.setAdapter(dienthoaiAdapter);
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        footerview = inflater.inflate(R.layout.progress_bar, null);
        mHandler = new mHandler();
    }

    public class mHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what) {
                case 0:
                    lvdt.addFooterView(footerview);
                    break;
                case 1:
                    GetData(++page);
                    isLoading = false;
                    break;
            }
            super.handleMessage(msg);
        }


    }

    public class ThreadData extends Thread {
        @Override
        public void run() {
            mHandler.sendEmptyMessage(0);
            try {
                Thread.sleep(3000);

            } catch (InterruptedException e) {

            }
            Message message = mHandler.obtainMessage(1);
            mHandler.sendMessage(message);
            super.run();
        }
    }
}