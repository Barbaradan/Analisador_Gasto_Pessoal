import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in); //le os dados do user
        ExpenseManager manager = new ExpenseManager(); //objeto do expenseManager, que é quem garda o gera os valores do user

        int option;

        do {
            System.out.println("\n == ANALISADOR DE GASTOS == ");
            System.out.println("1- Adicionar gasto");
            System.out.println("2- Listar gastos");
            System.out.println("3- Mostrar total de gastos");
            System.out.println("4- Total por mês");
            System.out.println("5- Sair");
            System.out.println("Escolha uma opção: ");

            option = scanner.nextInt();
            scanner.nextLine(); //limpa

            switch (option) {
                case 1:
                    System.out.println("Coloque o valor: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.println("Descrição: ");
                    String description = scanner.nextLine();

                    System.out.println("Categoria: ");
                    String category = scanner.nextLine();

                    System.out.println("Data (dd/MM/yyyy): ");
                    String dateInput = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate parsedDate = LocalDate.parse(dateInput, formatter);

                    manager.addExpense(amount, description, category, parsedDate);

                    System.out.println("Valor de gasto adicionado!");
                    break;

                case 2:
                    manager.listExpenses();
                    break;

                case 3:
                    double total = manager.calculateTotal();
                    System.out.println("Total gasto: " + total);
                    break;

                case 4:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção invalida.");
            }
        } while (option != 4);

        scanner.close();
    }
}
