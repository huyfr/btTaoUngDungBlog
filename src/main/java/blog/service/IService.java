package blog.service;

import java.util.List;

public interface IService<T> {
    List<T> findAll();

    T findById(Integer id);

    void save(T blog);

    void remove(Integer id);
}
