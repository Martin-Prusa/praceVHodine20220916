package cz.martin.nobel;

public class Main {
    public static void main(String[] args) {
        NobelService service = new NobelService();
        for (Nobel nobel : service.getFirst()) {
            System.out.println(nobel);
        }

        System.out.println("---------------------------------------");
        for (Nobel nobel : service.getObama()) {
            System.out.println(nobel);
        }

        System.out.println("------------------------------------------");
        for (Nobel nobel : service.getWar()) {
            System.out.println(nobel);
        }

        System.out.println("------------------------------------------");
        System.out.println(service.getFirstEconomics());

        System.out.println("------------------------------------------");
        for (Nobel nobel : service.getAfterEU()) {
            System.out.println(nobel);
        }

        System.out.println("------------------------------------------");
        var map = service.getCounts();
        for (String s : map.keySet()) {
            System.out.println(s+": "+map.get(s));
        }

        System.out.println("------------------------------------------");
        for (String duplicate : service.getDuplicates()) {
            System.out.println(duplicate);
        }
    }
}
