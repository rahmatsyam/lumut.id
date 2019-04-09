package io.github.rahmatsyam.lumutid.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.github.rahmatsyam.lumutid.R;
import io.github.rahmatsyam.lumutid.data.model.ItemData;
import io.github.rahmatsyam.lumutid.ui.activity.MainActivity;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<ItemData> mItemData;

    public ItemAdapter(MainActivity mainActivity, List<ItemData> dataList) {
        this.mItemData = dataList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_detail, viewGroup, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ItemViewHolder itemViewHolder, final int position) {
        ItemData itemData = mItemData.get(position);
        itemViewHolder.tvTitle.setText(itemData.getTitle());
        itemViewHolder.tvUserId.setText(String.valueOf("User id : " + itemData.getUserId()));
        itemViewHolder.tvId.setText(String.valueOf("Id : " + itemData.getId()));

    }

    @Override
    public int getItemCount() {
        return mItemData.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {

        TextView tvTitle;
        TextView tvUserId;
        TextView tvId;

        ItemViewHolder(View view) {
            super(view);
            tvTitle = view.findViewById(R.id.tv_title);
            tvUserId = view.findViewById(R.id.tv_userid);
            tvId = view.findViewById(R.id.tv_id);
        }
    }
}
