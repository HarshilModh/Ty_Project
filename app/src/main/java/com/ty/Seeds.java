package com.ty;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Seeds extends Fragment {
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_seeds,container,false);
        String strLang[]={"Mango","Apple","Banana","Guava","Papaya","Dragon Fruit","Kiwi","Watermelon"};
        ListView listView=(ListView) rootview.findViewById(R.id.seeds);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,strLang);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strdata= parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(),"Data is"+strdata,Toast.LENGTH_SHORT).show();
                if (strdata.equals("Mango")){
                    Intent intent=new Intent(getActivity(),Mango.class);
                    startActivity(intent);

                }
                if (strdata.equals("Apple")){
                    Intent intent=new Intent(getActivity(),Mango.class);
                    startActivity(intent);

                }
            }
        });
        return rootview;
    }
    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {

    }

}