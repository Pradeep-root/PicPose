package com.example.pradeep.picpose.ui.fragments.women;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.adapters.PoseAdapter;
import com.example.pradeep.picpose.model.Pose;
import com.example.pradeep.picpose.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class WomenFragment extends BaseFragment {

    private PoseAdapter poseAdapter;
    private RecyclerView recyclerView;

    public WomenFragment() {
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
        return inflater.inflate(R.layout.fragment_women, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        init(view);
        loadData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewWoMen);
    }

    private void loadData() {
        poseAdapter = new PoseAdapter(new ArrayList<Pose>());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(poseAdapter);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
