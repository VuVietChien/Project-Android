package com.example.appbanhang.activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
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

import java.util.HashMap;
import java.util.Map;

public class RegisterActivity extends AppCompatActivity {


    EditText edtTextFullNameRegister, edtTextEmailRegister, edtTextMobileRegister, edtTextPasswordRegister, edtTextRePasswordRegister;
    CircularProgressButton cirRegisterButton;
    String email, password, fullname, phone_number, repassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        mapping();
        cirRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }

    public void onLoginClick(View view) {
        startActivity(new Intent(this, LoginActivity.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }

    public void reset() {
        edtTextEmailRegister.setText("");
        edtTextPasswordRegister.setText("");
        edtTextMobileRegister.setText("");
        edtTextFullNameRegister.setText("");
        edtTextRePasswordRegister.setText("");
    }

    public void register() {

        email = edtTextEmailRegister.getText().toString().trim();
        password = edtTextPasswordRegister.getText().toString().trim();
        phone_number = edtTextMobileRegister.getText().toString().trim();
        fullname = edtTextFullNameRegister.getText().toString().trim();
        repassword = edtTextRePasswordRegister.getText().toString().trim();
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        if (!password.equals(repassword)) {
            Toast.makeText(RegisterActivity.this, "Mật khẩu không khớp", Toast.LENGTH_LONG).show();
        } else if (!email.equals("") && !password.equals("") && !phone_number.equals("") && !fullname.equals("")) {
            String URL = server.Duongdandangky;
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    if (response.equals("Success")) {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thành công", Toast.LENGTH_LONG).show();
                        reset();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Đăng ký thất bại", Toast.LENGTH_LONG).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegisterActivity.this, error.toString(), Toast.LENGTH_LONG).show();

                }
            }) {
                @Nullable
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    HashMap<String, String> data = new HashMap<>();
                    data.put("email", email);
                    data.put("password", password);
                    data.put("fullname", fullname);
                    data.put("phone_number", phone_number);
                    return data;
                }
            };
            requestQueue.add(stringRequest);
        } else {
            Toast.makeText(RegisterActivity.this, "Bạn chưa điền đẩy đủ thông tin", Toast.LENGTH_LONG).show();
        }
    }

    public void mapping() {
        edtTextFullNameRegister = findViewById(R.id.edtTextFullNameRegister);
        edtTextEmailRegister = findViewById(R.id.edtTextEmailRegister);
        edtTextMobileRegister = findViewById(R.id.edtTextMobileRegister);
        edtTextPasswordRegister = findViewById(R.id.edtTextPasswordRegister);
        cirRegisterButton = findViewById(R.id.cirRegisterButton);
        edtTextRePasswordRegister = findViewById(R.id.edtTextRePasswordRegister);
    }
}