package com.example.greetings;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import butterknife.BindView;
import butterknife.ButterKnife;
import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.signin)
    Button signin;
    @BindView(R.id.email)
    EditText emailTV;
    @BindView(R.id.password)
    EditText passwordTV;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((R.layout.sign_in));
        Button openRegistrationButton = findViewById((R.id.registrationButton));
        ButterKnife.bind(this);
        openRegistrationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivityForResult(intent, MainActivity.LOGIN_REQUEST_CODE);
            }
        });
        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String email = emailTV.getText().ToString();
                MainActivity.firebaseDatabase.getReference("user").child(Utils.md5Custom(email))
                        .addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        User user = (User) dataSnapshot.getValue(User.class);
                        if(user == null){
                            Toasty.error(getApplicationContext(),
                                    "Неправильное имя пользователя или пароль").show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
    }
}
