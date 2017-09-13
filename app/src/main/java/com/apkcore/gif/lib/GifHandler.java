package com.apkcore.gif.lib;

import android.graphics.Bitmap;

/**
 * Created by apkcore on 17-9-13.
 */

public class GifHandler {
    private long gifAddr;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("apkcore-giflib");
    }
    public  GifHandler(String path) {
        this.gifAddr  = loadPath(path);
    }

    private native long loadPath(String path);

    private native int getWidth(long ndkGif);

    private native int getHeight(long ndkGif);

    private native int updateFrame(long ndkGif, Bitmap bitmap);

    public int getWidth(){
        return getWidth(gifAddr);
    }

    public int getHeight(){
        return getHeight(gifAddr);
    }

    public int updateFrame(Bitmap bitmap){
        return updateFrame(gifAddr,bitmap);
    }
}
