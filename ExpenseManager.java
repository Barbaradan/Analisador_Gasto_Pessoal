import java.time.LocalDate;
import java.util.ArrayList;

public class ExpenseManager {
    //essa classe guarda e controla os gastos

    ArrayList<Expense> expenses = new ArrayList<>();

    public void addExpense(double amount, String description, Category category, LocalDate date){
        Expense expense = new Expense(amount, description, category, date);
        expenses.add(expense);
    }

    public void listExpenses(){
        for (Expense e : expenses){
            System.out.println(e);
        }
    }

    public double calculateTotal(){
        double total = 0;
        for (Expense e : expenses) {
            total += e.getAmount();
        }
        return total;
    }

    //Menu 4 - Filtrar por mes
    public double calculateTotalByMonth(int month, int year){
        double total = 0;

        for(Expense e : expenses) {
            if(e.getDate().getMonthValue() == month && e.getDate().getYear() == year){
                total += e.getAmount();
            }
        }
        return total;
    }

    //Filtro de categoria
    public void listByCategory(Category category){
        boolean found = false;

        for (Expense e : expenses){
            if (e.getCategory() == category){
                System.out.println(e);
                found = true;
            }
        }

        if (!found){
            System.out.println("Nenhum gasto encontrado nesta categoria.");
        }
    }
}
