package org.mclroleplay.mcltrade.config;

import org.bukkit.Material;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PriceCreate {
    List<String> materialNames = Arrays.stream(Material.values())
            .map(Material::name)
            .collect(Collectors.toList());
}
