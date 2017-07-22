package com.example.pradeep.picpose.ui.fragments.men;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.adapters.PoseAdapter;
import com.example.pradeep.picpose.model.Pose;
import com.example.pradeep.picpose.ui.fragments.BaseFragment;

import java.util.ArrayList;

public class MenFragment extends BaseFragment implements MenView {

    private RecyclerView recyclerView;
    private PoseAdapter poseAdapter;
    private MenPresenter menPresenter;
    private FrameLayout frameProgress;

    public MenFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_men, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        menPresenter = new MenPresenter(MenFragment.this);
        init(view);
        loadData();
    }

    private void loadData() {
        menPresenter.getPoseData("men");
    }

    private void init(View view) {
        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerViewMen);
        frameProgress = (FrameLayout) view.findViewById(R.id.frameProgress);
        // load empty data to adapter
        poseAdapter = new PoseAdapter(new ArrayList<Pose>());
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

    @Override
    public void onManCompleted(ArrayList<Pose> poses) {
        // update adapter
        frameProgress.setVisibility(View.INVISIBLE);
        poseAdapter.updateList(poses);
    }

    @Override
    public void onManFail(String errorMsg) {
        // show dialog in snake bar
        frameProgress.setVisibility(View.INVISIBLE);
    }
}
