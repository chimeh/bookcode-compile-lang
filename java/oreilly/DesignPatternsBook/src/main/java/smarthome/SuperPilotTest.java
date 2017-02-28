package smarthome;

import smarthome.drivers.*;
import smarthome.orders.*;

public class SuperPilotTest {

    public static void main(String[] args) {

        SuperPilot pilot = new SuperPilot();

        GardenWatering gardenWatering = new GardenWatering();
        Jacuzzi jacuzzi = new Jacuzzi();
        Light light = new Light();
        OutsideLight outsideLight = new OutsideLight();
        Stereo stereo = new Stereo();
        TapDriver tapDriver = new TapDriver();
        TV tv = new TV();
        CeilingFan ceilingFan = new CeilingFan("Bedroom");

        TurnOnGardenWateringOrder turnOnGardenWateringOrder = new TurnOnGardenWateringOrder(gardenWatering);
        TurnOffGardenWateringOrder turnOffGardenWateringOrder = new TurnOffGardenWateringOrder(gardenWatering);

        TurnOnJacuzziOrder turnOnJacuzziOrder = new TurnOnJacuzziOrder(jacuzzi);
        TurnOffJacuzziOrder turnOffJacuzziOrder = new TurnOffJacuzziOrder(jacuzzi);

        TurnOnLightOrder turnOnLightOrder = new TurnOnLightOrder(light);
        TurnOffLightOrder turnOffLightOrder = new TurnOffLightOrder(light);

        TurnOnOutsideLightOrder turnOnOutsideLightOrder = new TurnOnOutsideLightOrder(outsideLight);
        TurnOffOutsideLightOrder turnOffOutsideLightOrder = new TurnOffOutsideLightOrder(outsideLight);

        TurnOnCDStereoOrder turnOnCDStereoOrder = new TurnOnCDStereoOrder(stereo);
        TurnOffStereoOrder turnOffStereoOrder = new TurnOffStereoOrder(stereo);

        TurnOnTapDriverOrder turnOnTapDriverOrder = new TurnOnTapDriverOrder(tapDriver);
        TurnOffTapDriverOrder turnOffTapDriverOrder = new TurnOffTapDriverOrder(tapDriver);

        TurnOnTVOrder turnOnTVOrder = new TurnOnTVOrder(tv);
        TurnOffTVOrder turnOffTVOrder = new TurnOffTVOrder(tv);

        MediumSpeedCeilingFanOrder mediumSpeedCeilingFanOrder = new MediumSpeedCeilingFanOrder(ceilingFan);
        FastSpeedCeilingFanOrder fastSpeedCeilingFanOrder = new FastSpeedCeilingFanOrder(ceilingFan);
        TurnOffCeilingFanOrder turnOffCeilingFanOrder = new TurnOffCeilingFanOrder(ceilingFan);

        pilot.setOrder(0, mediumSpeedCeilingFanOrder, turnOffCeilingFanOrder);
        pilot.setOrder(1, fastSpeedCeilingFanOrder, turnOffCeilingFanOrder);
        pilot.setOrder(2, turnOnLightOrder, turnOffLightOrder);
        pilot.setOrder(3, turnOnOutsideLightOrder, turnOffOutsideLightOrder);
        pilot.setOrder(4, turnOnCDStereoOrder, turnOffStereoOrder);
        pilot.setOrder(5, turnOnTapDriverOrder, turnOffTapDriverOrder);
        pilot.setOrder(6, turnOnTVOrder, turnOffTVOrder);

        pilot.onButtonPressed(0);
        pilot.undoButtonPressed();
        pilot.onButtonPressed(2);
        pilot.onButtonPressed(4);
        pilot.onButtonPressed(6);
        System.out.println(pilot);
        pilot.undoButtonPressed();

        pilot.offButtonPressed(1);
        pilot.offButtonPressed(3);
        pilot.offButtonPressed(5);
    }
}
