package com.app.landlordcommunication.diconfig;

import android.content.Context;
import android.support.v7.widget.RecyclerView;

import com.app.landlordcommunication.views.ResidencesList.ResidencesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewsModule {
    @Provides
    public RecyclerView.Adapter<ResidencesAdapter.ResidenceViewHolder> ResidenceArrayAdapter(Context context) {
        return new ResidencesAdapter();
    }
}
