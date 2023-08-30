package org.mclroleplay.mcltrade.config;

import dev.dejvokep.boostedyaml.YamlDocument;
import dev.dejvokep.boostedyaml.settings.dumper.DumperSettings;
import dev.dejvokep.boostedyaml.settings.general.GeneralSettings;
import dev.dejvokep.boostedyaml.settings.loader.LoaderSettings;
import dev.dejvokep.boostedyaml.settings.updater.UpdaterSettings;
import org.mclroleplay.mcltrade.MclTrade;

import java.io.File;
import java.io.IOException;

public class ConfigSave {
    private MclTrade pl ;

    private static YamlDocument config;

    public void create(MclTrade pl) {
        this.pl =pl;
        try {
            config = YamlDocument.create;
            config.save();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String query(String st){
        return config.getString(st);
    }
}

