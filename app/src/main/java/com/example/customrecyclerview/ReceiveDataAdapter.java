package com.example.customrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ReceiveDataAdapter extends RecyclerView.Adapter<ReceiveDataAdapter.ViewHolder> {
    List<UserDataItem> userList;

    public ReceiveDataAdapter(List<UserDataItem> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View usercard = layoutInflater.inflate(R.layout.receivedata, parent, false);
        ReceiveDataAdapter.ViewHolder viewHolder = new ReceiveDataAdapter.ViewHolder(usercard);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final UserDataItem userDataItem = userList.get(position);
        holder.Name.setText(userDataItem.getUserName());
        holder.Gender.setText(userDataItem.getGender());
        holder.MobileNo.setText(userDataItem.getMobileNo());
        holder.Profile.setImageResource(userDataItem.getImage());
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView Name;
        public TextView Gender;
        public TextView MobileNo;
        public ImageView Profile;
        LinearLayout linerlayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.Name = (TextView) itemView.findViewById(R.id.Name);
            this.Gender = (TextView) itemView.findViewById(R.id.Gender);
            this.MobileNo = (TextView) itemView.findViewById(R.id.MobileNo);
            this.Profile = (ImageView) itemView.findViewById(R.id.Profile);
            linerlayout = (LinearLayout) itemView.findViewById(R.id.linerlayout);
        }
    }
}
