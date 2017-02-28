package smarthome;

import smarthome.drivers.Jacuzzi;
import smarthome.drivers.Light;
import smarthome.drivers.Stereo;
import smarthome.drivers.TV;
import smarthome.orders.*;

public class PartyTest {

    public static void main(String[] args) {

        SuperPilot pilot = new SuperPilot();

        Light light = new Light();
        TV tv = new TV();
        Stereo stereo = new Stereo();
        Jacuzzi jacuzzi = new Jacuzzi();

        TurnOnLightOrder turnOnLightOrder = new TurnOnLightOrder(light);
        TurnOffLightOrder turnOffLightOrder = new TurnOffLightOrder(light);

        TurnOnTVOrder turnOnTVOrder = new TurnOnTVOrder(tv);
        TurnOffTVOrder turnOffTVOrder = new TurnOffTVOrder(tv);

        TurnOnCDStereoOrder turnOnCDStereoOrder = new TurnOnCDStereoOrder(stereo);
        TurnOffStereoOrder turnOffStereoOrder = new TurnOffStereoOrder(stereo);

        TurnOnJacuzziOrder turnOnJacuzziOrder = new TurnOnJacuzziOrder(jacuzzi);
        TurnOffJacuzziOrder turnOffJacuzziOrder = new TurnOffJacuzziOrder(jacuzzi);

        Order[] turnOnParty = {turnOnLightOrder, turnOnTVOrder, turnOnCDStereoOrder, turnOnJacuzziOrder};
        Order[] turnOffParty = {turnOffLightOrder, turnOffTVOrder, turnOffStereoOrder, turnOffJacuzziOrder};

        MakroOrder makroOrderOn = new MakroOrder(turnOnParty);
        MakroOrder makroOrderOff = new MakroOrder(turnOffParty);

        pilot.setOrder(0, makroOrderOn, makroOrderOff);
        pilot.onButtonPressed(0);
        System.out.println("---------------------------------------------------");
        pilot.offButtonPressed(0);
        System.out.println("----------------------undo-----------------------------");
        pilot.undoButtonPressed();
    }
}
