package com.piotrkasprzyk.first;


import android.support.annotation.Nullable;

import com.piotrkasprzyk.first.pojo.Contact;
import com.piotrkasprzyk.first.utils.ContactUtils;

import java.util.List;

public class PresenterImpl implements Contract.Presenter {

    private Repository repository;

    @Nullable
    private Contract.View view;

    PresenterImpl(Repository repository){
        this.repository = repository;
    }

    @Override
    public void attachView(Contract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    protected Contract.View getView(){
        return view;
    }

    public void setView(@Nullable Contract.View view) {
        this.view = view;
    }

    public void loadData(){

    }
}