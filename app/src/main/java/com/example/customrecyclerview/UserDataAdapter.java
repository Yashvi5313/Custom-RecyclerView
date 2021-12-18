package com.example.customrecyclerview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserDataAdapter extends RecyclerView.Adapter<UserDataAdapter.ViewHolder> {
    ArrayList<UserDataItem> userDataItemArrayList = new ArrayList<>();
    Context c;
    UserDataItem[] userDataItems;

    public UserDataAdapter(Context c, UserDataItem[] userDataItems) {
        this.userDataItems = userDataItems;
        userDataItemArrayList.clear();
        this.c = c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View usercard = layoutInflater.inflate(R.layout.userdata, parent, false);
        UserDataAdapter.ViewHolder viewHolder = new UserDataAdapter.ViewHolder(usercard);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        final UserDataItem userDataItem = userDataItems[position];

        if (userDataItem.isSelected()) {
            holder.liner.setBackgroundColor(Color.parseColor("#567845"));
        } else {
            holder.liner.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        holder.idName.setText(userDataItem.getUserName());
        holder.idGender.setText(userDataItem.getGender());
        holder.idMobileNo.setText(userDataItem.getMobileNo());
        holder.imgProfile.setImageResource(userDataItem.getImage());
        holder.liner.setSelected(userDataItem.isSelected());

        holder.liner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userDataItem.isSelected()) {
                    userDataItem.setSelected(false);
                    holder.liner.setBackgroundColor(Color.parseColor("#567845"));
                    userDataItemArrayList.remove(userDataItem);

                } else {
                   userDataItem.setSelected(true);
                    holder.liner.setBackgroundColor(Color.parseColor("#ffffff"));
                    userDataItemArrayList.add(userDataItem);
                }
                notifyDataSetChanged();
            }
        });

    }


//        holder.checkbox.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                if (holder.checkbox.isChecked()) {
//                    userDataItem.setSelected(true);
//                    userDataItemArrayList.add(userDataItem);
//                } else if (!holder.checkbox.isChecked()) {
//                    userDataItem.setSelected(false);
//                    userDataItemArrayList.remove(userDataItem);
//                }
//                selectedPosition=position;
//                notifyDataSetChanged();
//            }
//        });
//}

    @Override
    public int getItemCount() {
        return userDataItems.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView idName;
        public TextView idGender;
        public TextView idMobileNo;
        public ImageView imgProfile;
        //public CheckBox checkbox;
        LinearLayout liner;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.idName = (TextView) itemView.findViewById(R.id.idName);
            this.idGender = (TextView) itemView.findViewById(R.id.idGender);
            this.idMobileNo = (TextView) itemView.findViewById(R.id.idMobileNo);
            this.imgProfile = (ImageView) itemView.findViewById(R.id.imgProfile);
            liner = (LinearLayout) itemView.findViewById(R.id.liner);
            //this.checkbox = (CheckBox) itemView.findViewById(R.id.checkbox);
        }
    }
}
