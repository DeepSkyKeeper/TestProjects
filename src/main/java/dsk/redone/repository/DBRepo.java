package dsk.redone.repository;

public class DBRepo extends DataRepo {
    @Override
    public void add(String id, String name) {
//добавление валюты в репозиторий из h2

        curMap.put(name, id);
    }

    @Override
    public void find(String name) {
        //поиск в h2 по названию валюты
        curMap.get(name);
    }

    @Override
    void read() {
        //считать список валют из h2
    }
}
