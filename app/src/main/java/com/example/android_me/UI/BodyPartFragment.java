package com.example.android_me.UI;

import android.media.ImageReader;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    public static final String TAG="fragment";
    public static final String IMAGE_ID_LIST="image_ids";
    public static final String LIST_INDEX="list_index";
    public BodyPartFragment(){}
    private List<Integer> mImageids;
    private  int mListIndex;


    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        if (savedInstanceState!=null){
            mImageids=savedInstanceState.getIntegerArrayList(IMAGE_ID_LIST);
            mListIndex=savedInstanceState.getInt(LIST_INDEX);
        }
        View rootview=inflater.inflate(R.layout.fragment_body_part,container,false);
        final ImageView imageview=(ImageView) rootview.findViewById(R.id.body_part_image_view);
        if (mImageids!=null){
            imageview.setImageResource(mImageids.get(mListIndex));
            imageview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListIndex<mImageids.size()-1){
                        mListIndex++;
                }
                    else{
                        mListIndex=0;
                    }
                    imageview.setImageResource(mImageids.get(mListIndex));
            }
            });
        }
        else{
            Log.d(TAG, "onCreateView: list is null");
        }


        return rootview;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putIntegerArrayList(IMAGE_ID_LIST,(ArrayList<Integer>) mImageids);
        outState.putInt(LIST_INDEX,mListIndex);
    }

    public void setimageIds(List<Integer> imageids){
        mImageids=imageids;
    }
    public void setmListIndex(int index){
        mListIndex=index;
    }
}
