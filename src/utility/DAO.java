package utility;

import java.util.ArrayList;
public interface DAO<T> {
  ArrayList<T> getAll();
  T getById(int id);
  int insert(T t);
  void update(T t);
  void delete(T t);
}
