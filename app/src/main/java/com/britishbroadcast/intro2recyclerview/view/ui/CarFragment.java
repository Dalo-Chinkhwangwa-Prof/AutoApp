package com.britishbroadcast.intro2recyclerview.view.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.britishbroadcast.intro2recyclerview.R;
import com.britishbroadcast.intro2recyclerview.model.Car;

public class CarFragment extends Fragment {

    private TextView carNameTextView, carYearTextView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.car_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        carNameTextView = view.findViewById(R.id.car_name_textview);
        carYearTextView = view.findViewById(R.id.car_release_textview);

        Bundle bundle = getArguments();
        if(bundle != null){
            Car car = (Car) bundle.getSerializable("CAR_KEY");
            updateInfo(car);
        }

        Log.d("TAG_X", "onViewCreated....!");

    }

    public void updateInfo(Car car){
        carNameTextView.setText(car.getManufacturer() + ": " + car.getModel());
        carYearTextView.setText("Released: " + car.getReleaseYear());
    }


}
