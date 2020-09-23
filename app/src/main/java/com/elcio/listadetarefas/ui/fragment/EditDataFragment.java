package com.elcio.listadetarefas.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.elcio.listadetarefas.R;

/**
 * @author Elcio Cestari Taira
 * <bold>description</bold> - this frament show details about a RecyclerView item.
 */
public class EditDataFragment extends Fragment {

    public EditDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit_data, container, false);

        return view;
    }
}
