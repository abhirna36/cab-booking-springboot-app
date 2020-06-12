/**
 * 
 */
package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;

/**
 * @author apple
 *
 */
public interface UserDao extends JpaRepository<User, Integer> {

}
