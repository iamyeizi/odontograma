package com.odontograma.dao;

import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<T> {
	
    void insert(T t) throws SQLException;
    
    void update(T t) throws SQLException;
    
    T getById(int id) throws SQLException;
    
    List<T> getAll() throws SQLException;
    
    void delete(int id) throws SQLException;
}