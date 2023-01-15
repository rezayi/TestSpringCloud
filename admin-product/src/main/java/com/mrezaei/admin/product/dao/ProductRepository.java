package com.mrezaei.admin.product.dao;

import com.mrezaei.admin.product.to.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {

    @Query("select c from ProductEntity c where c.categoryId = :categoryId")
    List<ProductEntity> findByCategoryId(@Param("categoryId") int categoryId);

}
