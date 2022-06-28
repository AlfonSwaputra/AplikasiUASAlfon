package com.alfonswaputra.aplikasiuasalfon.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alfonswaputra.aplikasiuasalfon.R;
import com.alfonswaputra.aplikasiuasalfon.databinding.FragmentSignUpBinding;
import com.alfonswaputra.aplikasiuasalfon.util.Constant;
import com.google.firebase.FirebaseException;
import com.google.firebase.FirebaseTooManyRequestsException;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class SignUpFragment extends Fragment {

    private FragmentSignUpBinding binding;
    private SignUpViewModel viewModel;
    private static final String TAG = "SignUpFragment";


    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser user = Constant.firebaseUser;
        if (user != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentSignUpBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SignUpViewModel.class);



        binding.signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailEdt.getText().toString().trim();
                String password = binding.passwordEdt.getText().toString().trim();

                if (email.equals("") || password.equals("")) {
                    Toast.makeText(requireActivity(), "Field tidak boleh kosong", Toast.LENGTH_SHORT).show();
                } else {
                    viewModel.signUp(email, password, Constant.firebaseAuth, Constant.firebaseUser);
                    binding.emailEdt.setText("");
                    binding.passwordEdt.setText("");
                }
            }
        });


        viewModel.getMessage().observe(this.requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireActivity(), s, Toast.LENGTH_SHORT).show();
                if (s.equals("Success")) {
                    Navigation.findNavController(view).navigate(R.id.surveyFragment);
                }
            }
        });

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}