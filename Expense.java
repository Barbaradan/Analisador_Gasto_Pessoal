import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {
    private double amount; //valor
    private String description;
    private Category category; //enum
    private LocalDate date;

    // Constructor
    public Expense(double amount, String description, Category category, LocalDate date){
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.date = date;
    }

    // Getters
    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }

    public LocalDate getDate() {
        return date;
    }

    @Override
    public String toString() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date.format(formatter);

        return "---------------\n" +
                "Valor: R$" + amount +
                "\nDescrição: " + description +
                "\nCategoria: " + category +
                "\nData: " + formattedDate;
    }
}