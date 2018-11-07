package com.app.landlordcommunication.views.ChatScreen;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.app.landlordcommunication.R;
import com.app.landlordcommunication.models.Message;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ChatScreenFragment extends Fragment implements ChatScreenContracts.View{

    @BindView(R.id.list)
    RecyclerView mMessagesView;

    @BindView(R.id.loading)
    ProgressBar mLoadingView;

    @Inject
    ChatScreenContracts.Presenter mPresenter;
    private GridLayoutManager mMessagesViewLayoutManager;

    @Inject
    MessagesAdapter mMessagesAdapter;

    @Inject
    public ChatScreenFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_chat_screen, container, false);

        ButterKnife.bind(this, view);



        Intent intent = getActivity().getIntent();
//        Intent intentt = getActivity().getIntent();




        String residencePicture = intent.getStringExtra("userPicture");
        InputStream stream = new ByteArrayInputStream(Base64.decode(residencePicture.getBytes(), Base64.DEFAULT));

        Bitmap bitmap = BitmapFactory.decodeStream(stream);
        mMessagesAdapter.setBitmap(bitmap);

//        String loggedPicture = intentt.getStringExtra("loggedPicture");
//        InputStream streamm = new ByteArrayInputStream(Base64.decode(residencePicture.getBytes(), Base64.DEFAULT));
//
//        Bitmap bitmapp = BitmapFactory.decodeStream(stream);
//        mMessagesAdapter.setBitmapForLoggedUser(bitmapp);




        mMessagesView.setAdapter(mMessagesAdapter);
        mMessagesViewLayoutManager = new GridLayoutManager(getContext(), 1);
        mMessagesView.setLayoutManager(mMessagesViewLayoutManager);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe(this);
        mPresenter.loadMessages();
    }


    @Override
    public void setPresenter(ChatScreenContracts.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void showMessages(List<Message> messages) {
        mMessagesAdapter.clear();
        mMessagesAdapter.addAll(messages);
        mMessagesAdapter.notifyDataSetChanged();
    }

    @Override
    public void showEmptyList() {
        Toast.makeText(getContext(),
                "NO MESSAGES TO SHOW",
                Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showError(Throwable e) {
        Toast.makeText(getContext(), "Error: " + e.getMessage(), Toast.LENGTH_LONG)
                .show();
    }

    @Override
    public void showLoading() {
        mMessagesView.setVisibility(View.GONE);
        mMessagesView.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mMessagesView.setVisibility(View.VISIBLE);
        mLoadingView.setVisibility(View.GONE);
    }

}
