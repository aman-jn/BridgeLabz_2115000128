import java.util.Random;

public class EmployeeBonus {

    public static double[][] generateEmployeeData() {
        Random rand = new Random();
        double[][] employeeData = new double[10][2];

        for (int i = 0; i < 10; i++) {
            employeeData[i][0] = 30000 + rand.nextInt(70000);
            employeeData[i][1] = 1 + rand.nextInt(15);
        }

        return employeeData;
    }

    public static double[][] calculateNewSalaryAndBonus(double[][] employeeData) {
        double[][] updatedData = new double[10][3];

        for (int i = 0; i < 10; i++) {
            double oldSalary = employeeData[i][0];
            int yearsOfService = (int) employeeData[i][1];
            double bonus;

            if (yearsOfService > 5) {
                bonus = oldSalary * 0.05;
            } else {
                bonus = oldSalary * 0.02;
            }

            double newSalary = oldSalary + bonus;

            updatedData[i][0] = oldSalary;
            updatedData[i][1] = newSalary;
            updatedData[i][2] = bonus;
        }

        return updatedData;
    }

    public static void calculateAndDisplayTotals(double[][] updatedData) {
        double totalOldSalary = 0, totalNewSalary = 0, totalBonus = 0;

        for (int i = 0; i < 10; i++) {
            totalOldSalary += updatedData[i][0];
            totalNewSalary += updatedData[i][1];
            totalBonus += updatedData[i][2];
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Employee", "Old Salary", "New Salary", "Bonus");
        System.out.println("-------------------------------------------------------------");

        for (int i = 0; i < 10; i++) {
            System.out.printf("%-10d%-15.2f%-15.2f%-15.2f\n", i + 1, updatedData[i][0], updatedData[i][1],
                    updatedData[i][2]);
        }

        System.out.println("-------------------------------------------------------------");
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);
        System.out.printf("Total Bonus Amount: %.2f\n", totalBonus);
    }

    public static void main(String[] args) {
        double[][] employeeData = generateEmployeeData();
        double[][] updatedData = calculateNewSalaryAndBonus(employeeData);
        calculateAndDisplayTotals(updatedData);
    }
}
