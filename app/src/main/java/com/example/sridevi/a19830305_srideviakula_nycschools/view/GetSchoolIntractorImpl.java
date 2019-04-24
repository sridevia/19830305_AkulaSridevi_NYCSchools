package com.example.sridevi.a19830305_srideviakula_nycschools.view;

import android.util.Log;


import com.example.sridevi.a19830305_srideviakula_nycschools.model.SchoolListItem;
import com.example.sridevi.a19830305_srideviakula_nycschools.my_interface.GetSchoolDataService;
import com.example.sridevi.a19830305_srideviakula_nycschools.network.RetrofitInstance;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by sridevi on 22/4/19.
 */

public class GetSchoolIntractorImpl implements MainContract.GetSchoolIntractor {

    @Override
    public void getSchoolArrayList(final OnFinishedListener onFinishedListener) {


        /** Create handle for the RetrofitInstance interface*/
        GetSchoolDataService service = RetrofitInstance.getRetrofitInstance().create(GetSchoolDataService.class);

        /** Call the method with parameter in the interface to get the notice data*/
        Call<ArrayList<SchoolListItem>> call = service.getSchoolData();

        /**Log the URL called*/
        Log.wtf("URL Called", call.request().url() + "");

        call.enqueue(new Callback<ArrayList<SchoolListItem>>() {
            @Override
            public void onResponse(Call<ArrayList<SchoolListItem>> call, Response<ArrayList<SchoolListItem>> response) {
                onFinishedListener.onFinished(response.body());

            }

            @Override
            public void onFailure(Call<ArrayList<SchoolListItem>> call, Throwable t) {
                onFinishedListener.onFailure(t);
            }
        });

    }

}
