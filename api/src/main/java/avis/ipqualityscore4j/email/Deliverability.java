package avis.ipqualityscore4j.email;

public enum Deliverability {

    HIGH,
    MEDIUM,
    LOW;

    public static Deliverability parseDeliverability(String id) {
        for(Deliverability deliverability : values()) {
            if(deliverability.toString().toLowerCase().equals(id)) {
                return deliverability;
            }
        }
        throw new IllegalArgumentException("Invalid deliverability: '" + id + "'");
    }

}
