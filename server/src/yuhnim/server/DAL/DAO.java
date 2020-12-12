package yuhnim.server.DAL;

import java.util.ArrayList;
import java.util.List;

public interface DAO<T> {
    ArrayList<T> getAll(Integer id);
    T get(Integer id);

    Integer update(T t);

    Integer delete(T t);
}
