package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.util.Objects;

@XStreamAlias("group")
public class GroupData2 {
    private int id = Integer.MAX_VALUE;
    private String name;
    private String header;
    private String footer;

    public GroupData2 withId(int id) {
        this.id = id;
        return this;
    }

    public GroupData2 withName(String name) {
        this.name = name;
        return this;
    }

    public GroupData2 withHeader(String header) {
        this.header = header;
        return this;
    }

    public GroupData2 withFooter(String footer) {
        this.footer = footer;
        return this;
    }


    @Override
    public String toString() {
        return "GroupData2{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GroupData2 that = (GroupData2) o;
        return id == that.id &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getHeader() {
        return header;
    }

    public String getFooter() {
        return footer;
    }

}
