package com.putrindaru.ligaprimeringgris;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


public class HomeFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<HomeItems>> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listView;
    HomeAdapter adapter;

//    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment( );
        Bundle args = new Bundle( );
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments( ) != null) {
            mParam1 = getArguments( ).getString(ARG_PARAM1);
            mParam2 = getArguments( ).getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        adapter = new HomeAdapter(getContext());
        adapter.notifyDataSetChanged();


        listView = (ListView) view.findViewById(R.id.listHome);

        listView.setAdapter(adapter);

        Bundle bundle = new Bundle();

        getLoaderManager().initLoader(0, null, this);
        return view;
    }

    @NonNull
    @Override
    public Loader<ArrayList<HomeItems>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new HomeAsyncTaskLoader(getContext());
    }


    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<HomeItems>> loader, ArrayList<HomeItems> homeItems) {
        adapter.setData(homeItems);
    }


    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<HomeItems>> loader) {
        adapter.setData(null);
    }

}
