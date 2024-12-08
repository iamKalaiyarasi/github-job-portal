package com.job.portal.project.services;

import com.job.portal.project.entity.RecruiterProfile;
import com.job.portal.project.entity.Users;
import com.job.portal.project.repository.RecruiterProfileRepositiry;
import com.job.portal.project.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RecruiterProfileService {

    private final RecruiterProfileRepositiry recruiterProfileRepositiry;

    private final UsersRepository usersRepository;

    @Autowired
    public RecruiterProfileService(RecruiterProfileRepositiry recruiterProfileRepositiry, UsersRepository usersRepository) {
        this.recruiterProfileRepositiry = recruiterProfileRepositiry;
        this.usersRepository = usersRepository;
    }

    public Optional<RecruiterProfile> getOne(Integer id){
        return recruiterProfileRepositiry.findById(id);
    }

    public RecruiterProfile addNew(RecruiterProfile recruiterProfile) {
        return recruiterProfileRepositiry.save(recruiterProfile);
    }

    public RecruiterProfile getCurrentRecruiterProfile() {
      Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
      if (!(authentication instanceof AnonymousAuthenticationToken)){
        String currentUsername =  authentication.getName();
       Users users = usersRepository.findByEmail(currentUsername).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        Optional<RecruiterProfile> recruiterProfile = getOne(users.getUserId());
        return  recruiterProfile.orElse(null);
      } else return null;
    }
}
