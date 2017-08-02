package com.example.pradeep.picpose.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.model.Pose;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by pradeep on 2/4/17.
 */

public class PoseAdapter extends RecyclerView.Adapter<PoseAdapter.ViewHolder> {


    private final ArrayList<Pose> poses;
    private Context context;

    public PoseAdapter(ArrayList<Pose> poses){
        this.poses = poses;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View rootView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_card_item, parent, false);
        this.context = parent.getContext();
        return new ViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // Pose poseModel = poses.get(position);
        Picasso.with(context).load(poses.get(position).getImageUrl()).resize(200, 200).centerCrop().into(holder.imageViewPose);

    }

    @Override
    public int getItemCount() {
       // return poses.size();
        return poses.size();
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

    public void updateList(ArrayList<Pose> poses){
        this.poses.clear();;
        this.poses.addAll(poses);
        notifyDataSetChanged();
    }
}
