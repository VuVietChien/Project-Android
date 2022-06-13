package com.example.appbanhang.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.example.appbanhang.R;
import com.example.appbanhang.activity.LoginActivity;
import com.example.appbanhang.ultil.DatalocalManager;

public class OnboardingFragment3 extends Fragment {

private Button btnstart;
private View mView;

    public OnboardingFragment3() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.fragment_onboarding3, container, false);
        btnstart = mView.findViewById(R.id.btn_start);

        btnstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                DatalocalManager.setFirstInstalled(true);
//                DatalocalManager.setFirstInstalled3(true);

                getActivity().startActivity(intent);
            }
        });
        return mView;
    }
}