package org.mclroleplay.mcltrade.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import org.mclroleplay.mcltrade.MclTrade;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class ConfigSave {

    private static YamlDocument configconfig;
    private static YamlDocument configprice;

    public void createconfig(MclTrade pl) {
        try {
            configconfig = YamlDocument.create(new File(pl.getDataFolder(), "config.yml"), Objects.requireNonNull(pl.getResource("config.yml")));
            configconfig.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
    public static String queryconfig(String st){
        return configconfig.getString(st);
    }

    public void createprice(MclTrade pl) {
        try {
            configprice = YamlDocument.create(new File(pl.getDataFolder(), "price.yml"),pl.getResource("price.yml"));
            configprice.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String queryprice(String st){
        return configprice.getString(st);
    }
}

