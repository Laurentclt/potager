package fr.eni.potager.bll;

import java.util.List;

public interface CrudManager<T> {

    T saveOrUpdate();

    List<T> getAll();

    T getById();

    void delete();


}
