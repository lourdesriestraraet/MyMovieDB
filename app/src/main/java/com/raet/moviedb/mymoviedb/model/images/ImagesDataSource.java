package com.raet.moviedb.mymoviedb.model.images;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.support.v4.content.res.ResourcesCompat;
import android.widget.ImageView;

import com.raet.moviedb.mymoviedb.R;
import com.squareup.picasso.Picasso;

/**
 * Created by lourdes on 4/11/16.
 */

public class ImagesDataSource {
    private static final String END_POINT_IMAGES = "https://image.tmdb.org/t/p/w500";

    private static ImagesDataSource imagesDataSource;
    private static Drawable myErrorImageView;


    public static ImagesDataSource getInstance() {
        if (imagesDataSource == null) {
            imagesDataSource = new ImagesDataSource();
        }
        return imagesDataSource;
    }

    public static void putImage(Context context, String path, ImageView container) {
        if (myErrorImageView == null) {
            myErrorImageView = ResourcesCompat.getDrawable(context.getResources(), R.drawable.ic_alert, null);
            myErrorImageView.setColorFilter(ResourcesCompat.getColor(context.getResources(), R.color.colorAccent, null), PorterDuff.Mode.MULTIPLY);
        }
        Picasso.with(context).load(END_POINT_IMAGES + path)
                .error(myErrorImageView)
                .into(container);
    }

}
