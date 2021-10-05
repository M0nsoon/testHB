package de.ur.mi.android.demos.healthbestie.dashboard.Service;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.ur.mi.android.demos.healthbestie.R;

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.ItemViewHolder> {

    ArrayList<ShoppingItem> arrayList;



    public ShoppingListAdapter(ArrayList<ShoppingItem> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {

        ShoppingItem item = arrayList.get(position);
        holder.textView.setText(item.getName());

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                arrayList.remove(holder.getAdapterPosition());
                notifyDataSetChanged();
            }
        });



    }



    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;




        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textView5);
            imageView = itemView.findViewById(R.id.imageView3);



        }

    }
}
