package com.landlordcommunication.web;

import com.landlordcommunication.web.models.AuthorisationInfo;
import com.landlordcommunication.web.models.LoginInfo;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.repositories.user.UserRepository;
import com.landlordcommunication.web.services.user.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import java.util.Arrays;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTests {

    @Mock
    UserRepository mockUserRepository;

    @InjectMocks
    UserServiceImpl service;

    private List<User> defaultTestInput;

    @Before
    public void setUp(){

        defaultTestInput = Arrays.asList(
                new User(1, "email1", "firstName1", "surname1", true, 1000, "password1", "picture1"),
                new User(2, "email2", "firstName2", "surname2", true, 2000, "password2", "picture2"),
                new User(3, "email3", "firstName3", "surname3", true, 3000, "password3", "picture3"),
                new User(4, "email4", "firstName4", "surname4", true, 4000, "password4", "picture4"),
                new User(5, "email5", "firstName5", "surname5", true, 5000, "password5", "picture5")
        );



        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getUserById_GetUserWithProvidedId_IfUserExistsInDBt(){
        //Arrange
        Mockito.when(mockUserRepository.getUserById(1))
                .thenReturn(defaultTestInput.get(0));

        //Act
        User result = service.getUserById(1);

        //Assert
        Assert.assertEquals(result,defaultTestInput.get(0));
    }

    @Test
    public void getUserById_GetNullObject_IfNoSuchUser(){
        //Arrange
        Mockito.when(mockUserRepository.getUserById(20))
                .thenReturn(null);

        //Act
        User result = service.getUserById(20);

        //Assert
        Assert.assertNull(result);

    }

    @Test
    public void getUserByEmail_GetAuthorisationInfoForUser_IfUserExistsInDb(){
        //Arrange
        LoginInfo loginInfo = new LoginInfo("email1", "password1");
        Mockito.when(mockUserRepository.getUserByEmail(loginInfo))
                .thenReturn(defaultTestInput.get(0));
        //Act
        AuthorisationInfo result = service.getUserByEmail(loginInfo);

        //Assert
        Assert.assertEquals(result.getError(), new AuthorisationInfo(1, true, "email1").getError());

    }

    @Test
    public void getUserByEmail_GetAuthorisationInfoWithError_IfUserDoesNotExist(){
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
    public void getUserByEmail_GetAuthorisationInfoWithError_IfPasswordDoesNotMatch(){
        //Arrange
        LoginInfo loginInfo = new LoginInfo("email1", "password6");
        Mockito.when(mockUserRepository.getUserByEmail(loginInfo))
                .thenReturn(defaultTestInput.get(0));

        //Act
        AuthorisationInfo result = service.getUserByEmail(loginInfo);

        //Assert
        Assert.assertEquals(result.getError(), new AuthorisationInfo(-1, false, "No such username or password").getError());
    }






}
