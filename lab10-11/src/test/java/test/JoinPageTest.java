package test;

import model.Participant;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.JoinPage;
import service.ParticipantCreator;

public class JoinPageTest extends CommonConditions{

    private static final String ERROR_EXPECTED_TEXT = "Something went wrong, and your request wasn't submitted. Please try again later.";

    //№1
    @Test
    public void joinWithIncorrectDataTest() {
        Participant participant = ParticipantCreator.createParticipant();

        String actualError =
                new JoinPage(driver)
                .openPage()
                .fillParticipantForm(participant)
                .pressFindButton()
                .getErrorMessage();

        Assert.assertEquals(ERROR_EXPECTED_TEXT, actualError);
    }
}
