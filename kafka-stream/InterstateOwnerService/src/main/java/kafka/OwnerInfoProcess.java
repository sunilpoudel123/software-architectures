package kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OwnerInfoProcess {

    @Autowired
    Sender sender;

    public void consumeSpeedRecord(SpeedRecord record) {
        String plate = record.getLicensePlate();
        String owner = ownerDb.getOrDefault(plate, "Unknown Owner");

        VehicleOwnerRecord ownerRecord = new VehicleOwnerRecord(
                plate, owner, (int) record.getSpeed()
        );

        System.out.println("OwnerService => " + ownerRecord);

        sender.send("toownertopic", ownerRecord);
    }

    private static final Map<String, String> ownerDb = Map.ofEntries(
            Map.entry("EE1001", "Michael Scott"),
            Map.entry("BB1001", "Dwight Schrute"),
            Map.entry("ES1001", "Jim Halpert"),
            Map.entry("FAS1001", "Pam Beesly"),
            Map.entry("BS1001", "Stanley Hudson"),
            Map.entry("FBS1001", "Angela Martin"),

            Map.entry("EE1002", "Kevin Malone"),
            Map.entry("BB1002", "Oscar Martinez"),
            Map.entry("ES1002", "Phyllis Vance"),
            Map.entry("FAS1002", "Creed Bratton"),
            Map.entry("BS1002", "Meredith Palmer"),
            Map.entry("FBS1002", "Emily Wright"),

            Map.entry("EE1003", "Andy Bernard"),
            Map.entry("BB1003", "Kelly Kapoor"),
            Map.entry("ES1003", "Toby Flenderson"),
            Map.entry("FAS1003", "Darryl Philbin"),
            Map.entry("BS1003", "Ryan Howard"),
            Map.entry("FBS1003", "Erin Hannon"),

            Map.entry("EE1004", "Jan Levinson"),
            Map.entry("BB1004", "Karen Filippelli"),
            Map.entry("ES1004", "Holly Flax"),
            Map.entry("FAS1004", "Chloe Evans"),
            Map.entry("BS1004", "Gabe Lewis"),
            Map.entry("FBS1004", "Nellie Bertram"),

            Map.entry("EE1005", "Roy Anderson"),
            Map.entry("BB1005", "Kelly Kapoor"),
            Map.entry("ES1005", "Toby Flenderson"),
            Map.entry("FAS1005", "Darryl Philbin"),
            Map.entry("BS1005", "Ryan Howard"),

            Map.entry("EE1006", "Jan Levinson"),
            Map.entry("BB1006", "Karen Filippelli"),
            Map.entry("ES1006", "Holly Flax"),
            Map.entry("FAS1006", "David Wallace"),
            Map.entry("BS1006", "Gabe Lewis"),
            Map.entry("FBS1006", "Nellie Bertram"),

            Map.entry("EE1007", "Michael Scott"),
            Map.entry("BB1007", "Dwight Schrute"),
            Map.entry("ES1007", "Jim Halpert"),
            Map.entry("FAS1007", "Pam Beesly"),
            Map.entry("BS1007", "Stanley Hudson"),
            Map.entry("FBS1007", "Angela Martin"),

            Map.entry("EE1008", "Kevin Malone"),
            Map.entry("BB1008", "Oscar Martinez"),
            Map.entry("ES1008", "Phyllis Vance"),
            Map.entry("FAS1008", "Creed Bratton"),
            Map.entry("BS1008", "Meredith Palmer"),
            Map.entry("FBS1008", "Emily Wright"),

            Map.entry("EE1009", "Andy Bernard"),
            Map.entry("BB1009", "Kelly Kapoor"),
            Map.entry("ES1009", "Toby Flenderson"),
            Map.entry("FAS1009", "Darryl Philbin"),
            Map.entry("BS1009", "Ryan Howard"),
            Map.entry("FBS1009", "Erin Hannon"),

            Map.entry("EE1010", "Jan Levinson"),
            Map.entry("BB1010", "Karen Filippelli"),
            Map.entry("ES1010", "Holly Flax"),
            Map.entry("FAS1010", "Chloe Evans"),
            Map.entry("BS1010", "Gabe Lewis"),
            Map.entry("FBS1010", "Nellie Bertram")
    );


}
