package com.example.commfragmentactivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class MessageDisplayFragment extends Fragment {

    private TextView textView;

    public MessageDisplayFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_message_display, container, false);
        textView = view.findViewById(R.id.text_message_display);

        //bundle object to get arguments:
        Bundle bundle = getArguments();
        String message = bundle.getString("message");
        textView.setText(message);

        return view;
    }


}
