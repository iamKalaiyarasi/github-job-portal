package com.job.portal.project.services;

import com.job.portal.project.entity.RecruiterProfile;
import com.job.portal.project.repository.RecruiterProfileRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {

    private final RecruiterProfileRepositiry recruiterProfileRepositiry;

    @Autowired
    public RecruiterProfileService(RecruiterProfileRepositiry recruiterProfileRepositiry) {
        this.recruiterProfileRepositiry = recruiterProfileRepositiry;
    }

    public Optional<RecruiterProfile> getOne(Integer id){
        return recruiterProfileRepositiry.findById(id);
    }

    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepositiry.save(recruiterProfile);
    }
}
