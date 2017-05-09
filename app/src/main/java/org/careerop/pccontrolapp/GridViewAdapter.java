package org.careerop.pccontrolapp;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.List;

/**
 * Created by JuyelRana on 17/05/09.
 */

public class GridViewAdapter extends BaseAdapter {
    private Context context;
    private List<ImageId> imageIdList;
    private LayoutInflater inflater;

    public GridViewAdapter(Context context, List<ImageId> imageIdList) {
        this.context = context;
        this.imageIdList = imageIdList;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return imageIdList.size();
    }

    @Override
    public Object getItem(int position) {
        return imageIdList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.single_grid, null);
        }

        final ProgressBar progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.listViewImage);
        TextView txtId = (TextView) convertView.findViewById(R.id.txtId);

        ImageLoader.getInstance().displayImage(imageIdList.get(position).getImage(), imageView, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                progressBar.setVisibility(view.VISIBLE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                progressBar.setVisibility(view.GONE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                progressBar.setVisibility(view.GONE);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                progressBar.setVisibility(view.GONE);
            }
        });

        txtId.setText(imageIdList.get(position).getId());

        return convertView;
    }
}
