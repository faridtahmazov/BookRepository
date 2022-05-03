package serviceImpl;

import model.Education;
import repository.EducationRepository;
import repositoryImpl.EducationRepositoryImpl;
import service.EducationService;

import java.util.List;

public class EducationServiceImpl implements EducationService {
    private EducationRepository educationRepository = new EducationRepositoryImpl();

    @Override
    public Boolean saveEducation(Education education) {
        return this.educationRepository.saveEducation(education);
    }

    @Override
    public Boolean updateEducation(Education education) {
        return this.educationRepository.updateEducation(education);
    }

    @Override
    public Boolean removeEducation(Education education) {
        return this.educationRepository.removeEducation(education);
    }

    @Override
    public Education findById(Integer id) {
        return this.educationRepository.findById(id);
    }

    @Override
    public List<Education> findEducation() {
        return this.educationRepository.findEducation();
    }

    @Override
    public Education findWithAdvertisementById(Integer id) {
        return this.educationRepository.findWithAdvertisementById(id);
    }
}
