import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class HashMapTask {

    public static void main(String[] args) {

        // Create HashMap
        HashMap<String, Set<Integer>> parcelMap = new HashMap<>();

        // Tracking numbers and corresponding hub codes
        String[] trackingNumbers = {
            "TR101", "TR102", "TR103",
            "TR101", "TR104", "TR102",
            "TR105", "TR101"
        };

        int[] hubCodes = {
            50, 30, 70,
            50, 30, 30,
            70, 30
        };

        // Process parcel scans
        for (int i = 0; i < trackingNumbers.length; i++) {

            String trackingNumber = trackingNumbers[i];
            int hubCode = hubCodes[i];

            if (parcelMap.containsKey(trackingNumber)) {

                Set<Integer> hubs = parcelMap.get(trackingNumber);

                if (hubs.contains(hubCode)) {

                    System.out.println(
                        "Duplicate scan detected: "
                        + trackingNumber
                        + " at Hub "
                        + hubCode
                    );

                } else {

                    hubs.add(hubCode);

                    System.out.println(
                        "New scan: "
                        + trackingNumber
                        + " at Hub "
                        + hubCode
                    );
                }

            } else {

                Set<Integer> hubs = new HashSet<>();

                hubs.add(hubCode);

                parcelMap.put(trackingNumber, hubs);

                System.out.println(
                    "New scan: "
                    + trackingNumber
                    + " at Hub "
                    + hubCode
                );
            }
        }

        // Display final parcel records
        System.out.println("\nFinal Parcel Records:");

        for (Map.Entry<String, Set<Integer>> entry : parcelMap.entrySet()) {

            System.out.println(
                entry.getKey() + " -> " + entry.getValue()
            );
        }
    }
}
