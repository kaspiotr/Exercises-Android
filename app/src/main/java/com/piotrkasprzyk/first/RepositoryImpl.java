package com.piotrkasprzyk.first;

public class RepositoryImpl implements Repository{

    static RepositoryImpl getInstance(){
        return new RepositoryImpl();
    }

    @Override
    public void loadData() {
        //TODO
    }

    @Override
    public void saveData() {
        //TODO
    }
}
