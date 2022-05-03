package serviceImpl;

import model.Advertisements;
import repository.AdvertisementsRepository;
import repositoryImpl.AdvertisementsRepositoryImpl;
import service.AdvertisementsService;

import java.util.List;

public class AdvertisementsServiceImpl implements AdvertisementsService {

    private AdvertisementsRepository advertisementsRepository = new AdvertisementsRepositoryImpl();

    @Override
    public Boolean saveAdvertisement(Advertisements advertisements) {
        return this.advertisementsRepository.saveAdvertisement(advertisements);
    }

    @Override
    public Boolean updateAdvertisement(Advertisements advertisements) {
        return this.advertisementsRepository.updateAdvertisement(advertisements);
    }

    @Override
    public Boolean removeAdvertisement(Advertisements advertisements) {
        return this.advertisementsRepository.removeAdvertisement(advertisements);
    }

    @Override
    public Advertisements findById(Integer id) {
        return this.advertisementsRepository.findById(id);
    }

    @Override
    public List<Advertisements> findByUsername(String username) {
        return this.advertisementsRepository.findByUsername(username);
    }

    @Override
    public List<Advertisements> findAdvertisements() {
        return this.advertisementsRepository.findAdvertisements();
    }

    @Override
    public List<Advertisements> findAdvertisementEntities(Integer firstResult, Integer maxResult) {
        return this.advertisementsRepository.findAdvertisementEntities(firstResult, maxResult);
    }
}
