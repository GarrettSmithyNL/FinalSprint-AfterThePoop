package utility;

import java.util.ArrayList;

/**
 * Generic Data Access Object (DAO) interface.
 * Provides methods to perform CRUD operations on a database table.
 *
 * @param <T> the type of the entity
 */
public interface DAO<T> {

  /**
   * Retrieves all entities from the database.
   *
   * @return an ArrayList of entities
   */
  ArrayList<T> getAll();

  /**
   * Retrieves an entity by its ID.
   *
   * @param id the ID of the entity to retrieve
   * @return the entity with the specified ID
   */
  T getById(int id);

  /**
   * Inserts a new entity into the database.
   *
   * @param t the entity to insert
   * @return the ID of the newly inserted entity, or -1 if the insertion failed
   */
  int insert(T t);

  /**
   * Updates an existing entity in the database.
   *
   * @param t the entity with updated information
   */
  void update(T t);

  /**
   * Deletes an entity from the database.
   *
   * @param t the entity to delete
   */
  void delete(T t);
}