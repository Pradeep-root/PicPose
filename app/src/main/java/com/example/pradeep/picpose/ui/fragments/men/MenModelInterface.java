package com.example.pradeep.picpose.ui.fragments.men;

import com.example.pradeep.picpose.model.Pose;

import java.util.ArrayList;

/**
 * Created by pradeep on 22/7/17.
 */

public interface MenModelInterface {

    void webCallSuccess(ArrayList<Pose> poses);
    void webCallFail(int errorCode);
}
