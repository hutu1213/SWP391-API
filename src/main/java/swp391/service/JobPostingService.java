package swp391.service;

import swp391.dto.jobPosting.ModifiJobPostingDto;
import swp391.entity.JobPosting;

import java.util.List;

public interface JobPostingService {
    List<JobPosting> getAll();

    boolean isExisted(String id);

    JobPosting create(ModifiJobPostingDto dto);
}
