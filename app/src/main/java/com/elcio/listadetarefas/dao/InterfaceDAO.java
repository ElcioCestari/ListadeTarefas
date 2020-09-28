package com.elcio.listadetarefas.dao;

import com.elcio.listadetarefas.model.Person;

import java.util.List;

public interface InterfaceDAO {
    public boolean insert(Person person);
    public boolean upDate(Person person);
    public boolean delete(Person person);
    public List<Person> getAll();
}
