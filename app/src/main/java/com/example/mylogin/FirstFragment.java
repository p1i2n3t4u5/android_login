package com.example.mylogin;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {


    private Button button;

    private TextView textView;

    public FirstFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);
        button = view.findViewById(R.id.b2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DyanamicFragmentActivity.fragmentManager.beginTransaction()
                        .replace(R.id.db_fragment_container, new SecondFragment(), null).addToBackStack(null).commit();

            }
        });


        textView=view.findViewById(R.id.display_message_id);
        Bundle bundle=getArguments();
        if (bundle!=null) {
            textView.setText(bundle.getString("MESSAGE")!=null?bundle.getString("MESSAGE"):"hello");
        }
        return view;


    }

}
