package com.codeclan.filesandfolders.filesandfolders.repositories;


import com.codeclan.filesandfolders.filesandfolders.models.File;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileRepository extends JpaRepository<File, Long> {

}
