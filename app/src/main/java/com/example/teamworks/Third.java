package com.example.teamworks;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Third extends Fragment {
    TextView tv;
  RecyclerView rv;
    View v;
    List<ImageList> l;
    MyAdapter ad;

    public Third() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        l=new ArrayList<>();
        v=inflater.inflate(R.layout.fragment_third, container, false);

        //ad.notifyDataSetChanged();
        getData();


        return v;
    }
    private void getData()
    {
        Call<List<ImageList>> imageList=MyApi.getService().getImageList();
        imageList.enqueue(new Callback<List<ImageList>>() {
            @Override
            public void onResponse(Call<List<ImageList>> call, Response<List<ImageList>> response) {
                List<ImageList> l=response.body();
                Toast.makeText(getContext(),"success", Toast.LENGTH_SHORT).show();
               // tv.setText(l.get(1).getUrl()+"");
                rv=v.findViewById(R.id.recyclerView);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                ad=new MyAdapter(getContext(),l);
                rv.setAdapter(ad);
               // ad.notifyDataSetChanged();


            }

            @Override
            public void onFailure(Call<List<ImageList>> call, Throwable t) {
                Toast.makeText(getContext(),t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

}
