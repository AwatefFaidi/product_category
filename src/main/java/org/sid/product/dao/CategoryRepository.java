package org.sid.product.dao;

import org.sid.product.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface CategoryRepository extends JpaRepository<Category, Long>{

}
