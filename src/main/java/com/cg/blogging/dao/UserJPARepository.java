package com.cg.blogging.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cg.blogging.entities.User;

@Repository
public interface UserJPARepository extends JpaRepository<User,Integer>{

}
