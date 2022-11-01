package entities;

public class TaxPayer {    //Contribuinte

    private double salaryIncome;      //salárioRenda
    private double servicesIncome;   // serviçosReceita
    private double capitalIncome;     //renda de capital
    private double healthSpending;     //gastos com saúde
    private double educationSpending;    // gastos com educação

    public TaxPayer() {
    }

    public TaxPayer(double salaryIncome, double servicesIncome, double capitalIncome, double healthSpending, double educationSpending) {
        this.salaryIncome = salaryIncome;
        this.servicesIncome = servicesIncome;
        this.capitalIncome = capitalIncome;
        this.healthSpending = healthSpending;
        this.educationSpending = educationSpending;
    }

    public double getSalaryIncome() {
        return salaryIncome;
    }

    public void setSalaryIncome(double salaryIncome) {
        this.salaryIncome = salaryIncome;
    }

    public double getServicesIncome() {
        return servicesIncome;
    }

    public void setServicesIncome(double servicesIncome) {
        this.servicesIncome = servicesIncome;
    }

    public double getCapitalIncome() {
        return capitalIncome;
    }

    public void setCapitalIncome(double capitalIncome) {
        this.capitalIncome = capitalIncome;
    }

    public double getHealthSpending() {
        return healthSpending;
    }

    public void setHealthSpending(double healthSpending) {
        this.healthSpending = healthSpending;
    }

    public double getEducationSpending() {
        return educationSpending;
    }

    public void setEducationSpending(double educationSpending) {
        this.educationSpending = educationSpending;
    }

    public double salaryTax() {     // salárioImposto
        double monthlySalary = this.salaryIncome / 12;
        double monthlySalaryTax;
        if (monthlySalary < 3000) {
            monthlySalaryTax = 0.0;
        } else if (monthlySalary >= 3000 && monthlySalary < 5000) {
            monthlySalaryTax = this.salaryIncome * 0.10;
        } else {
            monthlySalaryTax = this.salaryIncome * 0.20;
        }
        return monthlySalaryTax;
    }

    public double servicesTax() {     // serviçosImposto
        double servicesTax = 0.0;
        if (this.servicesIncome > 0) {
            servicesTax = this.servicesIncome * 0.15;
        }
        return servicesTax;
    }

    public double capitalTax() {     // imposto de capital
        double capitalTax = 0.0;
        if (this.capitalIncome > 0) {
            capitalTax = this.capitalIncome * 0.20;
        }
        return capitalTax;
    }

    public double grossTax() {     // imposto bruto
        return this.salaryTax() + this.servicesTax() + this.capitalTax();
    }

    public double taxRebate() {     // restituição de líquido
        double taxRebate = 0.0;
        double abatement = this.healthSpending + this.educationSpending;
        double grossTax = this.grossTax() * 0.30;
        if (abatement > grossTax) {
            taxRebate = grossTax;
        } else {
            taxRebate = abatement;
        }
        return taxRebate;
    }

    public double netTax() {     // imposto líquido
        return this.grossTax() - this.taxRebate();
    }

}
