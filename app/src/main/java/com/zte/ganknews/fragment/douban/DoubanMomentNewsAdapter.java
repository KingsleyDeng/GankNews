package com.zte.ganknews.fragment.douban;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
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
                return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_universal_layout, parent, false), mListener);
            case TYPE_NO_IMG:
                return new NoImgViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_universal_without_image, parent, false), mListener);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        DoubanMomentNewsPosts item = mList.get(position);
        if (viewHolder instanceof ItemViewHolder) {
            ItemViewHolder holder = (ItemViewHolder) viewHolder;

            Glide.with(mContext)
                    .load(item.getThumbs().get(0).getMedium().getUrl())
                    .asBitmap()
                    .placeholder(R.drawable.placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                    .error(R.drawable.placeholder)
                    .centerCrop()
                    .into(holder.thumb);

            holder.title.setText(item.getTitle());

        } else if (viewHolder instanceof NoImgViewHolder) {
            NoImgViewHolder holder = (NoImgViewHolder) viewHolder;
            holder.title.setText(item.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return mList.isEmpty() ? 0 : mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return mList.get(position).getThumbs().isEmpty() ? TYPE_NO_IMG : TYPE_ITEM;
    }

    public void updateData(@NonNull List<DoubanMomentNewsPosts> list) {
        mList.clear();
        mList.addAll(list);
        notifyDataSetChanged();
        notifyItemRemoved(list.size());
    }

    public void setItemClickListener(OnRecyclerViewItemOnClickListener listener) {
        this.mListener = listener;
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        ImageView thumb;
        TextView title;

        OnRecyclerViewItemOnClickListener listener;

        public ItemViewHolder(View itemView, OnRecyclerViewItemOnClickListener mListener) {
            super(itemView);
            thumb = itemView.findViewById(R.id.image_view_cover);
            title = itemView.findViewById(R.id.text_view_title);

            this.listener = mListener;
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

        public NoImgViewHolder(View itemView, OnRecyclerViewItemOnClickListener mListener) {
            super(itemView);
            title = itemView.findViewById(R.id.text_view_title);
            this.listener = mListener;
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
