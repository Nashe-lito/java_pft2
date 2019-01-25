package ru.stqa.pft.addressbook.generators;

import ru.stqa.pft.addressbook.model.GroupData2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataGenerator {

    public static void main(String[] args) throws IOException {
        int count = Integer.parseInt(args[0]);
        File file = new File(args[1]);

        List<GroupData2> groups = generateGroups(count);
        save(groups, file);
    }

    private static void save(List<GroupData2> groups, File file) throws IOException {
        Writer writer = new FileWriter(file);
        for (GroupData2 group : groups){
            writer.write(String.format("%s; %s; %s\n", group.getName(), group.getHeader(), group.getFooter()));
        }
        writer.close();
    }

    private static List<GroupData2> generateGroups(int count) {
        List<GroupData2> groups = new ArrayList<GroupData2>();
        for (int i = 0; i < count; i++) {
            groups.add(new GroupData2().withName(String.format("test %s", i))
                    .withHeader(String.format("header %s", i)).withFooter(String.format("footer %s", i)));
        }
            return groups;
        }
    }
