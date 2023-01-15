package com.mrezaei.admin.product.dao;

import com.mrezaei.admin.product.to.CategoryEntity;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<CategoryEntity, Integer> {
}
