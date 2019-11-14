package com.example.mylogin;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class HomeFragment extends Fragment {


    private Button button;

    private Button button2;
    private EditText  editText;
    private OnMessageSentListiner onMessageSentListiner;



    public HomeFragment() {

    }

    public interface OnMessageSentListiner{
        public  void onMessageSent(String message);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        button = view.findViewById(R.id.b1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DyanamicFragmentActivity.fragmentManager.beginTransaction()
                        .replace(R.id.db_fragment_container, new FirstFragment(), null).addToBackStack(null).commit();

            }
        });

        editText=view.findViewById(R.id.message_text_id);
        button2 = view.findViewById(R.id.sent_to_first_btn);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMessageSentListiner.onMessageSent(editText.getText().toString());
            }
        });

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        Activity activity=(Activity)context;
        try {
            onMessageSentListiner=(OnMessageSentListiner)activity;
        }catch (ClassCastException c){
            throw  new ClassCastException(activity.toString()+" must override onMessageRead method");
        }

    }
}
