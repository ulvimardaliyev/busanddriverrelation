package az.busdriver.busanddriverrelation.config;

public class Main {


    public static void main(String[] args) {
        /*new Main().testMe();
        new Main().testMe();*/
    }

   /* public void testMe() {


        BusDriver busDriver1 = BusDriver.builder()
                .driver_id(1)
                .driverName("Ulvi")
                .driverSurname("M")
                .experienceLevel(ExperienceLevel.JUNIOR)
                .build();
        BusDriver busDriver2 = BusDriver.builder()
                .driver_id(2)
                .driverName("Djavid")
                .driverSurname("A")
                .experienceLevel(ExperienceLevel.JUNIOR)
                .build();
        BusDriver busDriver3 = BusDriver.builder()
                .driver_id(3)
                .driverName("Ruslan")
                .driverSurname("M")
                .experienceLevel(ExperienceLevel.JUNIOR)
                .build();
        var allBusDrivers = Arrays.asList(busDriver1, busDriver2, busDriver3);
        List<Integer> list = Arrays.asList(1, 2, 4);
        List<BusDriver> drivers =
                allBusDrivers
                        .stream()
                        .filter(
                                busDriver ->
                                        list.stream().anyMatch(id -> id > 0)
                        )
                        .collect(Collectors.toList());
        System.out.println(drivers);
    }*/
}
