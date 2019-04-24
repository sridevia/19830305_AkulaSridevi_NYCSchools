package com.example.sridevi.a19830305_srideviakula_nycschools.view;


import com.example.sridevi.a19830305_srideviakula_nycschools.model.SchoolListItem;

import java.util.ArrayList;

/**
 * Created by sridevi on 22/4/19.
 */

public interface MainContract {

    /**
     * Call when user interact with the view and other when view OnDestroy()
     * */
    interface presenter{

        void onDestroy();

        void onRefreshButtonClick();

        void requestDataFromServer();

    }

    /**
     * showProgress() and hideProgress() would be used for displaying and hiding the progressBar
     * while the setDataToRecyclerView and onResponseFailure is fetched from the GetNoticeInteractorImpl class
     **/
    interface MainView {

        void showProgress();

        void hideProgress();

        void setDataToRecyclerView(ArrayList<SchoolListItem> noticeArrayList);

        void onResponseFailure(Throwable throwable);

    }

    /**
     * Intractors are classes built for fetching data from your database, web services, or any other data source.
     **/
    interface GetSchoolIntractor {

        void getSchoolArrayList(OnFinishedListener onFinishedListener);

        interface OnFinishedListener {
            void onFinished(ArrayList<SchoolListItem> noticeArrayList);
            void onFailure(Throwable t);
        }
    }
}
