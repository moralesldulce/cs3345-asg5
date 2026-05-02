public class Employee {
    private int employeeNumber;
    private double hourlyRate;

    public Employee(int employeeNumber, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.hourlyRate = hourlyRate;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public String toString() {
        return employeeNumber + " " + hourlyRate;
    }
}