package com.example.commfragmentactivity;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements MessageFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container) != null){
            if (savedInstanceState != null){
                return;
            }

            //code for adding first fragment to the main activity:
            MessageFragment messageFragment = new MessageFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container,messageFragment,null).commit();
        }
    }

    //implementing the onMessageSend method of the interface that mainactivity.java implements, i.e
    //OnMessageSendListener.
    @Override
    public void onMessageSend(String message) {
        //on the button click event, the new display fragment gets attached to the main activity class.
        //creating object of  message display fragment:
        MessageDisplayFragment messageDisplayFragment = new MessageDisplayFragment();

        //for sending data to the new fragment, we create object of the bundle class:
        Bundle bundle = new Bundle();
        //adding data to the bundle object:
        bundle.putString("Message",message);
        messageDisplayFragment.setArguments(bundle);

        //Fragment transaction object must be created for any work with the fragment:
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,messageDisplayFragment,null);

        //adding to backstack so that back button works:
        fragmentTransaction.addToBackStack(null);

        //commit fragment transaction:
        fragmentTransaction.commit();

    }
}
