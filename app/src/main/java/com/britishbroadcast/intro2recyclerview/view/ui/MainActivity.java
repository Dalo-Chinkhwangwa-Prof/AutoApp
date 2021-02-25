package com.britishbroadcast.intro2recyclerview.view.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import com.britishbroadcast.intro2recyclerview.R;
import com.britishbroadcast.intro2recyclerview.model.Car;
import com.britishbroadcast.intro2recyclerview.view.adapter.CarAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements CarAdapter.CarDelegate {


    private RecyclerView carRecyclerView;
    private CarFragment carFragment = new CarFragment();

    private List<Car> carList = new ArrayList<>(
            Arrays.asList(
                    new Car("Mercedes Benz", "E250", 2015),
                    new Car("Toyota", "Land-Cruiser Prado", 2020),
                    new Car("Bugatti", "Veyron", 2011),
                    new Car("Ford", "Mustang", 2017),
                    new Car("Porche", "Carrera GT", 2014),
                    new Car("Mercedes Benz", "S500", 2018),
                    new Car("Jaguar", "G-Type", 2021),
                    new Car("Lamborghini", "Aventador", 2014),
                    new Car("Bentley", "Intercontinental - GT", 2015),
                    new Car("BMW", "M3", 2018),
                    new Car("Ferrari", "F50", 2013),
                    new Car("Tesla", "Model X", 2019)
            )
    );

    private CarAdapter carAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        carRecyclerView = findViewById(R.id.main_recyclerview);
        carAdapter = new CarAdapter(carList, this);
        carRecyclerView.setAdapter(carAdapter);
        // carFragment = (CarFragment) getSupportFragmentManager().findFragmentById(R.id.main_fragment);
    }

    @Override
    public void selectCar(Car selectedCar) {

        //carFragment.updateInfo(selectedCar);

        Log.d("TAG_X", "Car Selected " + selectedCar.getModel());

        Bundle bundle = new Bundle();
        bundle.putSerializable("CAR_KEY", selectedCar);
        carFragment.setArguments(bundle);

        getSupportFragmentManager()
                .beginTransaction()
                .setCustomAnimations(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right
                )
                .add(R.id.main_frame, carFragment)
                .addToBackStack(carFragment.getTag())
                .commit();

    }
}