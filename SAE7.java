/* ***************************************
  Name : James Moreby
  Date : 20/11/2021
  Version: 1

    This program uses records in order to store the user input
    and once again perform comparisons between the values
    provided and valid values. Each leg that is entered should
    have specific values for each if the values are different then
    the program will let the user know of the discrepancy.

  *************************************** */

import java.util.*;

public class SAE7 {

    public static class paralympicTeam{
        int leg1;
        int leg2;
        int leg3;
        int leg4;
        String country;
    }

    public static paralympicTeam paralympicTeamInit(String country, int leg1, int leg2, int leg3, int leg4) {
        paralympicTeam relayTeam = new paralympicTeam();
        relayTeam.leg1 = leg1;
        relayTeam.leg2 = leg2;
        relayTeam.leg3 = leg3;
        relayTeam.leg4 = leg4;
        relayTeam.country = country;
        return relayTeam;
    }

    public static int getLeg1(paralympicTeam relayTeam){
        return relayTeam.leg1;
    }

    public static int getLeg2(paralympicTeam relayTeam){
        return relayTeam.leg2;
    }

    public static int getLeg3(paralympicTeam relayTeam){
        return relayTeam.leg3;
    }

    public static int getLeg4(paralympicTeam relayTeam){
        return relayTeam.leg4;
    }

    public static String getCountry(paralympicTeam relayTeam){
        return relayTeam.country;
    }

    public static void check(int leg1, int leg2, int leg3, int leg4){
        if (!(leg1 == 11 || leg1 == 13)){
            System.out.println("Leg 1 (T" + leg1 + ") is not legal." );
        }

        if (!(leg2 == 61 || leg2 == 62)){
            System.out.println("Leg 2 (T" + leg2 + ") is not legal." );
        }

        if (!(leg3 == 35 || leg3 == 36)){
            System.out.println("Leg 3 (T" + leg3 + ") is not legal." );
        }

        if (!(leg4 == 51 || leg4 == 52)){
            System.out.println("Leg 4 (T" + leg4 + ") is not legal." );
        }
    }
    
    public static void Relay() {
        List<Integer> disabilityclasseslist = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        System.out.print("What is the classification (maximum points) of this relay event? ");
        String MaximumPoints = in.nextLine();
        System.out.print("What country is the team representing? ");
        String country = in.nextLine();
        for (int i = 1; i <=4; i++) {
            System.out.print("What is the disability class for leg " + i + "? ");
            int disabilityClass = in.nextInt();
            disabilityclasseslist.add(disabilityClass);
        }
        int leg1 = disabilityclasseslist.get(0);
        int leg2 = disabilityclasseslist.get(1);
        int leg3 = disabilityclasseslist.get(2);
        int leg4 = disabilityclasseslist.get(3);
        paralympicTeam relayTeam = paralympicTeamInit(country, leg1, leg2, leg3, leg4);

        System.out.printf("The %s team is: Leg 1, T%d; Leg 2, T%d; Leg 3, T%d; Leg 4, T%d",getCountry(relayTeam),getLeg1(relayTeam),getLeg2(relayTeam),getLeg3(relayTeam), getLeg4(relayTeam));
        System.out.println();

        check(leg1, leg2, leg3, leg4);
    }
    public static void main(String[] args) {
        Relay();
    }
}
