package com.example.mascotapp;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mascotapp.utils.Global;
import com.example.mascotapp.utils.GlobalProgressDialog;

public class RegistrationFragment extends Fragment {
    View view;
    EditText mobilenumber ,username,password;
    TextView txtlogin;
    Button btnsignup;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view =  inflater.inflate(R.layout.fragment_registration, container, false);

        mobilenumber = view.findViewById(R.id.mbnumber);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        txtlogin = view.findViewById(R.id.txt_login);
        btnsignup = view.findViewById(R.id.btn_singup);


        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment);
                GlobalProgressDialog.showProgress(getContext(), "Logging in please wait...");
                String phone = mobilenumber.getText().toString();
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (phone.isEmpty() || user.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(getActivity(), "Somthing is missing ", Toast.LENGTH_SHORT).show();

                    if (GlobalProgressDialog.isProgressShowing()) {
                        GlobalProgressDialog.dismissProgress();
                    }
                } else {
                    if (!Global.isOnline(getActivity())) {
                        if (GlobalProgressDialog.isProgressShowing()) {
                            GlobalProgressDialog.dismissProgress();
                        }
                        Toast.makeText(getActivity(), "No internet", Toast.LENGTH_SHORT).show();
                    }
                    else {

                        Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment);
                    }
                }
            }
        });

        txtlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment);

            }
        });
        return view;
    }
}