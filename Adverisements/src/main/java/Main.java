import model.Advertisements;
import model.Education;
import model.User;
import model.UserDetail;
import service.AdvertisementsService;
import service.EducationService;
import service.UserDetailService;
import service.UserService;
import serviceImpl.AdvertisementsServiceImpl;
import serviceImpl.EducationServiceImpl;
import serviceImpl.UserDetailServiceImpl;
import serviceImpl.UserServiceImpl;

public class Main {
    private static AdvertisementsService advertisementsService = new AdvertisementsServiceImpl();
    private static EducationService educationService = new EducationServiceImpl();
    private static UserDetailService userDetailService = new UserDetailServiceImpl();
    private static UserService userService = new UserServiceImpl();

    public static void main(String[] args) {
        insertData();
    }

    public static void insertData(){
        Advertisements advertisements1 = new Advertisements();
        Advertisements advertisements2 = new Advertisements();
        Advertisements advertisements3 = new Advertisements();
        Advertisements advertisements4 = new Advertisements();

        Education education1 = new Education();
        Education education2 = new Education();
        Education education3 = new Education();
        Education education4 = new Education();
        Education education5 = new Education();

        User user1 = new User();
        User user2 = new User();
        User user3 = new User();
        User user4 = new User();
        User user5 = new User();
        User user6 = new User();
        User user7 = new User();
        User user8 = new User();
        User user9 = new User();

        UserDetail userDetail1 = new UserDetail();
        UserDetail userDetail2 = new UserDetail();
        UserDetail userDetail3 = new UserDetail();
        UserDetail userDetail4 = new UserDetail();
        UserDetail userDetail5 = new UserDetail();
        UserDetail userDetail6 = new UserDetail();
        UserDetail userDetail7 = new UserDetail();
        UserDetail userDetail8 = new UserDetail();
        UserDetail userDetail9 = new UserDetail();

        advertisementsService.saveAdvertisement(advertisements1);
        advertisementsService.saveAdvertisement(advertisements2);
        advertisementsService.saveAdvertisement(advertisements3);
        advertisementsService.saveAdvertisement(advertisements4);

        educationService.saveEducation(education1);
        educationService.saveEducation(education2);
        educationService.saveEducation(education3);
        educationService.saveEducation(education4);
        educationService.saveEducation(education5);

        userService.saveUser(user1);
        userService.saveUser(user2);
        userService.saveUser(user3);
        userService.saveUser(user4);
        userService.saveUser(user5);
        userService.saveUser(user6);
        userService.saveUser(user7);
        userService.saveUser(user8);
        userService.saveUser(user9);

        userDetailService.saveUserDetail(userDetail1);
        userDetailService.saveUserDetail(userDetail2);
        userDetailService.saveUserDetail(userDetail3);
        userDetailService.saveUserDetail(userDetail4);
        userDetailService.saveUserDetail(userDetail5);
        userDetailService.saveUserDetail(userDetail6);
        userDetailService.saveUserDetail(userDetail7);
        userDetailService.saveUserDetail(userDetail8);
        userDetailService.saveUserDetail(userDetail9);
    }
}
