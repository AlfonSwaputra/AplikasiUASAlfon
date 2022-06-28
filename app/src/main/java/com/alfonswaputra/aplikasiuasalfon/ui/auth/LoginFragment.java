package com.alfonswaputra.aplikasiuasalfon.ui.auth;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.alfonswaputra.aplikasiuasalfon.R;
import com.alfonswaputra.aplikasiuasalfon.databinding.FragmentLoginBinding;
import com.alfonswaputra.aplikasiuasalfon.util.Constant;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;
    private LoginViewModel viewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(this).get(LoginViewModel.class);

        binding.signUpText.setOnClickListener(v -> {
            Navigation.findNavController(v).navigate(R.id.signUpFragment);
        });

        binding.signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = binding.emailEdt.getText().toString().trim();
                String password = binding.passwordEdt.getText().toString().trim();
                viewModel.signIn(email, password, Constant.firebaseAuth);
            }
        });

        viewModel.getMessage().observe(this.requireActivity(), new Observer<String>() {
            @Override
            public void onChanged(String s) {
                Toast.makeText(requireActivity(), s, Toast.LENGTH_SHORT).show();
                if (s.equals("Success")) {
                    Navigation.findNavController(view).navigate(R.id.surveyFragment);
                } else {
                    Toast.makeText(requireActivity(), "Login gagal, silahkan periksa email dan password", Toast.LENGTH_SHORT).show();
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