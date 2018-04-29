package com.horizontemovil.municiapp.adapters;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.horizontemovil.municiapp.R;
import com.horizontemovil.municiapp.fragments.CustomerDetailFragment;
import com.horizontemovil.municiapp.models.Customer;

import java.util.List;

/**
 * Created by Joel on 0022 22/03/2018.
 */

public class CustomersAdapter extends RecyclerView.Adapter<CustomersAdapter.ViewHolder> {
    List<Customer> customers;
    public void setCustomers(List<Customer> customers) { this.customers = customers; }

    @Override
    public CustomersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_customer, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }
    @Override
    public void onBindViewHolder(CustomersAdapter.ViewHolder holder, final int position) {

        holder.pictureImageView.setImageResource(customers.get(position).getPictureId());
        holder.nameTextView.setText(customers.get(position).getName());
        holder.serviceTextView.setText(customers.get(position).getService());
        holder.customerCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle = new Bundle();
                bundle.putInt("currentPosition", position);
                AppCompatActivity activity = (AppCompatActivity) view.getContext();
                android.support.v4.app.Fragment fr=new CustomerDetailFragment();
                fr.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fr).addToBackStack(null).commit();
            }
        });
    }
    @Override
    public int getItemCount() {
        return customers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CardView customerCardView;
        ImageView pictureImageView;
        TextView nameTextView;
        TextView serviceTextView;

        public ViewHolder(View itemView) {
            super(itemView);
            customerCardView = (CardView) itemView.findViewById(R.id.customer_list_card_view);
            pictureImageView = (ImageView) itemView.findViewById(R.id.picture_image_view);
            nameTextView = (TextView) itemView.findViewById(R.id.name_text_view);
            serviceTextView = (TextView) itemView.findViewById(R.id.service_text_view);
        }
    }




}
