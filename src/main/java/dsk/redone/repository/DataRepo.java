package dsk.redone.repository;

import java.util.HashMap;
import java.util.Map;

public abstract class DataRepo {
    protected Map<String,String> curMap;
    DataRepo() {
        curMap = new HashMap<>();
    }
    abstract void add(String name,String id);

    abstract void find(String name);
    abstract void read();
}
