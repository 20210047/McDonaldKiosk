package repository;

import java.util.List;

public interface DataBaseRepository<T> {
    public List<T> findAll();

    public <T> T findById(int id);
}
