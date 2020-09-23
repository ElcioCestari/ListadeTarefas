package com.elcio.listadetarefas.adapter.listner;

import com.elcio.listadetarefas.model.Person;

/**
 * @author Elcio Cestari Taira
 * @since 23/09/2020
 * <bold>Description</bold> - this interface has only method and I use this
 * to implements an individual click.
 */
public interface  OnItemClickListner  {

    public void OnItemClick(Person person);
}
