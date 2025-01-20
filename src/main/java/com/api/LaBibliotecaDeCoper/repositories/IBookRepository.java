package com.api.LaBibliotecaDeCoper.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.LaBibliotecaDeCoper.models.*;


@Repository
public interface IBookRepository extends JpaRepository<BookModel, Long>{

    List<BookModel> findAllByCategory(String category);

}