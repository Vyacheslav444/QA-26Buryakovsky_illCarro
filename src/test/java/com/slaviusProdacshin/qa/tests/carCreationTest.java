package com.slaviusProdacshin.qa.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class carCreationTest extends TestBase{
    @Test
    public void testCarCreation(){
        app.getCarHelper().initAddingNewCar();
        Assert.assertTrue(app.getCarHelper().isCarCreationFormPresent());
        //app.getCarHelper().fillCarForm("TelAviv", address, distance, serial_number, brand, model, year, engine, fuel_consumpion, fuel, transmition, wD, horsepower, torque, doors, seats, clasS, about, feature, fuel_consumption, price);
        //app.getCarHelper().clickYallaButton();
        app.getCarHelper().fillCarForm("Israel","Herzel","500",
                "2333359895","Civic","Honda","2015","4554545","6",
                "disel","auto","wD","577","120","2",
        "4","A","ss","or","50");
        app.getCarHelper().clickYallaButton();
    }


}
