package com.teammanagement.adminapp.View.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.teammanagement.adminapp.R;

import org.w3c.dom.Text;

public class DashboardRecyclerAdapter extends RecyclerView.Adapter<DashboardRecyclerAdapter.DashboardHolder> {

    private int[] dashboard_bg;
    private int count = 0;

    public DashboardRecyclerAdapter() {
        dashboard_bg = new int[3];
        dashboard_bg[0] = R.drawable.dashboard_recyler_bg_one;
        dashboard_bg[1] = R.drawable.dashboard_bg_two;
        dashboard_bg[2] = R.drawable.dashboard_bg_three;
    }

    @NonNull
    @Override
    public DashboardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.dashboard_recycler_row, parent, false);
        return new DashboardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DashboardHolder holder, int position) {

        count++;
        if (count == 3) {
            count = 0;
        }

        holder.layout.setBackgroundResource(dashboard_bg[count]);

    }

    @Override
    public int getItemCount() {
        return 15;
    }


    class DashboardHolder extends RecyclerView.ViewHolder {

        ImageView icon;
        TextView dash_content_name;
        TextView count;
        LinearLayout layout;

        public DashboardHolder(View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.dashboard_icon);
            dash_content_name = itemView.findViewById(R.id.content_name);
            count = itemView.findViewById(R.id.content_count);
            layout = itemView.findViewById(R.id.layout);
        }
    }
}
