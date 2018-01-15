package com.piotrkasprzyk.first.presenter;


import android.support.annotation.Nullable;

import com.piotrkasprzyk.first.Contract;
import com.piotrkasprzyk.first.repository.Repository;

public class PresenterImpl implements Contract.Presenter {

    private Repository repository;

    @Nullable
    private Contract.View view;

    PresenterImpl(Repository repository) {
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

    public void setView(@Nullable Contract.View view) {
        this.view = view;
    }

    public void loadData() {

    }

    @Nullable
    protected Contract.View getView() {
        return view;
    }

    public Repository getRepository() {
        return repository;
    }
}
