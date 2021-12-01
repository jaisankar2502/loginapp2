package com.example.loginapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.loginapp.databinding.ActivityPhoneauthenticationBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class Phoneauthentication extends AppCompatActivity {


    private ActivityPhoneauthenticationBinding binding;
    //if code send faild ,will reuse to send code otp
    private PhoneAuthProvider.ForceResendingToken forceResendingToken;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallbacks;
    private String mVerification;
    private static final String TAG = "MAIN_TAG";
    private FirebaseAuth firebaseAuth;
    private ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPhoneauthenticationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.linearLayout.setVisibility(View.VISIBLE);// show number layout
        binding.linearLayout2.setVisibility(View.GONE);//hide otp
        firebaseAuth = FirebaseAuth.getInstance();
        pd = new ProgressDialog(this);
        pd.setTitle("please wait.....");
        pd.setCanceledOnTouchOutside(false);
        mCallbacks = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
            @Override
            public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
                // this callback will invoke 2 situation
                // instant verification
                // Auto Retrieval
                signInwithPhoneAuthCredential(phoneAuthCredential);

            }

            @Override
            public void onVerificationFailed(@NonNull FirebaseException e) {
                pd.dismiss();
                Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onCodeSent(@NonNull String Verification, @NonNull PhoneAuthProvider.ForceResendingToken token) {
                super.onCodeSent(Verification, forceResendingToken);
                Log.d(TAG,"onCodeSent:"+Verification);
                mVerification= Verification;
                forceResendingToken=token;
                pd.dismiss();
                // hide number layout and show otp layout
                binding.linearLayout2.setVisibility(View.VISIBLE);
                binding.linearLayout.setVisibility(View.GONE);
                Toast.makeText(getApplicationContext(), "Verification code sent...", Toast.LENGTH_SHORT).show();
                binding.codeDiscription.setText("please enter the Verification code we sent to\t"+binding.numberTextId.getText().toString().trim());



            }
        };

        binding.continueId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonenumber = binding.numberTextId.getText().toString().trim();
                if (TextUtils.isEmpty(phonenumber)) {
                    Toast.makeText(getApplicationContext(), "please enter phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    startPhoneNumberverification(phonenumber);
                }


            }
        });

        binding.resendTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonenumber = binding.numberTextId.getText().toString().trim();
                if (TextUtils.isEmpty(phonenumber)) {
                    Toast.makeText(getApplicationContext(), "please enter phone number.", Toast.LENGTH_SHORT).show();
                } else {
                    resendPhoneNumberverification(phonenumber,forceResendingToken);
                }


            }
        });

        binding.otpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp = binding.optET.getText().toString().trim();
                if (TextUtils.isEmpty(otp)) {
                    Toast.makeText(getApplicationContext(), "please enter OTP", Toast.LENGTH_SHORT).show();
                } else {
                    verificationwithOtp(otp, mVerification);
                }

            }
        });


    }


    private void startPhoneNumberverification(String phonenumber) {
        pd.setMessage("verifying number");
        pd.show();
        PhoneAuthOptions options= PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phonenumber)
                .setTimeout(60l, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallbacks)
                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);



    }

    private void resendPhoneNumberverification(String phonenumber, PhoneAuthProvider.ForceResendingToken token) {
        pd.setMessage("Resend OTP");
        pd.show();
        PhoneAuthOptions options= PhoneAuthOptions.newBuilder(firebaseAuth)
                .setPhoneNumber(phonenumber)
                .setTimeout(60l, TimeUnit.SECONDS)
                .setActivity(this)
                .setCallbacks(mCallbacks)
                .setForceResendingToken(token)
                .build();

        PhoneAuthProvider.verifyPhoneNumber(options);


    }

    private void verificationwithOtp(String otp, String mVerification) {
        pd.setMessage("Verifying number");
        pd.show();
        PhoneAuthCredential credential= PhoneAuthProvider.getCredential(otp,mVerification);
        signInwithPhoneAuthCredential(credential);
    }

    private void signInwithPhoneAuthCredential(PhoneAuthCredential credential) {
        pd.setMessage("Logging In");
        firebaseAuth.signInWithCredential(credential)
                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        // success sign in
                        pd.dismiss();
                        String phone=firebaseAuth.getCurrentUser().getPhoneNumber();
                        Toast.makeText(getApplicationContext(), "Logging In as "+phone, Toast.LENGTH_SHORT).show();

                   startActivity(new Intent(getApplicationContext(),Firebasephoneexample.class));
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //fail sing in
                        pd.dismiss();
                        Toast.makeText(getApplicationContext(), ""+e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });


    }
}