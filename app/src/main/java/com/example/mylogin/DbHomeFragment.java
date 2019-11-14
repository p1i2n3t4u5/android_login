package com.example.mylogin;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class DbHomeFragment extends Fragment implements View.OnClickListener {

    public static FragmentManager fragmentManager;

    private Button addContactBtn,viewContactBtn,updateContactBtn,deleteContactBtn;

    private OnDbOpPerformed onDbOpPerformed;

    public DbHomeFragment() {
        // Required empty public constructor
    }


    public interface OnDbOpPerformed{

        public void dbOpPerformed(int method);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_db_home, container, false);



        addContactBtn = view.findViewById(R.id.add_contact_id);
        addContactBtn.setOnClickListener(this);

        viewContactBtn = view.findViewById(R.id.view_contact_id);
        viewContactBtn.setOnClickListener(this);


//
//        updateContactBtn = view.findViewById(R.id.update_contact_id);
//        updateContactBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });
//
//        deleteContactBtn = view.findViewById(R.id.delete_contact_id);
//        deleteContactBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//
//            }
//        });

        return  view;

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.add_contact_id:
                onDbOpPerformed.dbOpPerformed(0);
                break;
            case R.id.view_contact_id:
                onDbOpPerformed.dbOpPerformed(1);
                break;
//            case R.id.update_contact_id:
//
//                break;
//            case R.id.delete_contact_id:
//
//                break;


        }

    }




    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity)context;
        try {
            onDbOpPerformed=(OnDbOpPerformed)activity;
        }catch (ClassCastException c){
            throw  new ClassCastException(activity.toString()+" must override onMessageRead method");
        }

    }
}
