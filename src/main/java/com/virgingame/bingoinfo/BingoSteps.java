package com.virgingame.bingoinfo;

import net.thucydides.core.annotations.Step;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import com.virgingame.constants.EndPoints;
import io.restassured.http.ContentType;



public class BingoSteps {
    @Step("Get all information")
    public ValidatableResponse getLiveFrequencyInfo(){

        return SerenityRest.rest()
                .given().log().all()
                .contentType(ContentType.TEXT)
                .when()
                .get(EndPoints.END_POINT)
                .then().log().all();

    }
}
