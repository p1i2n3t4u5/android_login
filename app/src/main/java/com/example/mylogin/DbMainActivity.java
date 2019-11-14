package com.example.mylogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class DbMainActivity extends AppCompatActivity implements DbHomeFragment.OnDbOpPerformed{

    public static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_db_main);
        fragmentManager = getSupportFragmentManager();

        if (findViewById(R.id.db_fragment_container) != null) {

            if (savedInstanceState != null) {
                return;
            }

            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            DbHomeFragment dbHomeFragment = new DbHomeFragment();
            fragmentTransaction.add(R.id.db_fragment_container, dbHomeFragment, null);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void dbOpPerformed(int method) {
        switch (method){
            case 0:
                fragmentManager.beginTransaction()
                    .replace(R.id.db_fragment_container, new AddContactFragment(), null).addToBackStack(null).commit();
                break;

            case 1:
                fragmentManager.beginTransaction()
                        .replace(R.id.db_fragment_container, new ReadContactFragment(), null).addToBackStack(null).commit();
                break;
        }
    }
}
