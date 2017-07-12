package com.example.litain23.weather;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentLongti extends Fragment {


    public FragmentLongti() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_longti, container, false);
        String[] listLongti = getResources().getStringArray(R.array.list_value_longti);
        View view = inflater.inflate(R.layout.fragment_longti, null);
        ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, listLongti);

        ListView listView = (ListView) view.findViewById(R.id.list_longti);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(onItemClickListener);

        return view;
    }
    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            String getLongti = (String)adapterView.getItemAtPosition(i);

            EditText editText = getActivity().findViewById(R.id.edittext_longti);
            editText.setText(getLongti);
        }
    };

}

