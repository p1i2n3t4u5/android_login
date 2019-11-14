package com.example.mylogin;


import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddContactFragment extends Fragment {


    private EditText contactIdEditText;
    private EditText nameEditText;
    private EditText emailEditText;

    private Button saveBtn;


    public AddContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_add_contact, container, false);

        contactIdEditText = view.findViewById(R.id.contactid_id);
        nameEditText = view.findViewById(R.id.name_id);
        emailEditText = view.findViewById(R.id.email_id);




        saveBtn=view.findViewById(R.id.savebtn_id);
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contactId = contactIdEditText.getText().toString();
                String name=nameEditText.getText().toString();
                String email=emailEditText.getText().toString();

                ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
                SQLiteDatabase sqLiteDatabase= contactDbHelper.getWritableDatabase();
                contactDbHelper.addContact(Integer.parseInt(contactId),name,email,sqLiteDatabase);
                contactDbHelper.close();
                contactIdEditText.setText("");
                nameEditText.setText("");
                emailEditText.setText("");
                Toast.makeText(getActivity(),"Contact Saved successfylly ....",Toast.LENGTH_SHORT).show();
            }
        });


        return view;
    }

}
