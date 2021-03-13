import java.text.DecimalFormat;
import java.util.*;

public class Wage {
    public static void main(String[] args) { //Main function good to add the scanner just in case
        Scanner sin = new Scanner(System.in);
        double dWage, dTHours, dMinHours, dTWage, dMinutes, dT=0; // dTHours the amount of minutes in hours
        int nMinutes, nHours;
        String sAnswer;

        System.out.println("Please specify what your wage is if it is student wage press (s), if minimum press (m), otherwise press (o)");
        sAnswer = sin.next();
        if (sAnswer.equalsIgnoreCase("s")) {
            dWage = 13.25;
        }
        else if (sAnswer.equalsIgnoreCase("m"))
        {
            dWage = 14.00;
        }
        else if (sAnswer.equalsIgnoreCase("o"))
        {
            System.out.println("Please input your wage");
            dWage = sin.nextDouble();
        }
        else
        {
            System.out.println("Please input your wage");
            dWage = sin.nextDouble();
        }

        System.out.println("Thank you now enter your minutes");
        nMinutes = sin.nextInt();
        dMinutes = nMinutes / 60.0; //Conversion to hours
        dMinHours = minutes2hoursrounded(dMinutes);
        System.out.println("Please input your hours");
        nHours = sin.nextInt();
        dTHours = nHours + dMinHours;
        dTWage = dWage * dTHours;
        dTWage = RoundedMoney(dTWage);
        if (dTWage <= 40922){
            dT = 20.05;
        }
        else if (dTWage >= 40923 && dTWage <= 44701){
            dT = 20.05 + 9.15;
        }
        dTWage = dTWage - (dT/100 * dTWage);
        dTWage = dTWage - (6.38/100 * dTWage);
        dTWage = RoundTo2Decimals(dTWage);
        System.out.println("$" + dTWage);
    }

    private static double RoundTo2Decimals(double val)
    {
        DecimalFormat df2 = new DecimalFormat("###.##");
        return Double.valueOf(df2.format(val));
    }

    private static double minutes2hoursrounded(double dMinutes) {
        double dRoundMinHour;
        dRoundMinHour = Math.round(dMinutes * 100.0) / 100.0;
        return dRoundMinHour;
    }

    private static double RoundedMoney(double dTWage) {
        dTWage = Math.round(dTWage * 100.0) / 100.0;
        return dTWage;
    }
}

