package service;

import model.Education;

import java.util.List;

public interface EducationService {
    Boolean saveEducation(Education education);

    Boolean updateEducation(Education education);

    Boolean removeEducation(Education education);

    Education findById(Integer id);

    List<Education> findEducation();

    Education findWithAdvertisementById(Integer id);
}
