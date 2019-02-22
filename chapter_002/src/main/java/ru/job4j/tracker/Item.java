package ru.job4j.tracker;

public class Item {

    private String id;
    private String name;
    private String desc;
    private long create;

    public Item(String name, String desc, long create) {
        this.name = name;
        this.desc = desc;
        this.create = System.currentTimeMillis();
    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String id, String name, String desc) {
        this.id = id;
        this.name = name;
        this.desc = desc;

    }

    public String getName() {
        return this.name;
    }

    public String getDesc() {
        return this.desc;
    }

    public long getCreate() {
        return this.create;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return "id='" + id + '\''
                + ", name='" + name + '\''
                + ", desc='" + desc + '\''
                + ", create=" + create;
    }
}
