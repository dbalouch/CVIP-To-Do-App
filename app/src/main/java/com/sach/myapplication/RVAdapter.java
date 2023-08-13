package com.sach.myapplication;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.sach.myapplication.databinding.EachRvBinding;

public class RVAdapter extends ListAdapter<Note,RVAdapter.viewHolder> {

    public RVAdapter(){
super(CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Note> CALLBACK=new DiffUtil.ItemCallback<Note>() {
        @Override
          public boolean areItemsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getId()==newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Note oldItem, @NonNull Note newItem) {
            return oldItem.getTitle().equals(newItem.getTitle())
                    && oldItem.getDisp().equals(newItem.getDisp());
        }
    };
    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.each_rv,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        Note note=getItem(position);
        holder.binding.titleRv.setText(note.getTitle());
        holder.binding.displayRv.setText(note.getDisp());



    }
    public Note getNote(int position){
        return getItem(position);
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        EachRvBinding binding;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            binding=EachRvBinding.bind(itemView);
        }
    }
}
