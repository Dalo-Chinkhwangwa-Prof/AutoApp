package com.britishbroadcast.intro2recyclerview.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.britishbroadcast.intro2recyclerview.R;
import com.britishbroadcast.intro2recyclerview.model.Car;

import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarAdapter.CarViewHolder> {

    private List<Car> carList;
    private CarDelegate carDelegate;

    public CarAdapter(List<Car> carList, CarDelegate carDelegate) {
        this.carList = carList;
        this.carDelegate = carDelegate;
    }

    public interface CarDelegate {
        void selectCar(Car selectedCar);

    }

    @NonNull
    @Override
    public CarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.car_item_layout, parent, false);

        return new CarViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CarViewHolder holder, int position) {

        Car current = carList.get(position);

        holder.carModelTextView.setText(current.getModel());
        holder.releaseYearTextView.setText(current.getReleaseYear() + "");
        holder.carManufacturerTextView.setText(current.getManufacturer());

        holder.itemView.setOnClickListener(view -> {
                    carDelegate.selectCar(current);
                }
        );

    }

    @Override
    public int getItemCount() {
        return carList.size();
    }

    class CarViewHolder extends RecyclerView.ViewHolder {

        TextView carModelTextView;
        TextView carManufacturerTextView;
        TextView releaseYearTextView;

        public CarViewHolder(@NonNull View itemView) {
            super(itemView);
            carManufacturerTextView = itemView.findViewById(R.id.manufacturer_textview);
            releaseYearTextView = itemView.findViewById(R.id.release_year_textview);
            carModelTextView = itemView.findViewById(R.id.model_textview);

        }
    }

}
