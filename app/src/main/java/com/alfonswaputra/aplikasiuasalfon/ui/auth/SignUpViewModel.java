package com.alfonswaputra.aplikasiuasalfon.ui.auth;

import android.app.Activity;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class SignUpViewModel extends ViewModel {

    private final MutableLiveData<String> _message = new MutableLiveData<>();
    private static final String TAG = "SignUpViewModel";

    public void signUp(String email, String password, FirebaseAuth auth, FirebaseUser firebaseUser) {
        auth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    _message.postValue("Success");
                    Log.d(TAG, "onComplete: User account created");
                } else {
                    _message.postValue("Failed");
                    Log.d(TAG, "onComplete: User account not created");
                }
            }
        });
    }

    public LiveData<String> getMessage() {
        return _message;
    }

}
