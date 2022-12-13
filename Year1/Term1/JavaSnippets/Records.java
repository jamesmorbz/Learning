package Learning.Snippets;

public class Records {

        static String Model = "Volvo" ;
        static int Price = 1000;
        static int Year = 1999;
        static boolean ReadyToBuy = true;

    public static Records records(String Model, int Price, int Year, boolean ReadyToBuy) {
        Records car = new Records();
        Records.Model = Model;
        Records.Price = Price;
        Records.Year = Year;
        Records.ReadyToBuy = ReadyToBuy;
        System.out.println(getmodel(car));
        System.out.println(getprice(car));
        System.out.println(getyear(car));
        System.out.println(getReadyToBuy(car));
        return car;
       
    }

    public static String getmodel(Records car){ //Getting model
        return Records.Model;
    }

    public static int getprice(Records car){ //Getting price
        return Records.Price;
    }

    public static int getyear(Records car){ //Getting year
        return Records.Year;
    }

    public static boolean getReadyToBuy(Records car){ //Getting ready to buy
        return Records.ReadyToBuy;
    }

    public static void main(String[] args) {
        records(Model, Price, Year, ReadyToBuy);
        
    
}
}