package com.example.xavier.tp1;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Epulapp on 01/12/2017.
 */
public class Download extends AsyncTask<Beer, Void, Bitmap> {

    Beer b = null;

    @Override
    protected Bitmap doInBackground(Beer... params) {
        this.b = params[0];

        Bitmap bm = b.getBm();

        if (bm == null) {
            bm = download_Image(b.getImageUrl());
        }

        return bm;
    }

    @Override
    protected void onPostExecute(Bitmap result) {
        b.setBm(result);
    }

    private Bitmap download_Image(String url) {
        Bitmap bm = null;
        try {
            URL aURL = new URL(url);
            URLConnection conn = aURL.openConnection();
            conn.connect();
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();
        } catch (IOException e) {
            Log.e("Img","Error getting the image from server : " + e.getMessage().toString());
        }
        return bm;
    }

}