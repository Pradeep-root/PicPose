package com.example.pradeep.picpose.ui.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.adapters.PoseAdapter;
import com.example.pradeep.picpose.model.PoseModel;

import java.util.ArrayList;

public class TrendingFragment extends Fragment {
    private PoseAdapter poseAdapter;
    private RecyclerView recyclerView;

    public TrendingFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_trending, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();
    }

    private void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewTrending);
    }

    private void loadData() {
        poseAdapter = new PoseAdapter(new ArrayList<PoseModel>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(poseAdapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
