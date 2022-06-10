package com.example.appbanhang.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.apachat.loadingbutton.core.customViews.CircularProgressButton;
import com.example.appbanhang.R;
import com.example.appbanhang.ultil.server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class CapNhatTaiKhoan extends AppCompatActivity {

    EditText edtTextFullNameUpdate, edtTextMobileUpdate, edtTextEmailUpdate;
    CircularProgressButton cirChangePasswordButton, cirUpdateDataUserButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cap_nhat_tai_khoan);
        mapping();
        ActionToolbar();
        updateDataUser();
        cirChangePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CapNhatTaiKhoan.this, DoiMatKhau.class);
                startActivity(intent);
            }
        });

    }

    private void updateDataUser() {
        Intent i = getIntent();
        edtTextMobileUpdate.setText(i.getStringExtra("phone_number"));
        edtTextFullNameUpdate.setText(i.getStringExtra("fullname"));
        edtTextEmailUpdate.setText(i.getStringExtra("email"));


        cirUpdateDataUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = edtTextEmailUpdate.getText().toString();
                String fullname = edtTextFullNameUpdate.getText().toString();
                String phone_number = edtTextMobileUpdate.getText().toString();
                if (fullname.isEmpty() && phone_number.isEmpty()) {
                    Toast.makeText(CapNhatTaiKhoan.this, "Bạn chưa điền đủ thông tin", Toast.LENGTH_LONG).show();
                } else {
                    String URL = server.Duongdancapnhatthongtintaikhoan;
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response);
                                String result = jsonObject.getString("status");
                                if (result.equals("success")) {
                                    Toast.makeText(CapNhatTaiKhoan.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
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
                            Map<String, String> data = new HashMap<>();
                            data.put("fullname", fullname);
                            data.put("phone_number", phone_number);
                            data.put("email", email);
                            return data;
                        }
                    };
                    requestQueue.add(stringRequest);
                }
            }
        });
    }


    private void ActionToolbar() {

        ImageView iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CapNhatTaiKhoan.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }


    private void mapping() {
        edtTextFullNameUpdate = findViewById(R.id.edtTextFullNameUpdate);
        edtTextMobileUpdate = findViewById(R.id.edtTextMobileUpdate);
        cirUpdateDataUserButton = findViewById(R.id.cirUpdateDataUserButton);
        cirChangePasswordButton = findViewById(R.id.cirChangePasswordButton);


        edtTextEmailUpdate = findViewById(R.id.edtTextEmailUpdate);
        edtTextEmailUpdate.setFocusable(false);
        edtTextEmailUpdate.setEnabled(false);
        edtTextEmailUpdate.setCursorVisible(false);
        edtTextEmailUpdate.setKeyListener(null);
        edtTextEmailUpdate.setBackgroundColor(Color.TRANSPARENT);


    }
}