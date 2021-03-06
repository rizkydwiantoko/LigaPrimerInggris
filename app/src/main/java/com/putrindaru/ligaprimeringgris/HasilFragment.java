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


public class HasilFragment extends Fragment implements LoaderManager.LoaderCallbacks<ArrayList<HasilItems>> {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView listView;
    HasilAdapter adapter;

//    private OnFragmentInteractionListener mListener;

    public HasilFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static HasilFragment newInstance(String param1, String param2) {
        HasilFragment fragment = new HasilFragment( );
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
        View view = inflater.inflate(R.layout.fragment_hasil, container, false);
        adapter = new HasilAdapter(getContext());
        adapter.notifyDataSetChanged();


        listView = (ListView) view.findViewById(R.id.listHasil);

        listView.setAdapter(adapter);

        Bundle bundle = new Bundle();

        getLoaderManager().initLoader(0, null, this);
        return view;
    }

    @NonNull
    @Override
    public Loader<ArrayList<HasilItems>> onCreateLoader(int i, @Nullable Bundle bundle) {
        return new HasilAsyncTaskLoader(getContext());
    }


    @Override
    public void onLoadFinished(@NonNull Loader<ArrayList<HasilItems>> loader, ArrayList<HasilItems> hasilItems) {
        adapter.setData(hasilItems);
    }


    @Override
    public void onLoaderReset(@NonNull Loader<ArrayList<HasilItems>> loader) {
        adapter.setData(null);
    }

}
