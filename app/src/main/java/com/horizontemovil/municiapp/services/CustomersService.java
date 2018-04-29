package com.horizontemovil.municiapp.services;

import android.support.v4.app.Fragment;
import android.content.res.Resources;

import com.horizontemovil.municiapp.R;
import com.horizontemovil.municiapp.models.Customer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joel on 0022 22/03/2018.
 */

public class CustomersService {
    private List<Customer> customers;
    public List<Customer> getCustomers() { return customers; }

    public CustomersService(Fragment context) {
        Resources res = context.getResources();
        customers = new ArrayList<>();
        customers.add(new Customer(context.getString(R.string.name_1),
                context.getString(R.string.service_1),
                context.getString(R.string.contact_1),
                context.getString(R.string.address_1),
                Double.parseDouble( context.getString(R.string.latitude_1)),
                Double.parseDouble( context.getString(R.string.longitude_1)),
                R.drawable.customer_1));
        customers.add(new Customer(context.getString(R.string.name_2),
                context.getString(R.string.service_2),
                context.getString(R.string.contact_2),
                context.getString(R.string.address_2),
                Double.parseDouble( context.getString(R.string.latitude_2)),
                Double.parseDouble( context.getString(R.string.longitude_2)),
                R.drawable.customer_2));
        customers.add(new Customer(context.getString(R.string.name_3),
                context.getString(R.string.service_3),
                context.getString(R.string.contact_3),
                context.getString(R.string.address_3),
                Double.parseDouble( context.getString(R.string.latitude_3)),
                Double.parseDouble( context.getString(R.string.longitude_3)),
                R.drawable.customer_3));
        customers.add(new Customer(context.getString(R.string.name_4),
                context.getString(R.string.service_4),
                context.getString(R.string.contact_4),
                context.getString(R.string.address_4),
                Double.parseDouble( context.getString(R.string.latitude_4)),
                Double.parseDouble( context.getString(R.string.longitude_4)),
                R.drawable.customer_4));


    }

}
