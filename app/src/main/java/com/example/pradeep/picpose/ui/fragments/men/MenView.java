package com.example.pradeep.picpose.ui.fragments.men;

import com.example.pradeep.picpose.model.Pose;

import java.util.ArrayList;

/**
 * Created by pradeep on 22/7/17.
 */

public interface MenView {

    void onManCompleted(ArrayList<Pose> poses);
    void onManFail(String errorMsg);
}
