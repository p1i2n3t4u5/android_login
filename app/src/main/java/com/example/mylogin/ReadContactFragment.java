package com.example.mylogin;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ReadContactFragment extends Fragment {

    private TextView displayTxt;

    public ReadContactFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_read_contact, container, false);
        displayTxt= view.findViewById(R.id.txt_display);
        readContacts();
        return view;
    }


    private void readContacts(){
        ContactDbHelper contactDbHelper=new ContactDbHelper(getActivity());
        SQLiteDatabase database = contactDbHelper.getReadableDatabase();
        Cursor  cursor=contactDbHelper.readContacts(database);
        String info="";

        while (cursor.moveToNext()){

         String id=  Integer.toString(cursor.getInt(cursor.getColumnIndex(ContactContract.ContactEntry.CONTACT_ID)));
         String name= cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.NAME));
         String email= cursor.getString(cursor.getColumnIndex(ContactContract.ContactEntry.EMAIL));
         info = info +"\n\n Id: "+id+" Name:"+name+" Email:"+email;
        }
        displayTxt.setText(info);

    }

}
