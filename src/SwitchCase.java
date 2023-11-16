public class SwitchCase {
    public static void main(String[] args) {
        //Java 8'den önce:
        int value = 5;

        switch (value) {
            case 1:
                System.out.println("One");
                break;
            case 5:
                System.out.println("five");
                break;
            default:
                System.out.println("Unknown");
        }
        //Java 8 ile birlikte:
        String day = "Tuesday";
        switch (day) {
            case "Monday":
                System.out.println("Week day");
                break;
            case "Tuesday":
                System.out.println("Week day");
                break;
            case "Wednesday":
                System.out.println("Week day");
                break;
            case "Thursday":
                System.out.println("Week day");
                break;
            case "Friday":
                System.out.println("Week day");
                break;
            case "Saturday":
                System.out.println("Weekend");
                break;
            case "Sunday":
                System.out.println("Weekend");
                break;
            default:
                System.out.println("Unknown");
        }
        enum DAYS {
            MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
        }

        DAYS days = DAYS.SUNDAY;

        switch (days) {
            case MONDAY:
                System.out.println("Weekdays");
                break;
            case TUESDAY:
                System.out.println("Weekdays");
                break;
            case WEDNESDAY:
                System.out.println("Weekdays");
                break;
            case THURSDAY:
                System.out.println("Weekdays");
                break;
            case FRIDAY:
                System.out.println("Weekdays");
                break;
            case SATURDAY:
                System.out.println("Weekends");
                break;
            case SUNDAY:
                System.out.println("Weekends");
                break;
            default:
                System.out.println("Unknown");
        }
        //Java 14 sonrası: Switch statemen’ı artık bir switch expression’a dönüştü.
        String type =
                switch (day) {
                    case "Monday":
                        yield "Weekday";
                    case "Tuesday":
                        yield "Weekday";
                    case "Wednesday":
                        yield "Weekday";
                    case "Thursday":
                        yield "Weekday";
                    case "Friday":
                        yield "Weekday";
                    case "Saturday":
                        yield "Weekend";
                    case "Sunday":
                        yield "Weekend";
                    default:
                        yield "Unknown";
                };
        // case statement’ı arrow operator olarak tanımlanabilir hale geldi.
        // Yield yerine bu kullanım daha okunur olduğu için bu ifadenin tercih
        // edilmesi daha faydalı olabilir:
        String type2 = switch (day) {
            case "Monday"-> "Week day";
            case "Tuesday"-> "Week day";
            case "Wednesday"->"Week day";
            case "Thursday"->"Week day";
            case "Friday"->"Week day";
            case "Saturday"-> "Weekend";
            case "Sunday"-> "Weekend";
            default->"Unknown";
        };
        //switch içinde yer alan değerin farklı case’leri için aynı işlem
        //yapılabilmesini sağlamak için tek bir case
        //ifadesine farklı labellar yazılabilir hale geldi:
        String type3 = switch (day) {
            case "Monday","Tuesday","Wednesday","Thursday","Friday" -> "Week day";
            case "Saturday", "Sunday" -> "Weekend";
            default->"Unknown";
        };
        //Java 17 sonrasında ise, yukarıdaki özelliklere ek olarak aşağıdaki
        //özellikler geldi:
        //1-Pattern matching
        Object o = 5;
        double result;
        if (o instanceof Integer) {
            result = ((Integer) o).doubleValue();
        } else if (o instanceof Float) {
            result = ((Float) o).doubleValue();
        } else if (o instanceof String) {
            result = Double.parseDouble(((String) o));
        } else {
            result = 0d;
        }
        System.out.println(result);

        Object o1 = 5;
        Object result1 = switch (o1) {
            case Integer i -> i.doubleValue();
            case Float f -> f.toString();
            case String s -> Double.parseDouble(s);
            default -> 0d;
        };
        System.out.println(result1);


    }
}
