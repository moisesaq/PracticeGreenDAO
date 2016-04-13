package com.apaza.moises.practicegreendao.login;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.apaza.moises.practicegreendao.R;
import com.bumptech.glide.Glide;

import me.relex.circleindicator.CircleIndicator;

public class SignUpFragment extends Fragment {

    private static final String ARG_PARAM1 = "param1";
    private String mParam1;

    private View view;
    private ViewPager viewPager;
    private Button btnSignUp;

    private ImagePageAdapter imagePageAdapter;
    private CircleIndicator circleIndicator;

    public int[] mResources = {R.drawable.vegeta, R.drawable.goku, R.drawable.buu};

    private OnFragmentSignUpListener mListener;

    public static SignUpFragment newInstance() {
        SignUpFragment fragment = new SignUpFragment();
        return fragment;
    }

    public SignUpFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        setup();
        return view;
    }

    private void setup(){
        viewPager = (ViewPager)view.findViewById(R.id.viewPagerSignUp);
        imagePageAdapter = new ImagePageAdapter(getActivity().getApplicationContext());
        viewPager.setAdapter(imagePageAdapter);

        circleIndicator = (CircleIndicator)view.findViewById(R.id.indicator);
        circleIndicator.setViewPager(viewPager);
        btnSignUp = (Button) view.findViewById(R.id.signup);
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mListener.onSignUpClick();
            }
        });
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onSignUpClick();
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentSignUpListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentSignUpListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentSignUpListener {
        void onSignUpClick();
    }

    public class ImagePageAdapter extends PagerAdapter{

        private Context context;
        public ImagePageAdapter(Context context){
            this.context = context;
        }

        @Override
        public int getCount() {
            return mResources.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return (view == (FrameLayout)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View view = inflater.inflate(R.layout.pager_layout, container, false);
            ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
            //imageView.setImageResource(mResources[position]);
            Glide.with(getActivity())
                    .load(mResources[position])
                    .centerCrop()
                    .into(imageView);

            container.addView(view);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((FrameLayout)object);
        }
    }

}
