package com.example.pradeep.picpose.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.model.PoseModel;

import java.util.ArrayList;

/**
 * Created by pradeep on 2/4/17.
 */

public class PoseAdapter extends RecyclerView.Adapter<PoseAdapter.ViewHolder> {


    private final ArrayList<PoseModel> poseModels;

    public PoseAdapter(ArrayList<PoseModel> poseModels){
        this.poseModels = poseModels;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_item, parent, false);
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // PoseModel poseModel = poseModels.get(position);

    }

    @Override
    public int getItemCount() {
       // return poseModels.size();
        return 10;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewPose;
        public TextView textViewTitle;
        public TextView textViewDetails;

        public ViewHolder(View itemView) {
            super(itemView);
            imageViewPose = (ImageView) itemView.findViewById(R.id.image_thumbnail);
            textViewTitle = (TextView) itemView.findViewById(R.id.textPosTitle);
            textViewDetails = (TextView) itemView.findViewById(R.id.textPosDescription);
        }
    }
}
