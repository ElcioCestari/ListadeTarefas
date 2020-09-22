package com.elcio.listadetarefas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elcio.listadetarefas.adapter.MyAdapter;
import com.elcio.listadetarefas.model.Person;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Person> personList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);

        createPersonsAndAddToPersonList();

        MyAdapter myAdapter = new MyAdapter(personList, getActivity().getApplicationContext());
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

        return view;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }


    private void createPersonsAndAddToPersonList() {
        personList = new ArrayList<Person>();

        Person person;

        person = new Person("Elcio", 34);
        personList.add(person);
        person = new Person("Maria", 34);
        personList.add(person);
        person = new Person("Tereza", 34);
        personList.add(person);
        person = new Person("Luana", 34);
        personList.add(person);
        person = new Person("Rebeca", 34);
        personList.add(person);
        person = new Person("Esther", 34);
        personList.add(person);
        person = new Person("Heitor", 34);
        personList.add(person);
        person = new Person("Jesus", 34);
        personList.add(person);
        person = new Person("Pedro", 34);
        personList.add(person);
    }
}
