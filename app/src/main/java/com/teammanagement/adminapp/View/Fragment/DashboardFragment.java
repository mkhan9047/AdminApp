package com.teammanagement.adminapp.View.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.teammanagement.adminapp.R;
import com.teammanagement.adminapp.View.Adapters.AbsentEmployeeRecyclerAdapter;
import com.teammanagement.adminapp.View.Adapters.DashboardRecyclerAdapter;
import com.teammanagement.adminapp.View.Adapters.OngoingProjectRecyclerAdapter;

/**
 * A simple {@link Fragment} subclass.
 *
 */
public class DashboardFragment extends Fragment {


    RecyclerView dashboardRecycler;
    RecyclerView ongoingRecycler, absentEmployeeRecycler;

    public DashboardFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_dashboard, container, false);
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        initViews();

        setOptionsToDashboardRecycler();
        setOptionsToOngoingRecycler();
        setOptionsToAbsentEmployeeRecycler();

    }

    private void initViews() {

        View view = getView();
        if (view != null) {

            dashboardRecycler = view.findViewById(R.id.dashboard_recycler);
            ongoingRecycler = view.findViewById(R.id.ongoing_recycler);
            absentEmployeeRecycler = view.findViewById(R.id.absent_employee_recycler);


        }

    }

    private void setOptionsToDashboardRecycler() {
        dashboardRecycler.setHasFixedSize(true);
        dashboardRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        DashboardRecyclerAdapter dashboardRecyclerAdapter = new DashboardRecyclerAdapter();
        dashboardRecycler.setAdapter(dashboardRecyclerAdapter);

    }

    private void setOptionsToOngoingRecycler() {
        ongoingRecycler.setHasFixedSize(true);
        ongoingRecycler.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        OngoingProjectRecyclerAdapter ongoingProjectRecyclerAdapter = new OngoingProjectRecyclerAdapter();
        ongoingRecycler.setAdapter(ongoingProjectRecyclerAdapter);

    }

    private void setOptionsToAbsentEmployeeRecycler() {
        absentEmployeeRecycler.setHasFixedSize(true);
        absentEmployeeRecycler.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        AbsentEmployeeRecyclerAdapter dashboardRecyclerAdapter = new AbsentEmployeeRecyclerAdapter();
        absentEmployeeRecycler.setAdapter(dashboardRecyclerAdapter);

    }

}
