package avis.ipqualityscore4j.email;

import avis.ipqualityscore4j.annotations.Parser;

public class DeliverabilityParser implements Parser<String, Deliverability> {
    @Override
    public Deliverability parse(String s) {
        return Deliverability.parseDeliverability(s);
    }
}
