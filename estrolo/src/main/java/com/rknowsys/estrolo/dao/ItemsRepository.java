package com.rknowsys.estrolo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rknowsys.estrolo.entities.Items;

@Repository
public interface ItemsRepository extends JpaRepository<Items, Integer>{

}
