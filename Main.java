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

                    System.out.println("Categoria:");
                    System.out.println("1- ALIMENTAÇÃO");
                    System.out.println("2 - VESTUÁRIO");
                    System.out.println("3 - SAÚDE");
                    System.out.println("4 - TRANSPORTE");
                    System.out.println("5 - LAZER");
                    System.out.println("6 - OUTROS");

                    int categoryOption = scanner.nextInt();
                    scanner.nextLine();

                    Category category = null;

                    switch (categoryOption){
                        case 1: category = Category.ALIMENTACAO;
                            break;
                        case 2: category = Category.VESTUARIO;
                            break;
                        case 3: category = Category.SAUDE;
                            break;
                        case 4: category = Category.TRANSPORTE;
                            break;
                        case 5: category = Category.LAZER;
                            break;
                        case 6: category = Category.OUTROS;
                            break;
                        default:
                            System.out.println("Categoria invalida!");
                            return;
                    }

                    //System.out.println("Categoria: ");
                    //String category = scanner.nextLine();

                    System.out.println("Data (dd/MM/yyyy): ");
                    String dateInput = scanner.nextLine();

                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate parsedDate = LocalDate.parse(dateInput, formatter);

                    manager.addExpense(amount, description, category, parsedDate);

                    System.out.println("Gasto adicionado!");
                    break;

                case 2:
                    manager.listExpenses();
                    break;

                case 3: //aqui tem conexão direta com o calculateTotaMonth no ExpenseManager
                    double total = manager.calculateTotal();
                    System.out.println("Total gasto: " + total);
                    break;

                case 4:
                    System.out.println("Digite o mês (1 a 12): ");
                    int month = scanner.nextInt();

                    System.out.println("Digite o ano:" );
                    int year = scanner.nextInt();

                    double totalMonth = manager.calculateTotalByMonth(month, year);

                    System.out.println("Total gasto no mês: " + totalMonth);
                    break;

                case 5:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção invalida.");
            }
        } while (option != 5);

        scanner.close();
    }
}
