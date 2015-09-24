package com.example.kancollewiki.fragment;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kancollewiki.R;
import com.example.kancollewiki.adapter.ShipDetailAdapter;
import com.example.kancollewiki.adapter.ShipDetailBinder;
import com.example.kancollewiki.adapter.ShipDetailFragmentBinder;
import com.example.kancollewiki.adapter.ShipWeaponBinder;
import com.example.kancollewiki.bean.Weapon;
import com.example.kancollewiki.bean.ship.Ship;
import com.example.kancollewiki.util.Utils;
import com.marshalchen.ultimaterecyclerview.UltimateRecyclerView;
import com.marshalchen.ultimaterecyclerview.UltimateViewAdapter;
import com.marshalchen.ultimaterecyclerview.multiViewTypes.DataBinder;
import com.marshalchen.ultimaterecyclerview.stickyheadersrecyclerview.StickyRecyclerHeadersDecoration;

import org.jsoup.Connection;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShipDetailFragment extends BaseFragment {
    UltimateRecyclerView ultimateRecyclerView;
    private ShipDetailAdapter shipDetailAdapter;
    private Ship ship;
    private LinearLayoutManager linearLayoutManager;

    public ShipDetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ultimateRecyclerView = (UltimateRecyclerView) inflater.inflate(R.layout.fragment_ship_detail, container, false);
        initData();
        linearLayoutManager = new LinearLayoutManager(ultimateRecyclerView.getContext());
        ultimateRecyclerView.setLayoutManager(linearLayoutManager);
        StickyRecyclerHeadersDecoration headersDecoration = new StickyRecyclerHeadersDecoration(shipDetailAdapter);
        ultimateRecyclerView.addItemDecoration(headersDecoration);
        ultimateRecyclerView.setAdapter(shipDetailAdapter);
        Utils.log(shipDetailAdapter.getItemCount()+ "count in shipDetailAdapter");
        return ultimateRecyclerView;
    }

    private void initData() {
        ship = (Ship) getArguments().getSerializable("ship");
        List<Weapon> weapons = new ArrayList<>();
        Weapon weapon = new Weapon();
        weapon.setName("weapontest");
        Weapon weapon1 = new Weapon();
        weapon1.setName("weapontest1");
        Weapon weapon2 = new Weapon();
        weapon2.setName("weapontest2");
        weapons.add(weapon);
        weapons.add(weapon1);
        weapons.add(weapon2);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        weapons.add(weapon);
        ship.setWeapons(weapons);
        shipDetailAdapter = new ShipDetailAdapter();

//        ultimateRecyclerView.add
        List<ShipDetailFragmentBinder> lists = new ArrayList<>();
        ShipDetailBinder shipDetailBinder = new ShipDetailBinder(shipDetailAdapter, ship);
        ShipWeaponBinder shipWeaponBinder = new ShipWeaponBinder(shipDetailAdapter, ship, ship.getWeapons());
        lists.add(shipDetailBinder);
        lists.add(shipWeaponBinder);
        shipDetailAdapter.setBinders(lists);
    }

}
