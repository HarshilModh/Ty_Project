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

public class Weeds extends Fragment {


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.activity_weeds,container,false);
        String strLang[]={"crabgras","Purslane","Pigweed","ChickWeed","Dandellion","Shepard's Purse","Lambsquater","Creeping Charlie"};
        ListView listView=(ListView) rootview.findViewById(R.id.weeds);
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1,strLang);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String strdata= parent.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(),"Data is"+strdata,Toast.LENGTH_SHORT).show();
                if (strdata.equals("crabgras")){
                    Intent intent=new Intent(getActivity(),CrabGrass.class);
                    startActivity(intent);

                }
                if (strdata.equals("Purslane")){
                    Intent intent=new Intent(getActivity(),Purslane.class);
                    startActivity(intent);

                }
//                if (strdata.equals("Pigweed")){
//                    Intent intent=new Intent(getActivity(),Pigweed.class);
//                }
//                if (strdata.equals("ChickWeed")){
//                    Intent intent=new Intent(getActivity(),Chickweed.class);
//                }
//                if (strdata.equals("Dandellion")){
//                    Intent intent=new Intent(getActivity(),Dandellion.class);
//                }
//                if (strdata.equals("Shepard's Purse")){
//                    Intent intent=new Intent(getActivity(),Shepard.class);
//                }
//                if (strdata.equals("Lambsquater")){
//                    Intent intent=new Intent(getActivity(),Lambsquater.class);
//                }
//                if (strdata.equals("Creeping Charlie")){
//                    Intent intent=new Intent(getActivity(),CreepingCharlie.class);
//                }

               // Intent i=new Intent(ListActivity.this,displaylist.class);
               // i.putExtra("List_value",strdata);


            }
        });

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