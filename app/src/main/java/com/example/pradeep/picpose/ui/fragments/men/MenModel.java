package com.example.pradeep.picpose.ui.fragments.men;


import android.os.Handler;

import com.example.pradeep.picpose.model.Pose;

import java.util.ArrayList;

/**
 * Created by pradeep on 22/7/17.
 */

public class MenModel {

    private final MenModelInterface modelInterface;

    public MenModel(MenModelInterface modelInterface) {
        this.modelInterface = modelInterface;
    }

    public void makeWebCall(String type) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ArrayList<Pose> poses = new ArrayList<Pose>();
                for (int i = 0; i < 20 ; i++) {
                    Pose pose = new Pose();
                    pose.setImageUrl("https://s-media-cache-ak0.pinimg.com/originals/30/96/64/3096648ef76256192047d0b9bd2cc71f.jpg");
                    poses.add(pose);
                }
                modelInterface.webCallSuccess(poses);
            }
        }, 3000);
    }
}
