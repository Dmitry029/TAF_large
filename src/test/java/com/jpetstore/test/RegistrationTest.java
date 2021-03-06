package com.jpetstore.test;

import com.github.javafaker.Faker;
import com.jpetstore.steps.JPetStoreSteps;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.jpetstore.tags.JPetStoreTags.REGISTRATION;
import static com.jpetstore.tags.JPetStoreTags.REGRESSION;
import static org.junit.jupiter.api.Assertions.assertEquals;


@Tag(REGRESSION)
public class RegistrationTest extends JPetStoreSteps {

    @Tag(REGISTRATION)
    //@RepeatedIfExceptionsTest(repeats = 1)
    @Test
    @DisplayName("Add a new user to the store & verify if the user can login")
    void addNewUserToStoreAndVerifyLogin() {

        Faker faker = new Faker();

        String userName = "John3" + faker.number()
                .randomNumber(6, false);
        String password = faker.internet().password();
        String repeatPassword = password;
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String phone = faker.phoneNumber().cellPhone();
        String addr1 = faker.address().buildingNumber();
        String addr2 = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().state();
        String ziipCode = faker.address().zipCode();
        String country = faker.address().country();

        navigateToApp();
        navigateToSignInPage();
        navigateRegistrationPage();

        setNewUserInformation(userName, password, repeatPassword);
        addAccountInformation(firstName, lastName, email, phone, addr1, addr2,
                city, state, ziipCode, country);

        addProfileInformation("english", "CATS", true, true);
        clickSaveAccountInformation();


        //Login & verify account creation
        doLogin(userName, password);
        String greetingMsg = getGreetingMessage();

        assertEquals("Welcome " + firstName + "!", greetingMsg);
    }
}
