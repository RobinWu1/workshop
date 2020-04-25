package com.example.workshop.ui.fun.foodScreen;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.workshop.R;

public class FoodMenuFragment extends Fragment {

    private List<FoodsModel> foodsList = new ArrayList<>();
    private RecyclerView foodsRecyclerView;
    private RecyclerViewVerticalListAdapter foodsAdapter;
    String firstName;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_menu, container, false);
        firstName = FoodMenuFragmentArgs.fromBundle(getArguments()).getFirstName();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        populateHeader(view);
        populateRecyclerView(view);
    }

    private void populateHeader(View view){
        TextView headerTextView = view.findViewById(R.id.header_text_view);
        headerTextView.setText("Welcome " +firstName+ ", Foods linked to your account");
    }

    private void populateRecyclerView(View view) {
        foodsRecyclerView = view.findViewById(R.id.foods_recycler_view);
        // add a divider after each item for more clarity
        foodsRecyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));

        //Define the layout manager and adapter
        foodsAdapter = new RecyclerViewVerticalListAdapter(foodsList, getActivity());
        LinearLayoutManager verticalLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        // Set the layout manager and adapter
        foodsRecyclerView.setLayoutManager(verticalLayoutManager);
        foodsRecyclerView.setAdapter(foodsAdapter);

        //Populate the list that needs to be passed to the adapter.
        populatefoodsList();


    }

    /**
     * Populate the list that needs to be passed to the adapter.
     */
    private void populatefoodsList() {
        FoodsModel food1 = new FoodsModel("Hot Pot",R.mipmap.hotpot);
        FoodsModel food2 = new FoodsModel("Sichuan Pork", R.mipmap.sichuan_pork);
        FoodsModel food3 = new FoodsModel("Braised Pork Balls in Gravy", R.mipmap.braised_pork_balls_in_gravy);
        FoodsModel food4 = new FoodsModel("Shrimp with Vermicelli and Garlic", R.mipmap.shrimp_with_vermicalli_and_garlic);
        FoodsModel food5 = new FoodsModel("Dumplings", R.mipmap.dumplings);
        FoodsModel food6 = new FoodsModel("Chow Mein", R.mipmap.chow_mein);
        FoodsModel food7 = new FoodsModel("Peking Roasted Duck", R.mipmap.peking_roasted_duck);
        FoodsModel food8 = new FoodsModel("Steamed Vermicelli Rolls", R.mipmap.steamed_vermicelli_rolls);
        foodsList.add(food1);
        foodsList.add(food2);
        foodsList.add(food3);
        foodsList.add(food4);
        foodsList.add(food5);
        foodsList.add(food6);
        foodsList.add(food7);
        foodsList.add(food8);

        foodsList.add(food1);
        foodsList.add(food2);
        foodsList.add(food3);
        foodsList.add(food4);
        foodsList.add(food5);
        foodsList.add(food6);
        foodsList.add(food7);
        foodsList.add(food8);

        foodsList.add(food1);
        foodsList.add(food2);
        foodsList.add(food3);
        foodsList.add(food4);
        foodsList.add(food5);
        foodsList.add(food6);
        foodsList.add(food7);
        foodsList.add(food8);

        foodsList.add(food1);
        foodsList.add(food2);
        foodsList.add(food3);
        foodsList.add(food4);
        foodsList.add(food5);
        foodsList.add(food6);
        foodsList.add(food7);
        foodsList.add(food8);

        //Notify the changes
        foodsAdapter.notifyDataSetChanged();
    }
}
