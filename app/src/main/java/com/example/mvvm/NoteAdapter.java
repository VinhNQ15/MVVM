package com.example.mvvm;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.MyViewHoder> {
    private Note note;
 private ArrayList<Note> noteData;//1

    private static OnitemclickListener listener;

    public NoteAdapter(ArrayList<Note> noteData , OnitemclickListener listener) {//1
        this.noteData = noteData;
        this.listener = listener;
    }

    @NonNull
    @Override
    // tạo đối tượng view
    public MyViewHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType ==0){
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note , parent,false);
        }else {
            view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_le , parent,false);
        }
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_note ,parent,false);
        return new MyViewHoder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHoder holder, int position) {
        holder.binData(noteData.get(position));
//        holder.layout.findViewById(R.id.xoa).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                listener.delete(note);
//                    notifyDataSetChanged();
//            }
//        });

    }

    @Override
    public int getItemCount() {
        return noteData.size();
    }


    class MyViewHoder extends RecyclerView.ViewHolder{
        LinearLayout layout;
       Button button;
        private Note note;
        TextView tvTitle  ;
        TextView  tvDescription;
        public MyViewHoder(@NonNull View itemView) {
            super(itemView);
//            tvTitle = itemView.findViewById(R.id.tv_title);
            tvDescription = itemView.findViewById(R.id.tv_description);
            button = itemView.findViewById(R.id.add_item);
            layout = itemView.findViewById(R.id.xoa);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                        listener.delete(note);
                        notifyDataSetChanged();

//
                }
            });
        }
        public void binData(Note note) {
            this.note=note;
//            tvTitle.setText(note.getTitle());
            tvDescription.setText(note.getDescription());
        }
    }
}
