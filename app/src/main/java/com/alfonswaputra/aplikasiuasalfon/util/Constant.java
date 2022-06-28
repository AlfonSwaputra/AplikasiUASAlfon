package com.alfonswaputra.aplikasiuasalfon.util;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class Constant {
    public static final FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public static final FirebaseDatabase realtimeDBAuth = FirebaseDatabase.getInstance();
    public static final FirebaseUser firebaseUser = firebaseAuth.getCurrentUser();
}
