package com.favoris.shopStore.dao;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.favoris.shopStore.entity.User;



public interface UserDao extends JpaRepository<User, Integer> {
    @Query("select u from User u where u.username like  ?1")
    User selectByUsername(String username);
}
