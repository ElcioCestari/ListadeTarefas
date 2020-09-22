package com.elcio.listadetarefas.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.elcio.listadetarefas.R;
import com.elcio.listadetarefas.model.Person;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MyAdapter.MyViewHolder>{
    private List<Person> personList;
    //private Context context;

    public MyAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        //this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = (View) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txtName.setText(personList.get(position).getFirstName().toString());
        holder.txtAge.setText(personList.get(position).getAge().toString());
    }

    @Override
    public int getItemCount() {
        return this.personList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtAge;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
        }
    }
}
