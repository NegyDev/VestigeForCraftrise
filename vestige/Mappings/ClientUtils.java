package vestige.Mappings;
import com.google.gson.JsonObject;
import cr.launcher.IChatComponent;

public class ClientUtils {
    public static void displayChatMessage(String message) {

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("text", message);

        TheMinecraft.GetPlayer().a(IChatComponent.Serializer.jsonToComponent(jsonObject.toString()),5L);
    }
}
