package com.alfonswaputra.aplikasiuasalfon.ui.auth;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginViewModel extends ViewModel {
    private MutableLiveData<String> _message = new MutableLiveData<>();
    private static final String TAG = "LoginViewModel";

    public void signIn(String email, String password, FirebaseAuth firebaseAuth) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            _message.postValue("Success");
                            Log.d(TAG, "Login success");
                        } else {
                            _message.postValue("Failed");
                            Log.d(TAG, "Login Failed");
                        }
                    }
                });

    }

    public LiveData<String> getMessage() {
        return _message;
    }
}
