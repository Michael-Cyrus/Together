package com.michael.romance.config;

import com.michael.romance.bean.ImageBean;

import java.util.ArrayList;

/**
 * Created by Michael on 2018/4/26.
 */

public class DataServer {

    public static ArrayList<ImageBean> getImgData(){
        ArrayList<ImageBean> list = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            list.add(new ImageBean(i, Constant.SERVER_URL + "/pic/"+i+".jpg", "好看的照片" + i));
        }
        return list;
    }
}
