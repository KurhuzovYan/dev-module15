package com.example.devmodule15.reposetories;

import com.example.devmodule15.entites.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface INoteRepository extends CrudRepository<Note, Long> {
}
