package net.minecraft.client.renderer;
import com.craftrise.client.bO;

import java.lang.reflect.InvocationTargetException;
import java.nio.FloatBuffer;

public class GlStateManager{
    private static boolean openGL14 = false;
    public static void pushAttrib(){
        bO.f();
    }
    public static void disableTexture2D(){
        bO.r();
    }
    public static void enableTexture2D(){
       try{
           bO.class.getMethod("c").invoke(null);
       }catch (Exception e){
           e.printStackTrace();
       }
    }

    public static void setActiveTexture(int texture){
        bO.m(texture);
    }
    public static void deleteTexture(int texture){
        bO.b(texture);
    }
    public static void bindTexture(int texture){
        bO.l(texture);
    }
    public static void enableNormalize(){
        bO.o();
    }
    public static void disableNormalize(){
        bO.E();
    }
    public static void shadeModel(int mode){
        bO.o(mode);
    }

    public static void enableRescaleNormal(){
        bO.G();
    }
    public static void disableRescaleNormal(){
        bO.J();
    }
    public static void viewport(int x, int y, int width, int height){
        bO.a(x,y,width,height);
    }

    public static void colorMask(boolean red, boolean green, boolean blue, boolean alpha){
        bO.a(red,green,blue,alpha);
    }
    public static void clearDepth(double depth){
        bO.a(depth);
    }
    public static void clear(int mask){
        bO.g(mask);
    }
    public static void blendFunc(int srcFactor, int dstFactor){
        bO.b(srcFactor,dstFactor);
    }
    public static void tryBlendFuncSeparate(int srcFactor, int dstFactor, int srcFactorAlpha, int dstFactorAlpha){
        bO.b(srcFactor, dstFactor, srcFactorAlpha, dstFactorAlpha);
    }
    public static void alphaFunc(int func, float ref){
        bO.a(func, ref);
    }
    public static void disableAlpha(){
        bO.t();
    }
    public static void enableAlpha(){
        bO.h();
    }
    public static void disableBlend(){
        bO.l();
    }
    public static void enableBlend()
    {
        bO.e();
    }
    public static void matrixMode(int mode){
        bO.n(mode);
    }
    public static void loadIdentity(){
        bO.z();
    }
    public static void pushMatrix(){
        bO.H();
    }
    public static void popMatrix(){
        bO.y();
    }
    public static void ortho(double left, double right, double bottom, double top, double zNear, double zFar){
        bO.a(left,right,bottom,top,zNear,zFar);
    }
    public static void rotate(float angle, float x, float y, float z){
        bO.a(angle,x,y,z);
    }
    public static void scale(double x, double y, double z){
        bO.a(x,y,z);
    }
    public static void translate(float x, float y, float z){
        bO.b(x,y,z);
    }
    public static void translate(double x, double y, double z){
        bO.b(x,y,z);
    }
    public static void multMatrix(FloatBuffer matrix){
        bO.a(matrix);
    }
    public static void resetColor(){
        bO.x();
    }
    public static void color(float colorRed, float colorGreen, float colorBlue, float colorAlpha){
        bO.b(colorRed,colorGreen,colorBlue,colorAlpha);
    }
    public static void color(float colorRed, float colorGreen, float colorBlue){
        bO.b(colorRed, colorGreen, colorBlue, 1.0f);
    }

}
