package com.example.workshop.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.workshop.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    TextInputLayout lastNameLayout;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @NonNull Bundle savedInstranceState) {
        super.onViewCreated(view, savedInstranceState);
        initViewsWithActions(view);
    }

    private void initViewsWithActions(View view){
        TextInputLayout firstNameLayout = view.findViewById(R.id.first_name_text_input_layout);
        TextInputEditText firstName = view.findViewById(R.id.first_name_text_input_edit_text);
        TextInputLayout lastNameLayout = view.findViewById(R.id.last_name_text_input_layout);
        TextInputEditText lastName = view.findViewById(R.id.last_name_text_input_edit_text);

    }

}