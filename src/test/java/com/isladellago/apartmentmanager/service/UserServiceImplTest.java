package com.isladellago.apartmentmanager.service;

import com.isladellago.apartmentmanager.TestUtils;
import com.isladellago.apartmentmanager.domain.model.User;
import com.isladellago.apartmentmanager.domain.model.UserRepository;
import com.isladellago.apartmentmanager.exception.UserNotFoundException;
import com.isladellago.apartmentmanager.service.impl.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @Before
    public final void initMocks() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public final void testGetUserByEmail() {
        final User userMock = TestUtils.getUserByEmail1();

        Mockito.when(userRepository.findByEmail(TestUtils.USER_EMAIL))
                .thenReturn(Optional.of(userMock));

        final User user = userService.getUserByEmail(TestUtils.USER_EMAIL);

        Assert.assertNotNull(user);
        Assert.assertEquals(userMock, user);
    }

    @Test(expected = UserNotFoundException.class)
    public final void testGetUserByEmailNotFound() {
        Mockito.when(userRepository.findByEmail(TestUtils.USER_EMAIL))
                .thenReturn(Optional.empty());

        userService.getUserByEmail(TestUtils.USER_EMAIL);
    }
}
