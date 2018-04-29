package com.horizontemovil.municiapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.horizontemovil.municiapp.R;
import com.horizontemovil.municiapp.adapters.CustomersAdapter;
import com.horizontemovil.municiapp.models.Customer;
import com.horizontemovil.municiapp.services.CustomersService;


import java.util.List;



public class CustomerFragment extends Fragment {

    public CustomerFragment() {
        // CustomerFragment empty public constructor
    }


    List<Customer> customers;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        CustomersService customersInner = new CustomersService(this);
        customers = customersInner.getCustomers();
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_customer, container, false);
        RecyclerView rv = (RecyclerView) rootView.findViewById(R.id.customers_recycler_view);
        rv.setHasFixedSize(true);
        CustomersAdapter adapter = new CustomersAdapter();
        adapter.setCustomers(customers);
        rv.setAdapter(adapter);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(llm);
        return rootView;
    }


}
