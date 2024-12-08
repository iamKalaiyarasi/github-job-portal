package com.job.portal.project.repository;

import com.job.portal.project.entity.JobPostActivity;
import com.job.portal.project.entity.JobSeekerProfile;
import com.job.portal.project.entity.JobSeekerSave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobSeekerSaveRepository extends JpaRepository<JobSeekerSave, Integer> {

      List<JobSeekerSave> findByUserId(JobSeekerProfile userAccountId);

         List<JobSeekerSave> findByJob(JobPostActivity job);

}
