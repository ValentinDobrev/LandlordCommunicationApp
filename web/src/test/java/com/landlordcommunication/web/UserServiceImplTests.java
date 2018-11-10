package com.landlordcommunication.web;

import com.landlordcommunication.web.models.*;
import com.landlordcommunication.web.repositories.user.UserRepository;
import com.landlordcommunication.web.services.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import static org.hamcrest.CoreMatchers.*;
import java.util.*;
import java.util.stream.Collectors;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserServiceImpl service;

    private List<User> mockUserList;

    private Map<Integer, Integer> mockMapUsersToResidences;

    @Before
    public void setUp() {

        mockUserList = Arrays.asList(
                new User(1, "email1", "firstName1", "surname1", true, 1000, "password1", "picture1"),
                new User(2, "email2", "firstName2", "surname2", true, 2000, "password2", "picture2"),
                new User(3, "email3", "firstName3", "surname3", true, 3000, "password3", "picture3"),
                new User(4, "email4", "firstName4", "surname4", false, 4000, "password4", "picture4"),
                new User(5, "email5", "firstName5", "surname5", true, 5000, "password5", "picture5")
        );

        List<Residence> mockResidences = new ArrayList<>();
        mockResidences.add(new Residence(1, "address1", 100, new Date(), new Date(), "picture1"));
        mockResidences.add(new Residence(2, "address2", 200, new Date(), new Date(), "picture2"));

        mockUserList.get(0).setResidences(mockResidences);
        mockUserList.get(1).setResidences(mockResidences);
        mockUserList.get(2).setResidences(mockResidences);
        mockUserList.get(3).setResidences(mockResidences);
        mockUserList.get(4).setResidences(mockResidences);


        //Key: User ID, Value: Residence ID
        /*mockMapUsersToResidences = new TreeMap<>();
        mockMapUsersToResidences.put(1, 1);
        mockMapUsersToResidences.put(2, 1);
        mockMapUsersToResidences.put(3, 2);
        mockMapUsersToResidences.put(4, 2);
        mockMapUsersToResidences.put(5, 3);*/

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getUserById_GetUserWithProvidedId_UserExistsInDb() {
        //Arrange
        Mockito.when(mockUserRepository.getUserById(1))
                .thenReturn(mockUserList.get(0));

        //Act
        User result = service.getUserById(1);

        //Assert
        Assert.assertEquals(result, mockUserList.get(0));
    }

    @Test
    public void getUserById_GetNullObject_NoSuchUserInDb() {
        //Arrange
        Mockito.when(mockUserRepository.getUserById(20))
                .thenReturn(null);

        //Act
        User result = service.getUserById(20);

        //Assert
        Assert.assertNull(result);

    }

    @Test
    public void getUserByEmail_GetAuthorisationInfoForUser_UserExistsInDb() {
        //Arrange
        LoginInfo loginInfo = new LoginInfo("email1", "password1");
        Mockito.when(mockUserRepository.getUserByEmail(loginInfo))
                .thenReturn(mockUserList.get(0));
        //Act
        AuthorisationInfo result = service.getUserByEmail(loginInfo);

        //Assert
        Assert.assertEquals(result.getError(), new AuthorisationInfo(1, true, "email1").getError());

    }

    @Test
    public void getUserByEmail_GetAuthorisationInfoWithError_UserDoesNotExistInDb() {
        //Arrange
        LoginInfo loginInfo = new LoginInfo("email6", "password1");
        Mockito.when(mockUserRepository.getUserByEmail(loginInfo))
                .thenReturn(null);

        //Act
        AuthorisationInfo result = service.getUserByEmail(loginInfo);

        //Assert
        Assert.assertEquals(result.getError(), new AuthorisationInfo(-1, false, "No such username or password").getError());
    }

    @Test
    public void getUserByEmail_GetAuthorisationInfoWithError_PasswordDoesNotMatch() {
        //Arrange
        LoginInfo loginInfo = new LoginInfo("email1", "password6");
        Mockito.when(mockUserRepository.getUserByEmail(loginInfo))
                .thenReturn(mockUserList.get(0));

        //Act
        AuthorisationInfo result = service.getUserByEmail(loginInfo);

        //Assert
        Assert.assertEquals(result.getError(), new AuthorisationInfo(-1, false, "No such username or password").getError());
    }


    @Test
    public void getAllUsers_GetFullListOfUsers_RepositoryResponding() {
        //Arrange
        Mockito.when(mockUserRepository.getAllUsers()).thenReturn(mockUserList);

        //Act
        List<User> result = service.getAllUsers();

        //Assert
        Assert.assertEquals(result, mockUserList);

    }

    @Test
    public void getAllUsers_GetFullListOfUsers_RepositoryNotResponding() {
        //Arrange
        Mockito.when(mockUserRepository.getAllUsers()).thenReturn(null);

        //Act
        List<User> result = service.getAllUsers();

        //Assert
        Assert.assertNull(result);

    }


    @Test
    public void getAllTenants_GetTenantsListWithoutLandlordUsers_RepositoryResponding() {
        //Arrange
        Mockito.when(mockUserRepository.getAllTenants())
                .thenReturn(mockUserList.stream()
                        .filter(User::getIsTenant)
                        .collect(Collectors.toList()));

        //Act
        List<User> result = service.getAllTenants();

        //Assert
        Assert.assertEquals(4, result.size());
        //Because there's only 1 landlord and 4 tenants out of 5 mock users

    }

    @Test
    public void getAllTenants_GetLandlordsListWithoutTenantUsers_RepositoryResponding() {
        //Arrange
        Mockito.when(mockUserRepository.getAllLandlords())
                .thenReturn(mockUserList.stream()
                        .filter(user -> !user.getIsTenant())
                        .collect(Collectors.toList()));

        //Act
        List<User> result = service.getAllLandlords();

        //Assert
        Assert.assertEquals(1, result.size());
        //Because there's only 1 landlord and 4 tenants out of 5 mock users

    }

    @Test
    public void getUsersByResidence_getAllUsersAssociatedWithGivenResidenceId_IdExists(){
        //Arrange
        List<User> usersFromResidenceIdOne = new ArrayList<>();
        usersFromResidenceIdOne.add(mockUserList.get(0));
        usersFromResidenceIdOne.add(mockUserList.get(1));
        Mockito.when(mockUserRepository.getUsersByResidence(1))
                .thenReturn(usersFromResidenceIdOne);

        //Act
        List<User> result = service.getUsersByResidence(1);

        //Assert
        Assert.assertEquals(result,usersFromResidenceIdOne);
    }

    @Test
    public void getUsersByResidence_getAllUsersAssociatedWithGivenResidenceId_IdDoesNotExist(){
        //Arrange
        Mockito.when(mockUserRepository.getUsersByResidence(10))
                .thenReturn(null);

        //Act
        List<User> result = service.getUsersByResidence(10);

        //Assert
        Assert.assertNull(result);
    }

    @Test
    public void getRentNotificationInfo_getNotificationInfoListForAllUsersPerTheirResidences(){
        //Arrange
        List<RentNotificationInfo> rentNotificationInfoList = new ArrayList<>();
        for (User user : mockUserList) {
            if(user.getIsTenant()) {
                rentNotificationInfoList.add(new RentNotificationInfo(
                        user.getEmail(),
                        user.getResidences()));
            }
        }

        Mockito.when(mockUserRepository.getAllTenants()).thenReturn(mockUserList.stream()
                .filter(User::getIsTenant)
                .collect(Collectors.toList()));


        //Act
        List<RentNotificationInfo> result = service.getRentNotificationInfo();


        //Assert
        Assert.assertEquals(rentNotificationInfoList.size(), result.size());
    }



}
