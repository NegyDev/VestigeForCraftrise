package vestige.Mappings;
import cr.launcher.main.a;
import cr.launcher.Config;

import java.lang.reflect.Field;

public class TheMinecraft {
    public static com.craftrise.client.fa GetPlayer(){
        return a.q;
    }
    public static com.craftrise.client.S GetMinecraft(){
        return Config.getMinecraft();
    }
    public static com.craftrise.client.cf GetWorld(){
        return GetMinecraft().bu;
    }
    public static com.craftrise.client.ez GetPlayerControllerMp(){
        return GetMinecraft().b;
    }
    public static com.craftrise.client.d0 GetFontRendererObj(){
        return GetMinecraft().j;
    }
    public static com.craftrise.client.dt InGameGui(){
        return GetMinecraft().K;
    }


}
