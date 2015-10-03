package com.example.kancollewiki.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.R;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;

public class LevelFragment extends BaseFragment {
    UltimateRecyclerView ultimateRecyclerView;
    public LevelFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_level, container, false);
        ultimateRecyclerView = (UltimateRecyclerView) rootView.findViewById(R.id.level_list);
        return rootView;
    }





}
