package com.example.pradeep.picpose.ui.fragments.men;

import com.example.pradeep.picpose.model.Pose;

import java.util.ArrayList;

/**
 * Created by pradeep on 22/7/17.
 */

public class MenPresenter implements MenModelInterface {

    private final MenModel mModel;
    private MenView menView;

    public MenPresenter(MenView menView) {
        this.menView = menView;
        this.mModel = new MenModel(this);
    }


    public void getPoseData(String poseType){
        // make web call for specific pose type
        mModel.makeWebCall(poseType);

    }

    @Override
    public void webCallSuccess(ArrayList<Pose> poses) {
            menView.onManCompleted(poses);
    }

    @Override
    public void webCallFail(int errorCode) {

    }
}
