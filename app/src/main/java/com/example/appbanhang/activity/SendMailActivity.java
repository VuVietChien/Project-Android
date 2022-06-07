package com.example.appbanhang.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

import com.example.appbanhang.R;

public class SendMailActivity extends AppCompatActivity {

    EditText edtEmail, edtContentMail;
    Button btnSubmitSendMail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmail);
        ActionToolbar();
        mapping();
        handleSendMail();
    }

    private void handleSendMail() {
        btnSubmitSendMail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtContentMail.getText().toString().equals("") || edtEmail.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa điền đủ thông tin", Toast.LENGTH_LONG).show();
                    return;
                }
                final String username = "thuanbin1108@gmail.com"; // mail của app
                final String password = "woybsyxooxoqrrry";
                String messageToSend = edtContentMail.getText().toString();
                Properties properties = new Properties();
                properties.put("mail.smtp.auth", "true");
                properties.put("mail.smtp.starttls.enable", "true");
                properties.put("mail.smtp.host", "smtp.gmail.com");
                properties.put("mail.smtp.port", "587");
                Session session = Session.getInstance(properties, new Authenticator() {
                    @Override
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
                try {
                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(username));
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(edtEmail.getText().toString()));
                    message.setSubject("Sending Email without opening gmail apps");
                    message.setText(messageToSend);
                    Transport.send(message);
                    Toast.makeText(getApplicationContext(), "Gửi email thành công", Toast.LENGTH_LONG).show();
                    edtContentMail.setText("");
                    edtEmail.setText("");

                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }

    private void ActionToolbar() {

        ImageView iconBack = findViewById(R.id.back);
        iconBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SendMailActivity.this, LienHeActivity.class);
                startActivity(intent);
            }
        });
    }

    private void mapping(){
        edtContentMail = findViewById(R.id.edtContentMail);
        btnSubmitSendMail = findViewById(R.id.btnSubmitSendMail);
        edtEmail = findViewById(R.id.edtEmail);
    }
}