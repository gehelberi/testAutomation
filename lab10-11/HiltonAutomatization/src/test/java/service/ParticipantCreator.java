package service;

import model.Participant;

public class ParticipantCreator {
    private static final String TEST_DATA_FIRST_NAME = "testdata.participant.firstName";
    private static final String TEST_DATA_LAST_NAME = "testdata.participant.lastName";
    private static final String TEST_DATA_PHONE = "testdata.participant.phone";
    private static final String TEST_DATA_MAIL = "testdata.participant.mail";
    private static final String TEST_DATA_ADDRESS = "testdata.participant.address";
    private static final String TEST_DATA_CITY = "testdata.participant.city";
    private static final String TEST_DATA_PASSWORD = "testdata.participant.password";
    private static final String TEST_DATA_PASSWORD_CONFIRM = "testdata.participant.passwordConfirm";
    private static final String TEST_DATA_COUNTRY = "testdata.participant.country";

    public static Participant createParticipant(){
        return new Participant(TestDataReader.getTestData(TEST_DATA_FIRST_NAME),
                TestDataReader.getTestData(TEST_DATA_LAST_NAME),
                TestDataReader.getTestData(TEST_DATA_PHONE),
                TestDataReader.getTestData(TEST_DATA_MAIL),
                TestDataReader.getTestData(TEST_DATA_ADDRESS),
                TestDataReader.getTestData(TEST_DATA_CITY),
                TestDataReader.getTestData(TEST_DATA_PASSWORD),
                TestDataReader.getTestData(TEST_DATA_PASSWORD_CONFIRM),
                TestDataReader.getTestData(TEST_DATA_COUNTRY)
        );
    }
}
