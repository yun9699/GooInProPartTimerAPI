package org.gooinpro.gooinproparttimerapi.jobpostingsapplication.repository;

import org.gooinpro.gooinproparttimerapi.jobpostingsapplication.domain.JobPostingsApplicationEntity;
import org.gooinpro.gooinproparttimerapi.jobpostingsapplication.repository.search.JobPostingsApplicationSearch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPostingsApplicationRepository extends JpaRepository<JobPostingsApplicationEntity, Long>, JobPostingsApplicationSearch {
}
