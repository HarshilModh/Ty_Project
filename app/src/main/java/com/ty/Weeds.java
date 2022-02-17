package com.ty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Weeds extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_weeds,container,false);
        String strLang[]={"Python","Java","C","C++","Swift","Python","Java","C","C++","Swift","Python"};
        ListView listView=(ListView) rootview.findViewById(R.id.weeds);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,strLang);
        listView.setAdapter(arrayAdapter);

        return rootview;
    }
    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {

    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_weeds);
//        String strLang[]={"Python","Java","C","C++","Swift","Python","Java","C","C++","Swift","Python"};
//        listView=findViewById(R.id.weeds);
//        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,strLang);
//        listView.setAdapter(arrayAdapter);
//
//    }
}