package com.example.kancollewiki.fragment;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link CrusadeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link CrusadeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CrusadeFragment extends BaseFragment {

    public CrusadeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_crusade, container, false);
    }

}
