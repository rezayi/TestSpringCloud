package com.mrezaei.admin.user.dao;

import com.mrezaei.admin.user.to.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {
}
