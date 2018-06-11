package com.litetech.libs.nonswipeableviewpager;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
@SuppressWarnings("all")
public class BlankFragment extends Fragment {

    public static BlankFragment newInstance(String fragmentId) {

        Bundle args = new Bundle();

        BlankFragment fragment = new BlankFragment();
        args.putString("id",fragmentId);
        fragment.setArguments(args);
        return fragment;
    }

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.blank, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        AppCompatTextView tv = view.findViewById(R.id.tv);

        tv.setText(getArguments().getString("id"));
    }
}
