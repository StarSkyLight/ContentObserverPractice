package com.example.ziyi.contentobserverpractice;

import android.database.ContentObserver;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getContentResolver().registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, new ContactsObserver(new Handler()));
    }

    private final class ContactsObserver extends ContentObserver{
        public ContactsObserver(Handler handler){
            super(handler);
        }

        public void onChange(boolean selfChange){
            TextView textView = (TextView)findViewById(R.id.text);
            textView.setText("Contact data is changed.");
            Log.v("tag","Contact data is changed.");
        }

    }


}
