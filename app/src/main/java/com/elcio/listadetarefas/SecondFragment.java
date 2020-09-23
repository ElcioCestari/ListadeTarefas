package com.elcio.listadetarefas;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class SecondFragment extends Fragment {
    private EditText editName, editAge;
    private Button btnSave;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_second, container, false);

        editName = view.findViewById(R.id.editName);
        editAge = view.findViewById(R.id.editAge);
        btnSave  = view.findViewById(R.id.btnSave);

        btnSave.setOnClickListener(myBtnSaveListner());

        return view;
    }

    private View.OnClickListener myBtnSaveListner() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myCustomToast("salvo");
            }
        };
    }

    private void myCustomToast(String message) {
        Toast.makeText(getActivity().getApplicationContext(),message, Toast.LENGTH_SHORT ).show();
    }


    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
    }
}
