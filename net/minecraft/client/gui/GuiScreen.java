package net.minecraft.client.gui;
import com.craftrise.client.dG;
import com.craftrise.client.et;

import java.io.IOException;

public class GuiScreen extends dG{
    public int width = this.u;
    public int height = this.A;

    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    protected void keyTyped(char typedChar, int keyCode) throws IOException {
        super.a(typedChar,keyCode);
    }
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException{
        super.mouseClicked(mouseX,mouseY,mouseButton);
    }
    protected void actionPerformed(et et2) throws IOException {
        super.actionPerformed(et2);
    }
    protected void mouseReleased(int mouseX, int mouseY, int state){
        super.a(mouseX, mouseY, state);
    }
    public void initGui() {
        super.initGui();
    }
    public void updateScreen() {
        super.updateScreen();
    }
    public void onGuiClosed(){
        super.onGuiClosed();
    }
}
