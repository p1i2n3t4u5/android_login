package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.TextView;

public class DyanamicFragmentActivity extends AppCompatActivity implements MessageFragment.OnMessageReadListiner, HomeFragment.OnMessageSentListiner {

    public static FragmentManager fragmentManager;

    private String message;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dyanamic_fragment);
        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.db_fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            HomeFragment homeFragment = new HomeFragment();
            fragmentTransaction.add(R.id.db_fragment_container, homeFragment, null);
            fragmentTransaction.commit();
        }

        if (findViewById(R.id.fragment_container2) != null) {
            if (savedInstanceState != null) {
                return;
            }
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            MessageFragment messageFragment = new MessageFragment();
            fragmentTransaction.add(R.id.fragment_container2, messageFragment, null);
            fragmentTransaction.commit();

        }

    }

    @Override
    public void onMessageRead(String message) {
        this.message = message;
        textView = findViewById(R.id.txt_display_message_id);
        textView.setText(message);
    }

    @Override
    public void onMessageSent(String message) {
        FirstFragment firstFragment= new FirstFragment();

        Bundle bundle=new Bundle();
        bundle.putString("MESSAGE",message);
        firstFragment.setArguments(bundle);

        DyanamicFragmentActivity.fragmentManager.beginTransaction()
                .replace(R.id.db_fragment_container,firstFragment , null).addToBackStack(null).commit();
    }
}
