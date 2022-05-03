package repository;

import entityFactory.EntityFactory;
import entityFactoryImpl.EntityFactoryImpl;
import model.Advertisements;
import java.util.List;

public interface AdvertisementsRepository {

    EntityFactory entityFactory = new EntityFactoryImpl();

    Boolean saveAdvertisement(Advertisements advertisements);

    Boolean updateAdvertisement(Advertisements advertisements);

    Boolean removeAdvertisement(Advertisements advertisements);

    Advertisements findById(Integer id);

    List<Advertisements> findByUsername(String username);

    List<Advertisements> findAdvertisements();

    List<Advertisements> findAdvertisementEntities(Integer firstResult, Integer maxResult);
}
