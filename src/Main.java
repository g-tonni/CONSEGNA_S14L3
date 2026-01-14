import entities.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {

    Product p1 = new Product("Maglietta", Category.BOYS, 25.5);
    Product p2 = new Product("Pantalone", Category.GIRLS, 28.5);
    Product p3 = new Product("Body", Category.BABY, 8);
    Product p4 = new Product("Harry Potter", Category.BOOK, 17.5);
    Product p5 = new Product("Risiko", Category.GAMES, 45);
    Product p6 = new Product("Puzzle 500pz", Category.PUZZLE, 11.5);
    Product p7 = new Product("Harry Potter 2", Category.BOOK, 115);
    Product p8 = new Product("Sciarpa", Category.BOYS, 16);
    Product p9 = new Product("Scarpe", Category.GIRLS, 130);
    Product p10 = new Product("Tetris", Category.GAMES, 35.5);
    Product p11 = new Product("Sonaglio", Category.BABY, 6);
    Product p12 = new Product("Rossetto", Category.GIRLS, 15);
    Product p13 = new Product("10 piccoli indiani", Category.BOOK, 13);
    Product p14 = new Product("Lego", Category.GAMES, 65.5);
    Product p15 = new Product("Puzzle 1000pz", Category.PUZZLE, 18.5);
    Product p16 = new Product("Puzzle 2000pz", Category.PUZZLE, 42);
    Product p17 = new Product("Monopoly", Category.GAMES, 36.5);
    Product p18 = new Product("Harry Potter 3", Category.BOOK, 120);
    Product p19 = new Product("Guanti", Category.BOYS, 9);
    Product p20 = new Product("Cappello", Category.BABY, 20.5);

    List<Product> elencoProdotti = new ArrayList<>(Arrays.asList(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, p11, p12, p13, p14, p15, p16, p17, p18, p19, p20));

    Customer c1 = new Customer("Giada", 2);
    Customer c2 = new Customer("Diego", 3);
    Customer c3 = new Customer("Giorgia", 2);
    Customer c4 = new Customer("Martina", 5);
    Customer c5 = new Customer("Luca", 4);

    LocalDate g1 = LocalDate.of(2026, 3, 5);
    LocalDate g2 = LocalDate.of(2026, 2, 15);
    LocalDate g3 = LocalDate.of(2026, 5, 21);
    LocalDate g4 = LocalDate.of(2026, 10, 12);
    LocalDate g5 = LocalDate.of(2026, 1, 7);
    LocalDate g6 = LocalDate.of(2026, 12, 2);
    LocalDate g7 = LocalDate.of(2026, 11, 17);
    LocalDate g8 = LocalDate.of(2026, 8, 21);
    LocalDate g9 = LocalDate.of(2026, 9, 8);
    LocalDate g10 = LocalDate.of(2026, 4, 24);

    List<Product> lp1 = new ArrayList<>(Arrays.asList(p1, p7, p12, p5, p9));
    List<Product> lp2 = new ArrayList<>(Arrays.asList(p2, p14, p15, p11, p6));
    List<Product> lp3 = new ArrayList<>(Arrays.asList(p8, p11, p4, p10));
    List<Product> lp4 = new ArrayList<>(Arrays.asList(p13, p17, p18));
    List<Product> lp5 = new ArrayList<>(Arrays.asList(p11, p2, p19, p5));
    List<Product> lp6 = new ArrayList<>(Arrays.asList(p3, p6, p5, p9));
    List<Product> lp7 = new ArrayList<>(Arrays.asList(p2, p14, p13, p20, p4));
    List<Product> lp8 = new ArrayList<>(Arrays.asList(p11, p6, p5, p8));
    List<Product> lp9 = new ArrayList<>(Arrays.asList(p9, p10, p17));
    List<Product> lp10 = new ArrayList<>(Arrays.asList(p3, p8));

    Order o1 = new Order(Status.PROCESSING, g1, lp1, c1);
    Order o2 = new Order(Status.IN_DELIVERY, g2, lp2, c2);
    Order o3 = new Order(Status.CANCELLED, g3, lp3, c3);
    Order o4 = new Order(Status.SHIPPED, g4, lp4, c4);
    Order o5 = new Order(Status.DELIVERED, g5, lp5, c5);
    Order o6 = new Order(Status.CONFIRMED, g6, lp6, c3);
    Order o7 = new Order(Status.PROCESSING, g7, lp7, c5);
    Order o8 = new Order(Status.IN_DELIVERY, g8, lp8, c2);
    Order o9 = new Order(Status.CONFIRMED, g9, lp9, c1);
    Order o10 = new Order(Status.SHIPPED, g10, lp10, c4);

    List<Order> elencoOrdini = new ArrayList<>(Arrays.asList(o1, o2, o3, o4, o5, o6, o7, o8, o9, o10));

    System.out.println("---------------------------------- PRIMO ESERCIZIO");
    List<Product> booksMag100 = elencoProdotti.stream()
            .filter(product -> product.getCategory() == Category.BOOK && product.getPrice() > 100)
            .toList();
    System.out.println(booksMag100);


    System.out.println("---------------------------------- SECONDO ESERCIZIO");
    List<Order> ordiniBaby = elencoOrdini.stream()
            .filter(order ->
                    order.getProducts().stream().anyMatch(product -> product.getCategory() == Category.BABY)
            )
            .toList();
    for (int i = 0; i < ordiniBaby.size(); i++) {
       System.out.println(ordiniBaby.get(i));
    }

    System.out.println("---------------------------------- TERZO ESERCIZIO");
    List<Product> prezzoScontato = elencoProdotti.stream()
            .filter(product -> product.getCategory() == Category.BOYS)
            .map(product -> {
                product.setPrice10(product.getPrice());
                return product;
            })
            .toList();

    System.out.println(prezzoScontato);

    System.out.println("---------------------------------- QUARTO ESERCIZIO");
    LocalDate primaData = LocalDate.of(2026, 1, 1);
    LocalDate secondaData = LocalDate.of(2026, 6, 30);

    List<Product> prodottiSpeciali =
            elencoOrdini.stream()
                    .filter(order -> order.getCustomer().getTier() == 2)
                    .filter(order -> primaData.isBefore(order.getOrderDate()) && secondaData.isAfter(order.getOrderDate()))
                    .map(order -> order.getProducts())
                    .flatMap(products -> products.stream())
                    .toList();
    for (int i = 0; i < prodottiSpeciali.size(); i++) {
        System.out.println(prodottiSpeciali.get(i));
    }


}
