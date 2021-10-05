package de.ur.mi.android.demos.healthbestie.drawer_menu_fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import de.ur.mi.android.demos.healthbestie.R;
import de.ur.mi.android.demos.healthbestie.dashboard.CaloriesCalculator;
import de.ur.mi.android.demos.healthbestie.dashboard.RecipeSuggestion;
import de.ur.mi.android.demos.healthbestie.dashboard.ShoppingList;
import de.ur.mi.android.demos.healthbestie.dashboard.SleepCalculator;
import de.ur.mi.android.demos.healthbestie.dashboard.SupermarketFinder;
import de.ur.mi.android.demos.healthbestie.dashboard.WaterReminder;


public class HomeFragment extends Fragment implements View.OnClickListener {
    CardView caloriesCard, sleepCard, recipeCard, waterCard, mapCard, listCard;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        caloriesCard = v.findViewById(R.id.calories_card);
        sleepCard = v.findViewById(R.id.sleep_card);
        recipeCard = v.findViewById(R.id.recipe_card);
        waterCard = v.findViewById(R.id.water_card);
        mapCard = v.findViewById(R.id.map_card);
        listCard = v.findViewById(R.id.list_card);

        caloriesCard.setOnClickListener(this);
        sleepCard.setOnClickListener(this);
        recipeCard.setOnClickListener(this);
        waterCard.setOnClickListener(this);
        mapCard.setOnClickListener(this);
        listCard.setOnClickListener(this);

        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.calories_card:
                startActivity(new Intent(getActivity(), CaloriesCalculator.class));
                break;
            case R.id.sleep_card:
                startActivity(new Intent(getActivity(), SleepCalculator.class));
                break;

            case R.id.recipe_card:
                startActivity(new Intent(getActivity(), RecipeSuggestion.class));
                break;

            case R.id.water_card:
                startActivity(new Intent(getActivity(), WaterReminder.class));
                break;

            case R.id.map_card:
                startActivity(new Intent(getActivity(), SupermarketFinder.class));
                break;

            case R.id.list_card:
                startActivity(new Intent(getActivity(), ShoppingList.class));
                break;
        }
    }
}