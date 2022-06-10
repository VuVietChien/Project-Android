package com.example.appbanhang.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appbanhang.R;
import com.example.appbanhang.ultil.server;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class DoiMatKhau extends AppCompatActivity {

    EditText edtEmailChangePassword, edtOldPassword, edtNewPassword, edtReNewPassword, edtTextEmailUpdate;
    Button btnSubmitChangePassword;
    String oldPassword;
    String newPassword;
    String reNewPassword;
    String email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);
        ActionToolbar();
        mapping();
        changePassword();

    }

    private void changePassword() {
        btnSubmitChangePassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                oldPassword = edtOldPassword.getText().toString().trim();
                newPassword = edtNewPassword.getText().toString().trim();
                reNewPassword = edtReNewPassword.getText().toString().trim();
                email = edtEmailChangePassword.getText().toString().trim();

                if (oldPassword.equals("") && newPassword.equals("") && reNewPassword.equals("")) {
                    Toast.makeText(DoiMatKhau.this, "Bạn chưa điền đủ thông tin", Toast.LENGTH_LONG).show();
                }
                else {
                    String URL = server.Duongdandoimatkhau;
                    RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
                    StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            JSONObject jsonObject = null;
                            try {
                                jsonObject = new JSONObject(response);
                                String result = jsonObject.getString("status");
                                if (result.equals("success")) {
                                    Toast.makeText(DoiMatKhau.this, "Cập nhật thành công", Toast.LENGTH_LONG).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(DoiMatKhau.this, error.toString(), Toast.LENGTH_LONG).show();

                        }
                    }) {
                        @Nullable
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String, String> data = new HashMap<>();
                            data.put("oldPassword", oldPassword);
                            data.put("newPassword", newPassword);
                            data.put("reNewPassword", reNewPassword);
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
                Intent intent = new Intent(DoiMatKhau.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mapping() {
        edtOldPassword = findViewById(R.id.edtOldPassword);
        edtNewPassword = findViewById(R.id.edtNewPassword);
        edtReNewPassword = findViewById(R.id.edtReNewPassword);
        edtEmailChangePassword = findViewById(R.id.edtEmailChangePassword);
        btnSubmitChangePassword = findViewById(R.id.btnSubmitChangePassword);
    }
}