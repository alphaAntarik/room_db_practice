package com.example.room_db_practice;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    List<personDetails> data ;

    public MyAdapter( List<personDetails> data) {
        this.data = data;

    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.single_row,parent,false);
        return  new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
//        holder.recid.setText(String.valueOf(data.get(position).getId()));
        holder.t1.setText(data.get(position).getName());
        holder.t2.setText(data.get(position).getTitle());
        holder.del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatabaseHelper db = Room.databaseBuilder(holder.recid.getContext(),
                        DatabaseHelper.class, "room_db").allowMainThreadQueries().build();
                DaoDetails userDao = db.dao();
                userDao.deleteById(data.get(position).getId());
                data.remove(position);
                notifyDataSetChanged();

            }
        });
        holder.upd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(new Intent(holder.upd.getContext(),updateData.class));
                intent.putExtra("id",String.valueOf(data.get(position).getId()));
                intent.putExtra("name",data.get(position).getName());
                intent.putExtra("title",data.get(position).getTitle());
                holder.upd.getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }
    public void setTasks(List<personDetails> data) {
        this.data = data;
        notifyDataSetChanged();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView recid,t1,t2;
        ImageButton del, upd;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            recid=itemView.findViewById(R.id.recid);
            t1= itemView.findViewById(R.id.txt1);
            t2 = itemView.findViewById(R.id.txt2);
            del = itemView.findViewById(R.id.delbtn);
            upd = itemView.findViewById(R.id.edbtn);
        }
    }
}
