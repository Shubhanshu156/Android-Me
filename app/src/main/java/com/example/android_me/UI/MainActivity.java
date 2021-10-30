package com.example.android_me.UI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.android_me.R;
import com.example.android_me.data.AndroidImageAssets;

public class MainActivity  extends AppCompatActivity implements MasterListFragment.OnImageClickListener{
    private int headindex;
    private  int bodyindex;
    private int legindex;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}
//        MasterListFragment mainfragment=new MasterListFragment();
//        getSupportFragmentManager().beginTransaction().add(R.id.master_list_fragment, mainfragment).commit();
//        getSupportFragmentManager().beginTransaction().add(main,R.layout.fragment_master_list).commit();
        public void onImageSelected(int position){

          String TAG="error";
        int bodypartnumber=position/12;
        int listindex=position-12*bodypartnumber;
        switch (bodypartnumber){
            case 0:headindex=listindex;
                Log.d(TAG, "onImageSelected: "+headindex);
            break;
            case 1:bodyindex=listindex;
            break;
            case 2:legindex=listindex;
            break;}
            Bundle b=new Bundle();
            b.putInt("Headinteger",headindex);
            b.putInt("bodyinteger",bodyindex);
            b.putInt("leginteger",legindex);
            Intent intent=new Intent(this, Android_meActivity.class);
            intent.putExtras(b);
            Button nextbutton=(Button) findViewById(R.id.next_button);
            nextbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(intent);
                }
            });
        }

//            Toast.makeText(this,"Position clicked"+position,Toast.LENGTH_SHORT).show();
        }


