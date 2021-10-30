package com.example.android_me.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.android_me.R;
import com.example.android_me.UI.BodyPartFragment;
import com.example.android_me.data.AndroidImageAssets;

public class Android_meActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);
        if (savedInstanceState==null) {
            Intent intent=getIntent();
            Bundle b=intent.getExtras();
            int headindex,bodyindex,legindex;
            headindex=b.getInt("Headinteger");
            bodyindex=b.getInt("bodyinteger");
            legindex=b.getInt("leginteger");
            String TAG="eror";
            BodyPartFragment headfragment = new BodyPartFragment();
            headfragment.setimageIds(AndroidImageAssets.getHeads());
            headfragment.setmListIndex(headindex);
            Log.d(TAG, "onCreate is: "+headindex);
            getSupportFragmentManager().beginTransaction().add(R.id.head_container, headfragment).commit();

            BodyPartFragment bodyfragment = new BodyPartFragment();
            bodyfragment.setimageIds(AndroidImageAssets.getBodies());
            bodyfragment.setmListIndex(bodyindex);
//        FragmentManager fragmentManager=getSupportFragmentManager();
            getSupportFragmentManager().beginTransaction().add(R.id.body_container, bodyfragment).commit();
//
            BodyPartFragment legfragment = new BodyPartFragment();
            legfragment.setimageIds(AndroidImageAssets.getLegs());
            legfragment.setmListIndex(legindex);
////        FragmentManager fragmentManager=getSupportFragmentManager();
            getSupportFragmentManager().beginTransaction().add(R.id.leg_container, legfragment).commit();
        }

    }
}