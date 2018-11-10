package com.landlordcommunication.web;

import com.landlordcommunication.web.models.Residence;
import com.landlordcommunication.web.models.User;
import com.landlordcommunication.web.repositories.residence.ResidenceRepository;
import com.landlordcommunication.web.services.residence.ResidenceServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.ZonedDateTime;
import java.time.temporal.TemporalAmount;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.landlordcommunication.web.repositories.residence.SqlResidenceRepository.addOneMonth;

@RunWith(MockitoJUnitRunner.class)
public class ResidenceServiceImplTests {

    @Mock
    ResidenceRepository mockResidenceRepository;

    @InjectMocks
    ResidenceServiceImpl residenceService;

    private List<Residence> mockResidenceList;

    @Before
    public void setUp() {

        mockResidenceList = Arrays.asList(
                new Residence(1, "address1", 100, new Date(), new Date(), "picture1"),
                new Residence(2, "address2", 200, new Date(), new Date(), "picture2"),
                new Residence(3, "address3", 300, new Date(), new Date(), "picture3"),
                new Residence(4, "address4", 400, new Date(), new Date(), "picture4"),
                new Residence(5, "address5", 500, new Date(), new Date(), "picture5"));

        List<User> mockUserList = Arrays.asList(
                new User(1, "email1", "firstName1", "surname1", true, 1000, "password1", "picture1"),
                new User(2, "email2", "firstName2", "surname2", true, 2000, "password2", "picture2"),
                new User(3, "email3", "firstName3", "surname3", true, 3000, "password3", "picture3"));

        mockResidenceList.get(0).setUsers(mockUserList);
        mockResidenceList.get(1).setUsers(mockUserList);
        mockResidenceList.get(2).setUsers(mockUserList);
        mockResidenceList.get(3).setUsers(mockUserList);
        mockResidenceList.get(4).setUsers(mockUserList);

        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void getResidencesByUser_getAllResidencesByGivenUserId(){
        //Arrange
        List<Residence> residencesForUserIdOne = new ArrayList<>();
        residencesForUserIdOne.add(mockResidenceList.get(0));
        residencesForUserIdOne.add(mockResidenceList.get(1));
        Mockito.when(mockResidenceRepository.getResidencesByUser(1))
                .thenReturn(residencesForUserIdOne);

        //Act
        List<Residence> result = residenceService.getResidencesByUser(1);

        //Assert
        Assert.assertEquals(result,residencesForUserIdOne);
    }

    @Test
    public void changeResidenceDates_UpdateRentDueDateOnPaymentByTenant(){
        //Arrange
        Residence residenceToUpdate = mockResidenceList.get(0);
        residenceToUpdate.setDueDate(addOneMonth(residenceToUpdate.getDueDate()));
        Mockito.when(mockResidenceRepository.changeResidenceDates(0))
                .thenReturn(residenceToUpdate);

        //Act
        Residence result = residenceService.changeResidenceDates(0);

        //Assert
        Assert.assertEquals(result.getDueDate(), residenceToUpdate.getDueDate());
    }

    }


