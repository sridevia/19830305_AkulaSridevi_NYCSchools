package com.example.sridevi.a19830305_srideviakula_nycschools.view;


import com.example.sridevi.a19830305_srideviakula_nycschools.model.SchoolListItem;

import java.util.ArrayList;

/**
 * Created by bpn on 12/7/17.
 */

public class MainPresenterImpl implements MainContract.presenter, MainContract.GetSchoolIntractor.OnFinishedListener {

    private MainContract.MainView mainView;
    private MainContract.GetSchoolIntractor getNoticeIntractor;

    public MainPresenterImpl(MainContract.MainView mainView, MainContract.GetSchoolIntractor getNoticeIntractor) {
        this.mainView = mainView;
        this.getNoticeIntractor = getNoticeIntractor;
    }

    @Override
    public void onDestroy() {

        mainView = null;

    }

    @Override
    public void onRefreshButtonClick() {

        if(mainView != null){
            mainView.showProgress();
        }
        getNoticeIntractor.getSchoolArrayList(this);

    }

    @Override
    public void requestDataFromServer() {
        getNoticeIntractor.getSchoolArrayList(this);
    }


    @Override
    public void onFinished(ArrayList<SchoolListItem> noticeArrayList) {
        if(mainView != null){
            mainView.setDataToRecyclerView(noticeArrayList);
            mainView.hideProgress();
        }
    }

    @Override
    public void onFailure(Throwable t) {
        if(mainView != null){
            mainView.onResponseFailure(t);
            mainView.hideProgress();
        }
    }
}
