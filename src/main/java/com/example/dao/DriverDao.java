/**
 * 
 */
package com.example.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Driver;

/**
 * @author apple
 *
 */
public interface DriverDao extends JpaRepository<Driver, Integer> {

}
