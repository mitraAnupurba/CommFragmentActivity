package com.example.commfragmentactivity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageFragment extends Fragment {

    OnMessageSendListener messageSendListener;
    private Button button;
    private EditText editText;
    public interface OnMessageSendListener{
            public void onMessageSend(String message);
    }

    public MessageFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_message, container, false);

        editText = view.findViewById(R.id.text_message);
        button = view.findViewById(R.id.bn);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                //getting the user entered message and sending it to the MainActivity.java
                messageSendListener.onMessageSend(message);
            }
        });

        return view;

    }

    //lifecycle method to attach
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Activity activity = (Activity) context;
        try {
            messageSendListener = (OnMessageSendListener) activity;
        }
        catch(ClassCastException e){
            throw new ClassCastException(activity.toString()+ "      MUST IMPLEMENT ON MESSAGE SEND");

        }
    }

    //lifecycle method to resume:
    //@Override
    //public void onResume() {
     //   super.onResume();
       // editText.setText("");
    //}
}
