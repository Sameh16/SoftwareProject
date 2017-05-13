package com.GameForAll.Repository;

import org.springframework.data.repository.CrudRepository;

import com.GameForAll.models.Contributor;
import com.GameForAll.models.ContributorID;

public interface ContributorRepository extends CrudRepository<Contributor, ContributorID> {

	Contributor findByTeacherUsername(String username);

}
