package com.app.landlordcommunication.views.HomePage;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Residence;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ResidencesAdapter extends RecyclerView.Adapter<ResidencesAdapter.ResidenceViewHolder> {
        private List<Residence> mResidences;
        private OnResidenceClickListener mOnResidenceClickListener;

        @Inject
        public ResidencesAdapter(){
            mResidences = new ArrayList<>();
        }

        @NonNull
        @Override
        public ResidenceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.residence_item, parent, false);
            return new ResidenceViewHolder(view);
        }

        public void onBindViewHolder(@NonNull ResidenceViewHolder holder, int position){
            holder.setOnClickListener(mOnResidenceClickListener);
            holder.bind(mResidences.get(position));
        }

        @Override
        public int getItemCount() {
            return mResidences.size();
        }

        public Residence getItem(int position) {
            return mResidences.get(position);
        }

        public void clear() {
            mResidences.clear();
        }

        public void addAll(List<Residence> Residences) {
            mResidences.addAll(Residences);
        }

        public void setOnResidenceClickListener(OnResidenceClickListener onResidenceClickListener){
            this.mOnResidenceClickListener = onResidenceClickListener;
        }

        interface OnResidenceClickListener {
            void onClick(Residence Residence);
        }

        public static class ResidenceViewHolder extends RecyclerView.ViewHolder{
            @BindView(R.id.textView_address)
            TextView mAddressTextView;

          /*  @BindView(R.id.imageView_residence)
            ImageView mResidenceImageView;*/

            private OnResidenceClickListener mOnClickListener;
            private Residence mResidence;

            ResidenceViewHolder(View view){
                super(view);
                ButterKnife.bind(this, view);
            }

            void bind(Residence residence){
                mAddressTextView.setText(residence.getAddress());

               //Picasso.get().load(residence.getImage()).into(mResidenceImageView);
                mResidence = residence;
            }

            @OnClick
            public void OnClick(OnResidenceClickListener onClickListener){
                mOnClickListener.onClick(mResidence);
            }

            public void setOnClickListener(OnResidenceClickListener onClickListener){
                mOnClickListener = onClickListener;
            }

        }
    }
