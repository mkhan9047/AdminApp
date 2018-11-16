package com.teammanagement.adminapp.View.Fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.teammanagement.adminapp.R;
import com.teammanagement.adminapp.View.Activity.AuthActivity;
import com.teammanagement.adminapp.View.Activity.DashboardActivity;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SignInFragment extends Fragment {

    TextView signUp, forgotPassword;
    ImageButton backButton;
    EditText email, password;
    Button signIn;

    public SignInFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();


        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), DashboardActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                assert getActivity() != null;
                getActivity().startActivity(intent);
                getActivity().finish();
                getActivity().overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null)
                    getActivity().onBackPressed();
            }
        });

        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null)
                    ((AuthActivity) getActivity()).fragmentTransition(new SignUpFragment());
            }
        });

        forgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (getActivity() != null)
                    ((AuthActivity) getActivity()).fragmentTransition(new ForgotPasswordFragment());
            }
        });


    }

    private void initViews() {
        View view = getView();

        if (view != null) {
            signIn = view.findViewById(R.id.btn_sign_in);
            email = view.findViewById(R.id.etdx_email);
            password = view.findViewById(R.id.etdx_password);
            signUp = view.findViewById(R.id.txt_sign_up);
            forgotPassword = view.findViewById(R.id.txt_forgot_password);
            backButton = view.findViewById(R.id.btn_back);
        }
    }
}
