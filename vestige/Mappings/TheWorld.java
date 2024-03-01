package vestige.Mappings;


import java.util.List;

public class TheWorld {

    public static List<com.craftrise.m9> loadedEntityList() {
        return TheMinecraft.GetWorld().g;
    }
    public static List<com.craftrise.mg> playerEntities() {
        return TheMinecraft.GetWorld().H;
    }

}
