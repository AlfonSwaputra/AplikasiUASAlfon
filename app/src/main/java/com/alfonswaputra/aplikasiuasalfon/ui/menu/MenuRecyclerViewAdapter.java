package com.alfonswaputra.aplikasiuasalfon.ui.menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.alfonswaputra.aplikasiuasalfon.R;

import java.util.List;

public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ItemViewHolder> {
    private List<String> categories;
    private Context context;

    public MenuRecyclerViewAdapter(Context context, List<String> categories) {
        this.categories = categories;
        this.context = context;
    }

    @NonNull
    @Override
    public MenuRecyclerViewAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View adapterLayout = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_item, parent, false);
        return new MenuRecyclerViewAdapter.ItemViewHolder(adapterLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuRecyclerViewAdapter.ItemViewHolder holder, int position) {
        String item = categories.get(position);
        holder.categoryText.setText(item);
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView categoryText;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryText = itemView.findViewById(R.id.category_text);
        }
    }
}
