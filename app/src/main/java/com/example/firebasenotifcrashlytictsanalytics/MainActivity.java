package com.example.firebasenotifcrashlytictsanalytics;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.iid.FirebaseInstanceId;

public class MainActivity extends AppCompatActivity {

    Button btn_crash,btn_analytics;

    TextView txt;

    private FirebaseAnalytics mFirebaseAnalytics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mFirebaseAnalytics = FirebaseAnalytics.getInstance(this);


        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        String a  = refreshedToken;


        btn_analytics = findViewById(R.id.btn_analytics);
        btn_crash = findViewById(R.id.btn_crash);


        btn_crash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // crash created because of dismiss findviewbyid
                txt.setText("");
            }
        });


        btn_analytics.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // to add event to amalytics
                Bundle bundle = new Bundle();
                bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "MyId");
                bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Login");
                bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "MyImage");
//                mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_ITEM, bundle);
                mFirebaseAnalytics.logEvent("login",bundle);

            }
        });


    }


}