package com.nutstudio.ntour.page.page2;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.nutstudio.ntour.R;

import java.util.ArrayList;
import java.util.Map;

public class CollectionRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Map<String, Object>> list;
    private LayoutInflater mInflater;
    private Context context;
    private static final int TYPE_FOOTER = 1;
    private static final int ITEM1 = 2;

    public CollectionRecyclerAdapter(Context contexts, ArrayList<Map<String, Object>> list) {
        mInflater = LayoutInflater.from(contexts);
        this.context = contexts;
        this.list = list;
    }
    @Override
    public int getItemViewType(int position) {
        if (position == (list.size() - 1)) {
            return TYPE_FOOTER;
        }else{
            return ITEM1;
        }
    }

    public interface OnItemClickCall {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickCall mOnItemClickCall;

    public void setOnItemClickLitener(OnItemClickCall mOnItemClickCall) {
        this.mOnItemClickCall = mOnItemClickCall;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM1) {
            View view = mInflater.inflate(R.layout.page2_recycler_item1,
                    parent, false);
            Item1ViewHolder item1ViewHolder = new Item1ViewHolder(view);
            item1ViewHolder.mImageView = (ImageView) view
                    .findViewById(R.id.im_recycler_item);
            return item1ViewHolder;
        } else if (viewType == TYPE_FOOTER) {
            View view = mInflater.inflate(R.layout.recycler_item_foot,
                    parent, false);
            FootViewHolder footViewHolder = new FootViewHolder(view);
            footViewHolder.mImageView = (ImageView) view
                    .findViewById(R.id.im_recycler_item);
            return footViewHolder;
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof Item1ViewHolder) {
            //Glide.with(context).load((String) list.get(position).get("item_img")).into(((Item1ViewHolder) holder).mImageView);
            if (mOnItemClickCall != null) {
                ((Item1ViewHolder) holder).itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickCall.onItemClick(holder.itemView, pos);
                    }
                });
                ((Item1ViewHolder) holder).itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int pos = holder.getLayoutPosition();
                        mOnItemClickCall.onItemLongClick(holder.itemView, pos);
                        return false;
                    }
                });
            }
        } else if (holder instanceof FootViewHolder) {
            ((FootViewHolder) holder).mImageView.setImageResource(R.mipmap.ic_launcher);
        }
    }

    public void insertItem(int position) {

    }

    public void removeItem(int position) {
        list.remove(position);
        notifyItemRemoved(position);
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class Item1ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public Item1ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public static class FootViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;

        public FootViewHolder(View itemView) {
            super(itemView);
        }
    }

}
