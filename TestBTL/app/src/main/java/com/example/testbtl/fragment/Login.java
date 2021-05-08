package com.example.testbtl.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.testbtl.FragmentReplacerActivity;
import com.example.testbtl.R;


public class Login extends Fragment {


    private EditText edt_user, edt_password;
    private Button btn_signIn;
    private TextView tV_signUp;
    //
    //public static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public Login() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        init(view);//
        clickListener();
    }

    private void init (View view){
        //
        edt_user = view.findViewById(R.id.eT_userLogin);
        edt_password = view.findViewById(R.id.eT_passwordLogin);
        //
        btn_signIn = view.findViewById(R.id.btn_login);
        //
        tV_signUp = view.findViewById(R.id.txt_signUp);

    }

    private void clickListener(){

        btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edt_user.getText().toString();
                String password = edt_password.getText().toString();

                if (user.isEmpty() || user.equals(" ")){
                    edt_user.setError("Input valid user");
                    return;
                }

                if (password.isEmpty() || password.length() < 6){
                    edt_user.setError("Input 6 digit valid password.");
                    return;
                }

            }
        });

        tV_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentReplacerActivity) getActivity()).setFragment(new CreateAccount()); // note ??
            }
        });

    }


}