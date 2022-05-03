package repository;

import entityFactory.EntityFactory;
import entityFactoryImpl.EntityFactoryImpl;
import model.Education;
import model.UserDetail;

import java.util.List;

public interface EducationRepository {

    EntityFactory entityFactory = new EntityFactoryImpl();

    Boolean saveEducation(Education education);

    Boolean updateEducation(Education education);

    Boolean removeEducation(Education education);

    Education findById(Integer id);

    List<Education> findEducation();

    Education findWithAdvertisementById(Integer id);
}
