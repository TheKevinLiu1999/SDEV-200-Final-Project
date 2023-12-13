import java.util.Scanner;

// Abstract class representing a generic unit converter
abstract class UnitConverter {
    String initialUnit;

    UnitConverter(String initialUnit) {
        this.initialUnit = initialUnit;
    }

    abstract double convert(double value);

    abstract String getTargetUnit();
}

// LengthConverter class extends UnitConverter for length conversions
class LengthConverter extends UnitConverter {
    LengthConverter(String initialUnit) {
        super(initialUnit);
    }

    double convert(double value) {
        // Conversion logic for length units
        switch (initialUnit.toLowerCase()) {
            case "centimeters":
                return value * 0.393701; // Convert centimeters to inches
            case "inches":
                return value * 2.54; // Convert inches to centimeters
            default:
                System.out.println("Try again.");
                return -1;
        }
    }

    String getTargetUnit() {
        String newLength = initialUnit;
        // Return the target unit for length conversions
        if (newLength.equals("centimeters")){
            return "inches";
        }
        else return "centimeters";
    }
}

// WeightConverter class extends UnitConverter for weight conversions
class WeightConverter extends UnitConverter {
    WeightConverter(String initialUnit) {
        super(initialUnit);
    }

    double convert(double value) {
        // Conversion logic for weight units
        switch (initialUnit.toLowerCase()) {
            case "ounces":
                return value / 16; // Convert ounces to pounds
            case "pounds":
                return value * 16; // Convert pounds to ounces
            default:
                System.out.println("Try again.");
                return -1;
        }
    }

    String getTargetUnit() {
        String newWeight = initialUnit;
        // Return the target unit for weight conversion
        if (newWeight.equals("ounces")) {
            return "pounds";
        }
        else return "ounces";
    }
}

// TimeConverter class extends UnitConverter for time conversions
class TimeConverter extends UnitConverter {
    TimeConverter(String initialUnit) {
        super(initialUnit);
    }

    double convert(double value) {
        // Conversion logic for time units
        switch (initialUnit.toLowerCase()) {
            case "seconds":
                return value / 60; // Convert seconds to minutes
            case "minutes":
                return value * 60; // Convert minutes to seconds
            default:
                System.out.println("Try again.");
                return -1;
        }
    }

    String getTargetUnit() {
        String newTime = initialUnit;
        // Return the target unit for time conversions
        if (newTime.equals("seconds")){
            return "minutes";
        }
        else return "seconds";
    }
}

// MeasurementConverter class handles user input and uses the appropriate converter
public class MeasurementConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to select the initial unit
        System.out.println("Enter the initial unit (centimeters, inches, ounces, pounds, seconds, minutes): ");
        String initialUnit = scanner.nextLine();

        // Ask the user for the measurement type
        System.out.println("Enter the measurement type (length, weight, time): ");
        String measurementType = scanner.nextLine();

        // Ask the user to input a number
        System.out.println("Enter the number to convert: ");
        double value = scanner.nextDouble();

        // Create the appropriate converter based on the measurement type
        UnitConverter converter;
        switch (measurementType.toLowerCase()) {
            case "length":
                converter = new LengthConverter(initialUnit);
                break;
            case "weight":
                converter = new WeightConverter(initialUnit);
                break;
            case "time":
                converter = new TimeConverter(initialUnit);
                break;
            default:
                System.out.println("Try again.");
                return;
        }

        // Convert the value and display the result
        double result = converter.convert(value);
        if (result != -1) {
            System.out.println(value + " " + initialUnit + " is equal to " + result + " " + converter.getTargetUnit());
        }
    }
}