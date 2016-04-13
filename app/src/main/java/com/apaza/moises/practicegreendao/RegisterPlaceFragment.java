package com.apaza.moises.practicegreendao;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.apaza.moises.practicegreendao.database.Place;
import com.apaza.moises.practicegreendao.database.PlaceDao;
import com.apaza.moises.practicegreendao.database.User;
import com.apaza.moises.practicegreendao.database.UserDao;

public class RegisterPlaceFragment extends Fragment implements View.OnClickListener{

    private View view;
    private EditText etName, etAddress, etDescription, etUserName;
    private Button register;
    private Crud crud;
    private PlaceDao placeDao;
    private UserDao userDao;

    public static RegisterPlaceFragment newInstance() {
        RegisterPlaceFragment fragment = new RegisterPlaceFragment();
        return fragment;
    }

    public RegisterPlaceFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_register_place, container, false);
        setup();
        return view;
    }

    private void setup(){
        crud = Crud.getInstance(getActivity());
        placeDao = crud.getDaoSession().getPlaceDao();
        userDao = crud.getDaoSession().getUserDao();

        etName = (EditText)view.findViewById(R.id.etName);
        etDescription = (EditText)view.findViewById(R.id.etDescription);
        etAddress = (EditText)view.findViewById(R.id.etAddress);
        etUserName = (EditText)view.findViewById(R.id.etUserName);
        register = (Button)view.findViewById(R.id.register);
        register.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        try{
            if(v.getId() == register.getId()){
                long userId = userDao.insert(getNewUserOfView());
                placeDao.insert(getNewPlaceOfView(userId));
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Place getNewPlaceOfView(long userId){
        Place place = new Place();
        place.setName(etName.getText().toString());
        place.setAddress(etAddress.getText().toString());
        place.setDescription(etDescription.getText().toString());
        place.setUserId(userId);

        return place;
    }

    public User getNewUserOfView(){
        User user = new User();
        user.setFullName(etUserName.getText().toString());
        return user;
    }
}
