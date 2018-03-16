package com.zte.ganknews.fragment.douban;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zte.ganknews.R;
import com.zte.ganknews.data.DoubanMomentNewsPosts;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * Created by Stephen on 2018/2/28.
 */

public class DoubanMomentFragment extends Fragment implements DoubanMomentContract.View {

    private DoubanMomentContract.Presenter mPresenter;
    private SwipeRefreshLayout mRefreshLayout;
    private RecyclerView mRecyclerView;
    private View mEmptyView;
    private LinearLayoutManager mLayoutManager;
    private FloatingActionButton fab;

    private DoubanMomentNewsAdapter mAdapter;

    private boolean mIsFirstLoad = true;
    private int mListSize = 0;
    private int mYear, mMonth, mDay;

    public DoubanMomentFragment() {

    }

    public static DoubanMomentFragment newInstance() {
        return new DoubanMomentFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mYear = Calendar.getInstance().get(Calendar.YEAR);
        mMonth = Calendar.getInstance().get(Calendar.MONTH);
        mDay = Calendar.getInstance().get(Calendar.DAY_OF_MONTH);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_timeline_page, container, false);
        initViews(view);

        mRefreshLayout.setOnRefreshListener(() -> {
            Calendar c = Calendar.getInstance();
            c.setTimeZone(TimeZone.getTimeZone("GMT+08"));
            mPresenter.load(true, true, c.getTimeInMillis());
        });

        mRecyclerView.setOnScrollListener(new RecyclerView.OnScrollListener() {

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                if (dy > 0) {
                    if (mLayoutManager.findLastCompletelyVisibleItemPosition() == mListSize - 1) {
                        loadMore();
                    }
                    fab.hide();
                } else {
                    fab.show();
                }
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.start();
        Calendar c = Calendar.getInstance();
        c.set(mYear, mMonth, mDay);
        setLoadingIndicator(mIsFirstLoad);
        if (mIsFirstLoad) {
            mPresenter.load(true, false, c.getTimeInMillis());
            mIsFirstLoad = false;
        } else {
            mPresenter.load(false, false, c.getTimeInMillis());
        }
    }

    private void loadMore() {
        Calendar c = Calendar.getInstance();
        c.set(mYear, mMonth, --mDay);
        mPresenter.load(true, false, c.getTimeInMillis());
    }

    @Override
    public void setPresenter(DoubanMomentContract.Presenter presenter) {
        if (presenter != null) {
            mPresenter = presenter;
        }

    }

    @Override
    public void initViews(View view) {
        mRefreshLayout = view.findViewById(R.id.refresh_layout);
        mRefreshLayout.setColorSchemeColors(ContextCompat.getColor(getContext(), R.color.colorAccent));
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mEmptyView = view.findViewById(R.id.empty_view);
        fab = getActivity().findViewById(R.id.fab);
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        mRefreshLayout.post(() -> mRefreshLayout.setRefreshing(active));
    }

    @Override
    public boolean isActive() {
        return isAdded() && isResumed();
    }

    @Override
    public void showResult(@NonNull List<DoubanMomentNewsPosts> list) {
        if (mAdapter == null) {
            mAdapter = new DoubanMomentNewsAdapter(list, getContext());
            mAdapter.setItemClickListener((v, i) -> {
                // 跳转到详情页面


            });
            mRecyclerView.setAdapter(mAdapter);
        } else {
            mAdapter.updateData(list);
        }

        mListSize = list.size();

        mEmptyView.setVisibility(list.isEmpty() ? View.VISIBLE : View.INVISIBLE);


    }


}
