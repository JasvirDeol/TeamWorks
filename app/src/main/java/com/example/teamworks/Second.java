package com.example.teamworks;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Second extends Fragment {

    Button b1;
    Uri u;
    ImageView iv;

    public Second() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_second, container, false);
        b1=v.findViewById(R.id.button5);
        iv=v.findViewById(R.id.imageView);
        iv.setVisibility(View.INVISIBLE);
        // Inflate the layout for this fragment

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in=new Intent(Intent.ACTION_PICK);
                in.setType("image/*");
                startActivityForResult(in,1);
            }
        });
        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        u=data.getData();
        iv.setImageURI(u);
        iv.setVisibility(View.VISIBLE);
        b1.setVisibility(View.INVISIBLE);

    }
}
