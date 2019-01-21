package ru.stqa.pft.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Groups extends ForwardingSet<GroupData2> {

    private Set<GroupData2> delegate;

    public Groups(Groups group) {
        this.delegate = new HashSet<GroupData2>(group.delegate);
    }

    public Groups() {
        this.delegate = new HashSet<GroupData2>();
    }

    @Override
    protected Set<GroupData2> delegate() {
        return delegate;
    }

    public Groups withAdded(GroupData2 group) {
        Groups groups = new Groups(this);
        groups.add(group);
        return groups;
    }

    public Groups without(GroupData2 group) {
        Groups groups = new Groups(this);
        groups.remove(group);
        return groups;
    }
}
