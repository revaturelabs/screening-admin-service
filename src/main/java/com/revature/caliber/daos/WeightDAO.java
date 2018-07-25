package com.revature.caliber.daos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.caliber.beans.Weight;

@Repository
public interface WeightDAO extends JpaRepository<Weight, Long>{

	
}
