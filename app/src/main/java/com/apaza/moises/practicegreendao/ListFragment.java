package com.apaza.moises.practicegreendao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.apaza.moises.practicegreendao.database.Place;
import com.apaza.moises.practicegreendao.database.PlaceDao;
import com.apaza.moises.practicegreendao.database.UserDao;

import java.util.List;


public class ListFragment extends Fragment {

    private View view;
    private ListView list;
    private ArrayAdapter<Place> arrayAdapter;

    private Crud crud;
    private PlaceDao placeDao;

    public static ListFragment newInstance() {
        ListFragment fragment = new ListFragment();
        return fragment;
    }

    public ListFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list, container, false);
        setup();
        return view;
    }

    private void setup(){
        crud = Crud.getInstance(getActivity());
        placeDao = crud.getDaoSession().getPlaceDao();

        list = (ListView)view.findViewById(R.id.list);
        arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1);
        list.setAdapter(arrayAdapter);
        Log.d("LENGHT LIST >>> ", " >>>>> "+placeDao.queryBuilder().list().size());
        arrayAdapter.addAll(placeDao.queryBuilder().list());
        arrayAdapter.notifyDataSetChanged();
    }
}
