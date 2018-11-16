package com.teammanagement.adminapp.View.Fragment;


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

import org.w3c.dom.Text;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class SignUpFragment extends Fragment {

    ImageButton backButton;
    EditText userName, emailAddress, password, confirmPassword;
    Button signUp;
    TextView singIn;


    public SignUpFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        initViews();

        backButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                assert getActivity() != null;
                ((AuthActivity) getActivity()).onBackPressed();
            }
        });

        singIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(getActivity() != null)
                ((AuthActivity)getActivity()).fragmentTransition(new SignInFragment());
            }
        });
    }

    private void initViews() {

        View view = getView();

        if (view != null) {

            backButton = view.findViewById(R.id.btn_back);
            userName = view.findViewById(R.id.edtx_name);
            emailAddress = view.findViewById(R.id.edtx_email);
            password = view.findViewById(R.id.edtx_password);
            signUp = view.findViewById(R.id.btn_sign_up);
            confirmPassword = view.findViewById(R.id.edtx_confirm_password);
            singIn = view.findViewById(R.id.txt_sign_in);
        }
    }


}
