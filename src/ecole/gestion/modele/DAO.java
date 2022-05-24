package ecole.gestion.modele;

import java.util.List;

public interface DAO<T> {
    T create(T newObj);

    T read(T objRech);

    T update(T objRech);

    boolean delete(T ObjRech);

    List<T> readAll();

}
