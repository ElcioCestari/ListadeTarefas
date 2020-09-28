package com.elcio.listadetarefas.ui.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.elcio.listadetarefas.R;
import com.elcio.listadetarefas.adapter.MyAdapter;
import com.elcio.listadetarefas.adapter.listner.OnItemClickListner;
import com.elcio.listadetarefas.dao.PersonDAO;
import com.elcio.listadetarefas.model.Person;

import java.util.ArrayList;
import java.util.List;

public class ListDataFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Person> personList = new ArrayList<>();
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_first, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);


        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        createPersonsAndAddToPersonList();

//        myAdapter = new MyAdapter(personList, getActivity().getApplicationContext());

    }

    /**
     * <bold>description</bold> - this methods is responsable to implements the item click of recyclerview
     *
     * @return OnItemClickListner - return a item click implementation
     */
    private OnItemClickListner myAdapterOnItemClickListner() {
        return new OnItemClickListner() {
            @Override
            public void OnItemClick(Person person) {

                Bundle bundle = new Bundle();
                bundle.putSerializable(getString(R.string.person_bundle_tag), person);

                //invoke and show the DetailFragment
                NavHostFragment.findNavController(ListDataFragment.this)
                        .navigate(R.id.action_FirstFragment_to_DetailFragment, bundle);

            }

            @Override
            public void OnLongItemClick(final Person person) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
                dialog.setTitle(getString(R.string.question_title_delete));
                dialog.setMessage(getString(R.string.question_message_delete));

                dialog.setPositiveButton("sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        PersonDAO personDAO = new PersonDAO(getContext());

                        if (personDAO.delete(person)) {
                            createPersonsAndAddToPersonList();
                            Toast.makeText(getContext(), getString(R.string.deleted_data_message), Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getContext(), getString(R.string.negative_message_to_update), Toast.LENGTH_LONG).show();
                        }
                    }
                });

                dialog.setNegativeButton("nao", null);
                dialog.create();
                dialog.show();
            }
        };
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.floatingActionButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ListDataFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }


    private void createPersonsAndAddToPersonList() {

        PersonDAO personDAO = new PersonDAO(getActivity().getApplicationContext());

        personList = personDAO.getAll();
        myAdapter = new MyAdapter(personList, getActivity().getApplicationContext());

        myAdapter.setOnItemClickListner(myAdapterOnItemClickListner());

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(myAdapter);

    }
}
