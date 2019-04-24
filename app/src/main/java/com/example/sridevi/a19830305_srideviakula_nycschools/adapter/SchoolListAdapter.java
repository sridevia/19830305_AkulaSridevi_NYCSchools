package com.example.sridevi.a19830305_srideviakula_nycschools.adapter;

import android.annotation.SuppressLint;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.example.sridevi.a19830305_srideviakula_nycschools.R;
import com.example.sridevi.a19830305_srideviakula_nycschools.view.RecyclerItemClickListener;
import com.example.sridevi.a19830305_srideviakula_nycschools.model.SchoolListItem;

import java.util.ArrayList;

public class SchoolListAdapter extends RecyclerView.Adapter<SchoolListAdapter.EmployeeViewHolder> {

    private ArrayList<SchoolListItem> dataList;
    private RecyclerItemClickListener recyclerItemClickListener;

    public SchoolListAdapter(ArrayList<SchoolListItem> dataList , RecyclerItemClickListener recyclerItemClickListener) {
        this.dataList = dataList;
        this.recyclerItemClickListener = recyclerItemClickListener;
    }


    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.single_view_row, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        holder.txtNoticeTitle.setText(dataList.get(position).getSchoolName());
        holder.txtNoticeBrief.setText(dataList.get(position).getLocation());
        holder.txtNoticeFilePath.setText(dataList.get(position).getCity());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerItemClickListener.onItemClick(dataList.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    class EmployeeViewHolder extends RecyclerView.ViewHolder {

        TextView txtNoticeTitle, txtNoticeBrief, txtNoticeFilePath;

        EmployeeViewHolder(View itemView) {
            super(itemView);
            txtNoticeTitle =  itemView.findViewById(R.id.txt_notice_title);
            txtNoticeBrief =  itemView.findViewById(R.id.txt_notice_brief);
            txtNoticeFilePath =  itemView.findViewById(R.id.txt_notice_file_path);

        }
    }
}