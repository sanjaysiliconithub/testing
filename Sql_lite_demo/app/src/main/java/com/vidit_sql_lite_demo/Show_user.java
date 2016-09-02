package com.vidit_sql_lite_demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by android4 on 2/9/16.
 */
public class Show_user extends Fragment {
    private RecyclerView recyclerView;
    private LinearLayoutManager layoutManager;
    private UsersAdapter adapter;

    private DBHandler dbHandler;


    public Show_user() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_show_user, container, false);

        dbHandler = new DBHandler(getActivity());

        recyclerView = (RecyclerView) view.findViewById(R.id.usersList);

        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<User> users = dbHandler.getAllUsers();
        adapter = new UsersAdapter(users);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();

        Log.d("data",users.toString());

        return view;
    }
}
