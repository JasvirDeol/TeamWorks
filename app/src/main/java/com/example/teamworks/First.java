package com.example.teamworks;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class First extends Fragment {
    TextView t1,t2;


    public First() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_first, container, false);
        t1=v.findViewById(R.id.textView4);
        t2=v.findViewById(R.id.textView6);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_DIAL);
                in.setData(Uri.parse("tel:+91 9123456789"));
                startActivity(in);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_SEND);
                in.putExtra(Intent.EXTRA_EMAIL, new String[]{"abcde@xyz.com)"});
                in.setType("message/rfc822");
                startActivity(Intent.createChooser(in, "Choose an Email client :"));
            }
        });

        // Inflate the layout for this fragment
        return v;
    }

}
