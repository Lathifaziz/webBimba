package app.Bimba.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import app.Bimba.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> ,JpaSpecificationExecutor<Student>{

    
} 
