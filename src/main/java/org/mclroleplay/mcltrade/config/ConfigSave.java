package org.mclroleplay.mcltrade.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import org.mclroleplay.mcltrade.MclTrade;

import java.io.File;
import java.io.IOException;

public class ConfigSave {
    private MclTrade pl ;

    private static YamlDocument config;

    public void create(MclTrade pl) {
        this.pl =pl;
        try {
            config = YamlDocument.create(new File(pl.getDataFolder(), "config.yml"));
            config.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String query(String st){
        return config.getString(st);
    }
}

