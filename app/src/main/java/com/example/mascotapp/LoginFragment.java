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


public class LoginFragment extends Fragment {
    View view;
    EditText username,password;
    TextView  register;
    Button btnlogin;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_login, container, false);
        username = view.findViewById(R.id.username);
        password = view.findViewById(R.id.password);
        register = view.findViewById(R.id.register);
        btnlogin = view.findViewById(R.id.btn_login);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment);
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                GlobalProgressDialog.showProgress(getContext(), "Logging in please wait...");
                String user = username.getText().toString();
                String pass = password.getText().toString();

                if (user.isEmpty() || pass.isEmpty()) {
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
                    else
                    {

                        Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_registrationFragment);
                    }
                }


            }
        });


        return view;
    }
}