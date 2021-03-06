package com.example.pradeep.picpose.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pradeep.picpose.R;
import com.example.pradeep.picpose.model.NavDrawerItem;

import java.util.Collections;
import java.util.List;

/**
 * Created by pradeep on 25/3/17.
 */

public class NavigationDrawerAdapter extends RecyclerView.Adapter<NavigationDrawerAdapter.ItemViewHolder> {

    List<NavDrawerItem> navDrawerItems = Collections.emptyList();
    private LayoutInflater layoutInflater;
    private Context context;

    public NavigationDrawerAdapter(Context context, List<NavDrawerItem> navDrawerItems){
        this.navDrawerItems = navDrawerItems;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.nav_drawer_row, parent, false);
        ItemViewHolder itemViewHolder = new ItemViewHolder(view);
        return itemViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {
        NavDrawerItem currentItem = navDrawerItems.get(position);
        holder.textViewTitle.setText(currentItem.getTitle());
        holder.imageViewNavItem.setImageResource(currentItem.getImage());
        /*if(currentItem.isSelected()){
            holder.itemView.setBackgroundResource(R.color.colorAccent);
        }*/
    }

    @Override
    public int getItemCount() {
        return navDrawerItems.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView imageViewNavItem;

        public ItemViewHolder(View itemView) {
            super(itemView);
               textViewTitle = (TextView) itemView.findViewById(R.id.textNavTitle);
               imageViewNavItem = (ImageView) itemView.findViewById(R.id.imageViewNavItem);

        }
    }

    public void deleteItem(int position){
        navDrawerItems.remove(position);
        notifyDataSetChanged();
    }
    public void updateList(List<NavDrawerItem> navDrawerItems){
        this.navDrawerItems.clear();
        this.navDrawerItems.addAll(navDrawerItems);
        notifyDataSetChanged();
    }
}
