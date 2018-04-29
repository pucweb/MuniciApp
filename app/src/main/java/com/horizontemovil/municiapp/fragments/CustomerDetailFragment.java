package com.horizontemovil.municiapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.horizontemovil.municiapp.R;
import com.horizontemovil.municiapp.models.Customer;
import com.horizontemovil.municiapp.services.CustomersService;

public class CustomerDetailFragment extends Fragment {


    public CustomerDetailFragment() {
        // Required empty public constructor
    }

    TextView nameTextView;
    TextView contactTextView;
    TextView addressTextView;
    ImageView pictureImageView;
    Bundle bundleSend;
    Customer customer;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Carga del detalle del cliente seleccionado
        View rootView = inflater.inflate(R.layout.fragment_customer_detail, null);
        pictureImageView = (ImageView) rootView.findViewById(R.id.picture_image_view);
        nameTextView = (TextView) rootView.findViewById(R.id.name_dt_text_view);
        contactTextView = (TextView) rootView.findViewById(R.id.contact_dt_text_view);
        addressTextView = (TextView) rootView.findViewById(R.id.address_dt_text_view);
        CustomersService serviceWorker = new CustomersService(this);
        Bundle bundle = getArguments();
        customer = serviceWorker.getCustomers().get(bundle.getInt("currentPosition"));
        pictureImageView.setImageResource(customer.getPictureId());
        nameTextView.setText(customer.getName());
        contactTextView.setText(customer.getContact());
        addressTextView.setText(customer.getAddress());
        Button button = (Button) rootView.findViewById(R.id.go_map_dt_btn);
        button.setOnClickListener(mButtonCustomerDetailMap);

        return rootView;
    }
private View.OnClickListener mButtonCustomerDetailMap= new View.OnClickListener(){
        @Override
        public void onClick(View v)
        {
            //Envio de datos del cliente seleccionado e invoacion del fragmento de mapa
            bundleSend = new Bundle();
            bundleSend.putDouble("clientLatitude", customer.getGeoLatitude());
            bundleSend.putDouble("clientLongitude", customer.getGeoLongitude());
            bundleSend.putString("clientName", customer.getName());
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            android.support.v4.app.Fragment fr=new MapsFragment();
            fr.setArguments(bundleSend);
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fr).addToBackStack(null).commit();

        }
    };


}
