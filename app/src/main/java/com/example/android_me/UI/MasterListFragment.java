package com.example.android_me.UI;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;

public class MasterListFragment extends Fragment {
    OnImageClickListener mCalback;
    public interface OnImageClickListener{
        void onImageSelected(int position);
    }

    @Override
    public void onAttach( Context context) {
        super.onAttach(context);
        try {
            mCalback=(OnImageClickListener) context;
            }
        catch (ClassCastException e){
            throw new ClassCastException(context.toString()+"must implement onclicllistner");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.fragment_master_list,container,false);
        GridView gridview=(GridView) rootview.findViewById(R.id.body_pasrts_grid_view);

        MasterListAdapter adapter = new MasterListAdapter(getContext(), AndroidImageAssets.getAll());
        gridview.setAdapter(adapter);
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCalback.onImageSelected(position);
            }
        });

        return  rootview;
    }

}
