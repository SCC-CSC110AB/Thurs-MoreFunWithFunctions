package thurs.morefunwithfunctions;

import java.util.Scanner;

/**
 *
 * @author john
 */
public class ThursMoreFunWithFunctions {

    public static String getUserInput() {
        Scanner stdin = new Scanner(System.in);

        System.out.println(
                "Enter a temperature: (e.g. 20 C) "
        );

        return stdin.nextLine();
    }

    public static String[] splitUserInput(String userInput) {
        return userInput.split(" ");
    }

    public static int getTemperatureValue(String[] splitUserInput) {
        return Integer.parseInt(splitUserInput[0]);
    }

    public static char getTemperatureUnit(String[] splitUserInput) {
        return splitUserInput[1].charAt(0);
    }

    public static boolean isCelsius(char c) {
        if (c == 'c' || c == 'C') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isFahrenheit(char c) {
        if (c == 'f' || c == 'F') {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isTemperatureUnitValid(char c) {
        if (isCelsius(c) || isFahrenheit(c)) {
            return true;
        } else {
            return false;
        }
    }

    public static final int MIN_CELSIUS_VALUE = -40;
    public static final int MAX_CELSIUS_VALUE = 50;
    public static final int MIN_FAHRENHEIT_VALUE = -40;
    public static final int MAX_FAHRENHEIT_VALUE = 120;

    public static boolean isTemperatureValueValid(int value, char unit) {
        if (isCelsius(unit)
                && value >= MIN_CELSIUS_VALUE
                && value <= MAX_CELSIUS_VALUE) {
            return true;
        } else if (isFahrenheit(unit)
                && value >= MIN_FAHRENHEIT_VALUE
                && value <= MAX_FAHRENHEIT_VALUE) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isUserInputValid(
            int temperatureValue,
            char temperatureUnit) {
        return isTemperatureUnitValid(temperatureUnit)
                && isTemperatureValueValid(temperatureValue, temperatureUnit);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String[] splitUserInput = splitUserInput(getUserInput());
        int temperatureValue = getTemperatureValue(splitUserInput);
        char temperatureUnit = getTemperatureUnit(splitUserInput);
        boolean isCelsius = isCelsius(temperatureUnit);
        boolean isValid = isUserInputValid(temperatureValue, temperatureUnit);

        if (isValid) {
            System.out.println(
                    "The value is: "
                    + temperatureValue
                    + " and is it in celsius? "
                    + isCelsius
            );
        } else {
            System.out.println("Input is invalid");
        }

    }

}
