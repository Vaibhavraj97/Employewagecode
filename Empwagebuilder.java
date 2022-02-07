package com.bridgelabz.ComputeEmpwage;
import java.util.ArrayList;
import java.util.HashMap;
class Empwagebuilder {
	
	 		final String Company_Name;
		    final int Wage_Per_Hr;
		    final int Max_Working_Days;
		    final int Max_Working_Hrs;
		    int totalEmpWage;

		    Empwagebuilder(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
		    {
		        Company_Name = companyName;
		        Wage_Per_Hr = wagePerHr;
		        Max_Working_Days = maxWorkingDays;
		        Max_Working_Hrs = maxWorkingHrs;
		        totalEmpWage = 0;
		    }

		    void setTotalEmployeeWage(int totalEmpWage)
		    {
		        this.totalEmpWage = totalEmpWage;
		    }

		    @Override
		    public String toString() {
		        System.out.println("  Details of " + Company_Name + " employee" );
		        System.err.println("Wage per hour:" + Wage_Per_Hr);
		        System.out.println("Maximum working days:" + Max_Working_Days);
		        System.out.println("Maximum working hours:" + Max_Working_Hrs);
		        return "Total wage for a month of " + Company_Name + " employee is " + totalEmpWage + "\n";
		    }
		}

		class Employee_Wage_for_multiple_companies
		{
		    public static final int PART_TIME = 1;
		    public static final int FULL_TIME = 2;

		    ArrayList<Empwagebuilder> companies;
		    HashMap<String, Integer> totalEmpWages;

		    public Employee_Wage_for_multiple_companies()
		    {
		        companies = new ArrayList<>();
		        totalEmpWages = new HashMap<>();
		    }

		    private void addCompany(String companyName, int wagePerHr, int maxWorkingDays, int maxWorkingHrs)
		    {
		        Empwagebuilder company = new Empwagebuilder(companyName, wagePerHr, maxWorkingDays, maxWorkingHrs);
		        companies.add(company);
		        totalEmpWages.put(companyName, 0);
		    }

		    int generateEmployeeType()
		    {
		        return (int) (Math.random() * 100) % 3;
		    }

		    int getWorkingHrs(int empType)
		    {
		        return switch (empType) {
		            case FULL_TIME -> 8;
		            case PART_TIME -> 4;
		            default -> 0;
		        };
		    }

		    private void calculateTotalWage()
		    {
		        for (Empwagebuilder company : companies)
		        {
		            int totalWage = calculateTotalWage(company);
		            company.setTotalEmployeeWage(totalWage);
		            System.out.println(company);
		        }
		    }

		    int calculateTotalWage(Empwagebuilder companyEmpWage)
		    {
		        System.out.println("Computation of total wage of " + companyEmpWage.Company_Name + " employee");
		        System.out.printf("%5s\t%4s\t%4s\t%4s\n", "Day", "Workings", "Wage", "Total working hrs");

		        int workingHrs, totalWage = 0;
		        for (int day = 1, totalWorkingHrs = 0; day <= companyEmpWage.Max_Working_Days
		                && totalWorkingHrs <= companyEmpWage.Max_Working_Hrs; day++, totalWorkingHrs += workingHrs)
		        {
		            int empType = generateEmployeeType();
		            workingHrs = getWorkingHrs(empType);
		            int wage = workingHrs * companyEmpWage.Wage_Per_Hr;
		            totalWage += wage;
		            System.out.printf("%4d\t%5d\t%10d\t%10d\n", day, workingHrs, wage, totalWorkingHrs + workingHrs);
		        }
		        totalEmpWages.put(companyEmpWage.Company_Name, totalWage);
		        return totalWage;
		    }

		    public static void main(String[] args)
		    {
		        Employee_Wage_for_multiple_companies employeeWageComputation = new Employee_Wage_for_multiple_companies();
		        employeeWageComputation.addCompany("TCS", 5, 40, 150);
		        employeeWageComputation.addCompany("BIG BASKET", 3, 50, 190);
		        employeeWageComputation.addCompany("ZOMATO", 17, 20, 170);
		        employeeWageComputation.calculateTotalWage();

		    }
		}



