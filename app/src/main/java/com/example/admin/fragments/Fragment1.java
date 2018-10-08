package com.example.admin.fragments;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Fragment1 extends Fragment {

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i("onAttach", "called");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("onCreate", "called");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_one, container, false);
        Log.i("onAttach", "called");
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i("onActivityCreated", "called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("onPause", "called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i("onResume", "called");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i("onStart", "called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("onStop", "called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i("onAttach", "called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("onDestroy", "called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i("onDestroyView", "called");
    }
}