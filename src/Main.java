import java.util.Date;


public class Main {
    public static void main(String[] args) {
        Sklad sklad = new Sklad(100, "Main Sklad", "Nikolaev", "Fedotov");
        Sklad skladMilk = new Sklad(10, "Молочный склад", "Nikolaev", "Ivanov");
        Sklad skladBeer = new Sklad(20, "Пивной склад", "Nikolaev", "Petrov");
        Produckt milk = new Produckt("Burenka", Manufacture.Галичина, new Date(), Category.Молочная_продукция, SyzeItem.Пакет_1л, 10, 15, 60);
        Produckt milk1 = new Produckt("Burenka", Manufacture.Галичина, new Date(), Category.Молочная_продукция, SyzeItem.Пакет_1л, 10, 15, 40);
        Produckt milk2 = new Produckt("Burenka", Manufacture.Галичина, new Date(), Category.Молочная_продукция, SyzeItem.Пакет_0_5л, 5, 15, 100);
        Produckt milk3 = new Produckt("Burenka", Manufacture.Галичина, new Date(), Category.Молочная_продукция, SyzeItem.Пакет_1л, 10, 15, 50);
        Produckt beer = new Produckt("Десант", Manufacture.Оболонь, new Date(), Category.Пиво, SyzeItem.Бутылка_0_5л, 12, 45, 200);
        Produckt beer1 = new Produckt("Obolon", Manufacture.Оболонь, new Date(), Category.Пиво, SyzeItem.Бутылка_0_5л, 14, 45, 210);
        Produckt beer3 = new Produckt("Bavaria", Manufacture.Carlsberg, new Date(), Category.Пиво, SyzeItem.Бутылка_0_33л, 25, 45, 300);
        Produckt beer2 = new Produckt("Obolon", Manufacture.Оболонь, new Date(), Category.Пиво, SyzeItem.Пакет_0_5л, 14, 45, 500);
        User admin = new User("Admin", "00000000", "rrr@yyyy", "7777");
        User user1 = new User("Best", "066-111-22-33", "ysa.sergey@gmail.com", "1w23");
        User user2 = new User("Petrov", "066-111-22-34", "y.sergey@gmail.com", "3rrr6");
        User user3 = new User("Best", "066-111-22-34", "y.sergey@gmail.com", "3rrr6");
        User user4 = new User("Best", "066-111-22-34", "y.sergey@gmail.com", "3rrr6");

        sklad.addSklad(skladMilk);
        sklad.addSklad(skladBeer);
        sklad.reportS();//вывод складов

        admin.addUser(user1);
        admin.addUser(user2);
        admin.addUser(user3);
        admin.addUser(user4);
        admin.reportUser("Admin","7777"); //вывод всех пользователей
        user1.reportUser("Ivanov","3333");//ошибка неправильный пароль
        admin.reportUserPass("Best", "3rrr6"); //проверка логина и пароля
        admin.changePass("Best", "3rrr6", "22222");//замена пароля пользователя
        System.out.println();

        sklad.addProduckt(milk);
        sklad.addProduckt(milk1);
        sklad.addProduckt(milk2);
        sklad.addProduckt(milk3);
        sklad.addProduckt(beer);
        sklad.addProduckt(beer1);
        sklad.addProduckt(beer3);
        sklad.addProduckt(beer2);

        sklad.reportSklad();
        System.out.println();
        System.out.println(user1.searchName("Obolon", Sklad.goods));//сортировка по имени
        System.out.println();
        System.out.println(user1.searchCategory(Category.Молочная_продукция, Sklad.goods));//сортировка по категории
        System.out.println();
        System.out.println(user1.searchPrice(12, Sklad.goods));//сортировка по цене
        System.out.println();
        System.out.println(user1.searchPrice(10, user1.searchCategory(Category.Молочная_продукция, user1.searchName("Burenka", Sklad.goods))));//сотривовка по имени затем по категории затем цене

        skladMilk.reportSkladCategory(Category.Молочная_продукция);
        skladBeer.reportSkladCategory(Category.Пиво);
        sklad.reportSkladManufacture(Manufacture.Оболонь);
        sklad.reportSkladManufacture(Manufacture.Галичина);
        sklad.reportSkladProdukt("Burenka");
        sklad.reportSkladProdukt("Obolon");
        sklad.reportSkladProdukt("Десант");
        sklad.reportSkladProdukt("Bavaria");

    }
}