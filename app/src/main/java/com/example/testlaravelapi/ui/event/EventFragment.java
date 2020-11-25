package com.example.testlaravelapi.ui.event;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.example.testlaravelapi.R;
import com.example.testlaravelapi.ui.MainActivity;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class EventFragment extends Fragment {

    @BindView(R.id.progressBar)
    ProgressBar loading;

    @BindView(R.id.rv_event)
    RecyclerView rvEvent;

    private EventViewModel viewModel;
    private EventAdapter adapter;

    public EventFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        showLoading(true);
        Objects.requireNonNull(((MainActivity) requireActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(false);

        //TODO: Place viewModel implementation here

        rvEvent.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new EventAdapter(getActivity());
    }

    private void showLoading(Boolean state) {
        if (state) {
            rvEvent.setVisibility(View.GONE);
            loading.setVisibility(View.VISIBLE);
        } else {
            rvEvent.setVisibility(View.VISIBLE);
            loading.setVisibility(View.GONE);
        }
    }
}