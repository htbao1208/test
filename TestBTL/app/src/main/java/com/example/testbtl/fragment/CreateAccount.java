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

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.example.testbtl.FragmentReplacerActivity;
import com.example.testbtl.R;


public class CreateAccount extends Fragment {

    //
    private EditText edt_user, edt_password, edt_cfpassword, edt_email;
    //
    private Button btn_signUp;
    //
    private TextView tV_signIn;
    //
    public static final String EMAIL_REGEX = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$";
    public static final String PASSWORD_REGEX = "\"(?=.*[a-z])(?=.*[A-Z])(?=.*[\\d)"
                                                + "(?=.*[~`!@#\\$%\\^&\\+\\=\\*\\(\\)\\-_)"
                                                + "(?=\\{\\}\\[\\]\\|\\;:\"<>,./\\?]).{8,}";
    //
    AwesomeValidation awesomeValidation;


    public CreateAccount() {
        // Required empty public constructor
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_account, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);//

        xuLi();
        clickListener();
    }

    private void init(View view){
        //
        edt_user = view.findViewById(R.id.eT_userSignUp);
        edt_password = view.findViewById(R.id.eT_passwordSignUp);
        edt_cfpassword = view.findViewById(R.id.eT_cfpasswordSignUp);
        edt_email = view.findViewById(R.id.eT_emailSignUp);
        //
        btn_signUp = view.findViewById(R.id.btn_signup);
        //
        tV_signIn = view.findViewById(R.id.txt_signInFrSignUp);
    }

    public void xuLi(){
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

    }

    private void clickListener (){
        tV_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((FragmentReplacerActivity) getActivity()).setFragment(new Login()); // note ??
            }
        });
        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = edt_user.getText().toString();
                String pass = edt_password.getText().toString();
                String cfpass = edt_cfpassword.getText().toString();
                String email = edt_email.getText().toString();

                /*if(name.isEmpty() || name.equals(" ")){
                    edt_user.setError("Please input valid name.");
                    return;
                }
                if(pass.isEmpty() || pass.length() < 6){
                    edt_user.setError("Please input valid password.");
                    return;
                }
                if(cfpass.isEmpty() || pass.equals(cfpass)){
                    edt_user.setError("Password not match.");
                    return;
                }
                if(email.isEmpty() || email.matches(EMAIL_REGEX)){

                    edt_user.setError("Please input valid email.");
                    return;
                }*/
            }
        });
    }

}