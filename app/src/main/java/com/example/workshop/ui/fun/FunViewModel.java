package com.example.workshop.ui.fun;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FunViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FunViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is fun fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}