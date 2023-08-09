package fr.eni.potager.bll;

import java.util.List;

public interface CrudManager<T> {

    T saveOrUpdate(T t);

    List<T> getAll();

    T getById(Integer id) throws BLLManagerException;

    void delete(T t);


}
