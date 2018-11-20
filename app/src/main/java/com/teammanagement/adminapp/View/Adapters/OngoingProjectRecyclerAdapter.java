package com.teammanagement.adminapp.View.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.teammanagement.adminapp.Model.Projects;
import com.teammanagement.adminapp.R;

import java.util.ArrayList;
import java.util.List;

public class OngoingProjectRecyclerAdapter extends RecyclerView.Adapter<OngoingProjectRecyclerAdapter.OngoingProjectHolder> {

    private List<Projects> projectsList = new ArrayList<>();

    @NonNull
    @Override
    public OngoingProjectHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ongoing_project_recycler_row, parent, false);

        return new OngoingProjectHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OngoingProjectHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 4;
    }


    class OngoingProjectHolder extends RecyclerView.ViewHolder {

        TextView projectName, projectStatus, start_date, end_date;


        public OngoingProjectHolder(View itemView) {

            super(itemView);

            projectName = itemView.findViewById(R.id.project_name);
            projectStatus = itemView.findViewById(R.id.project_status);
            start_date = itemView.findViewById(R.id.start_date);
            end_date = itemView.findViewById(R.id.end_date);

        }
    }
}
