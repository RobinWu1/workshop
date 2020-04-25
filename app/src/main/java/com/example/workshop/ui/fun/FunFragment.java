package com.example.workshop.ui.fun;

import android.app.DatePickerDialog;
import android.content.Context;
import android.icu.util.Calendar;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import com.example.workshop.MainActivity;
import com.example.workshop.R;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.text.SimpleDateFormat;
import java.util.Locale;

@RequiresApi(api = Build.VERSION_CODES.N)
public class FunFragment extends Fragment {




    private FunViewModel funViewModel;
    EditText chooseDate;
    java.util.Calendar calendar;
    DatePickerDialog datePickerDialog;
    int currentDayOfMonth;
    int currentMonth;
    int currentYear;

    TextInputLayout lastNameLayout;
    RadioGroup radioGenderGroup;
    TextInputEditText firstName, lastName, email, password;
    RadioButton maleRadioButton, femaleRadioButton, radioGenderButton;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        funViewModel =
                ViewModelProviders.of(this).get(FunViewModel.class);
        View root = inflater.inflate(R.layout.fragment_fun, container, false);
        return root;

    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViewsWithActions(view);
    }

    private void initViewsWithActions(View view) {

        //Input Edit Text
        firstName = view.findViewById(R.id.first_name_text_input_edit_text);
        lastNameLayout = view.findViewById(R.id.last_name_text_input_layout);
        lastName = view.findViewById(R.id.last_name_text_input_edit_text);
        email = view.findViewById(R.id.email_text_input_edit_text);
        password = view.findViewById(R.id.password_text_input_edit_text);

        // Radio Buttons
        radioGenderGroup = view.findViewById(R.id.radio_group);
        maleRadioButton = view.findViewById(R.id.male_radio_button);
        femaleRadioButton = view.findViewById(R.id.female_radio_button);

        //Check Box
        CheckBox collectInfoCheckBox = view.findViewById(R.id.checkbox_button);
        boolean checkedValue = collectInfoCheckBox.isChecked();

        //Buttons
        Button hideButton = view.findViewById(R.id.hide_last_name_button);
        Button toastButton = view.findViewById(R.id.show_gender_in_alert_button);
        Button submitButton = view.findViewById(R.id.submit_button);


        hideButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideLastNameLayout();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToConfirmationScreen(view);
            }
        });

        chooseDate = (EditText) view.findViewById(R.id.date_of_birth_edit_text);
        chooseDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                calendar = java.util.Calendar.getInstance();
                currentYear = calendar.get(java.util.Calendar.YEAR);
                currentMonth = calendar.get(java.util.Calendar.MONTH);
                currentDayOfMonth = calendar.get(java.util.Calendar.DAY_OF_MONTH);


                datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                        chooseDate.setText(String.format("%02d/%02d/%04d", month, dayOfMonth, year));
                    }
                }, 1994, 9, 26);
                datePickerDialog.show();
            }
        });

    }




    private void hideLastNameLayout() {
        lastNameLayout.setVisibility(View.GONE);
    }

    private void goToConfirmationScreen(View view) {
        NavDirections action =
                FunFragmentDirections
                        .actionNavigationFunToNavigationFoodMenu(firstName.getText().toString());
        Navigation.findNavController(view).navigate(action);
    }




}