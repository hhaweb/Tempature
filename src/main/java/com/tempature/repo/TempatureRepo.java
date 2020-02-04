package com.tempature.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tempature.model.Tempature;


@Repository
public interface TempatureRepo extends JpaRepository<Tempature, Long>{

}
