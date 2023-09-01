package org.mclroleplay.mcltrade.events;

import org.mclroleplay.mcltrade.config.ConfigSave;

import java.util.ArrayList;

public class ItemSave {

    private String name;
    private int id;

    public itemwrite(String name, int age) {
        this.name = name;
        this.id = age;
    }

    public static String configitem (String st){
        return ConfigSave.queryitemsave(st);
    }
    public static String getitemname = configitem("item-name");
    private ArrayList<String> items = new ArrayList<>();





}
