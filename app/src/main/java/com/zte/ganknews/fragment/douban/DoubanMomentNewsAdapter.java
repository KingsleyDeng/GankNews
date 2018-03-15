package com.zte.ganknews.fragment.douban;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zte.ganknews.R;
import com.zte.ganknews.data.DoubanMomentNewsPosts;
import com.zte.ganknews.interfaze.OnRecyclerViewItemOnClickListener;

import java.util.List;

/**
 * Created by Stephen on 2018/3/14.
 */

public class DoubanMomentNewsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_ITEM = 0x00;
    private static final int TYPE_NO_IMG = 0x01;

    private List<DoubanMomentNewsPosts> mList;
    private Context mContext;

    private OnRecyclerViewItemOnClickListener mListener;

    public DoubanMomentNewsAdapter(@NonNull List<DoubanMomentNewsPosts> list,
                                   @NonNull Context context) {
        this.mList = list;
        this.mContext = context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ITEM:
                return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_universal_layout, parent, false));
            case TYPE_NO_IMG:
                return new NoImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_universal_without_image, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getThumbs().isEmpty() ? TYPE_NO_IMG : TYPE_ITEM;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        ImageView thumb;
        TextView title;

        OnRecyclerViewItemOnClickListener listener;

        public ItemViewHolder(View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.image_view_cover);
            title = itemView.findViewById(R.id.text_view_title);

            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.OnItemClick(view, getLayoutPosition());
            }
        }
    }

    public class NoImgViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView title;
        OnRecyclerViewItemOnClickListener listener;

        public NoImgViewHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (listener != null) {
                listener.OnItemClick(view, getLayoutPosition());
            }
        }
    }

}
