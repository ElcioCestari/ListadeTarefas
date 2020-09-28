package com.elcio.listadetarefas.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.elcio.listadetarefas.R;
import com.elcio.listadetarefas.dao.PersonDAO;
import com.elcio.listadetarefas.model.Person;

/**
 * @author Elcio Cestari Taira
 * <bold>description</bold> - this frament show details about a RecyclerView item.
 */
public class EditDataFragment extends Fragment {

    private EditText editName, editAge;
    private Person person;
    private Button btnSave, btnCancel;

    public EditDataFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        person = (Person) getArguments().getSerializable(getString(R.string.person_bundle_tag));

        View view = inflater.inflate(R.layout.fragment_edit_data, container, false);

        editName = view.findViewById(R.id.txt_name_in_edit_fragment);
        editAge = view.findViewById(R.id.txt_age_in_edit_fragment);
        btnCancel = view.findViewById(R.id.btn_cancel_in_edit_fragment);
        btnSave = view.findViewById(R.id.btn_save_in_edit_fragment);

        editName.setText(person.getFirstName().toString());
        editAge.setText(person.getAge().toString());

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getEditableText().toString();
                Integer age = Integer.parseInt(editAge.getEditableText().toString());

                editPerson(age, name);
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
/*                NavHostFragment.findNavController(EditDataFragment.this).
                        navigate(R.id.action_DetailFragment_to_FirstFragment);*/
                navigateToHome();
            }
        });

    }

    private void editPerson(Integer age, String name) {

        person.setFirstName(name);
        person.setAge(age);

        //TODO apenas para debug, ddepois devo melhorar
        PersonDAO personDAO = new PersonDAO(getActivity());

        if (personDAO.upDate(person)) {
            MyCustomToast(getString(R.string.positive_message_to_update));
            navigateToHome();
        } else {
            MyCustomToast(getString(R.string.negative_message_to_update));

        }
    }

    private void navigateToHome() {
        NavHostFragment.findNavController(EditDataFragment.this)
                .navigate(R.id.action_DetailFragment_to_FirstFragment);
    }

    private void MyCustomToast(String msg) {
        Toast.makeText(getActivity().getApplicationContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
