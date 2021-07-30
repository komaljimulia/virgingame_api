package com.virgingame.testsuite;

import com.virgingame.bingoinfo.BingoSteps;
import com.virgingame.testbase.TestBase;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.assertj.core.api.Assertions.assertThat;


@RunWith(SerenityRunner.class)
public class BingoCRUDTest extends TestBase {
    @Steps
    BingoSteps bingoSteps;


    @Test
    public void getAllLiveFeedAndAssertDefaultGameFre(){
        ValidatableResponse response =
                bingoSteps.getLiveFrequencyInfo().statusCode( 200 );
        int gameFrequency = response.extract().jsonPath().getInt("bingoLobbyInfoResource.streams[6].defaultGameFrequency");
        assertThat(gameFrequency,equalTo(300000));
        System.out.println("Game frequency Is :  "    +gameFrequency);
    }
    @Test
    public void getAllLiveFeedAndAssertStartTime(){
        ValidatableResponse response =

                bingoSteps.getLiveFrequencyInfo().statusCode( 200 );
        long startTime = response.extract().jsonPath().getLong( "bingoLobbyInfoResource.streams[6].startTime" );
        assertThat(startTime).isGreaterThanOrEqualTo( 1627415700000L );

        System.out.println("Start time is :  " +startTime);


    }


}
