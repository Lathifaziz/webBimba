package app.Bimba.util.Specification;

import org.springframework.data.jpa.domain.Specification;

import app.Bimba.model.Student;

public class SearchStudent {
    
    public static Specification<Student> nameContent(String name){
        return (root,query,criteriaBuilder)->{
            if (name == null || name.isEmpty()) {
                return criteriaBuilder.conjunction();
            }
            String searchPattern = "%" + name + "%";
            return criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), searchPattern),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("birthday")), searchPattern),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("address")), searchPattern)
            );
        };

    }

   
}
