package avis.ipdetection4j.iphub4j.proxy;

import avis.ipdetection4j.annotations.Parser;

public class BlockParser implements Parser<Integer, Block> {
    @Override
    public Block parse(Integer integer) {
        return Block.values()[integer];
    }
}
