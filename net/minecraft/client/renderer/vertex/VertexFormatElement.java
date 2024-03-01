package net.minecraft.client.renderer.vertex;

import com.craftrise.client.fF;

public class VertexFormatElement extends com.craftrise.client.fF {
    public VertexFormatElement(int i, fF.b b, fF.a a, int i1) {
        super(i, b, a, i1);
    }

    public final boolean isPositionElement() {
        try {
            return (boolean) fF.class.getMethod("a").invoke(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
