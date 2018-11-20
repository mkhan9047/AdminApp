package com.teammanagement.adminapp.View.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.teammanagement.adminapp.R;

public class AbsentEmployeeRecyclerAdapter extends RecyclerView.Adapter<AbsentEmployeeRecyclerAdapter.AbsentEmployeeHolder> {

    @NonNull
    @Override
    public AbsentEmployeeHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.absent_employee_recyler_row, parent, false);
        return new AbsentEmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AbsentEmployeeHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class AbsentEmployeeHolder extends RecyclerView.ViewHolder {

        public AbsentEmployeeHolder(View itemView) {
            super(itemView);
        }
    }
}
