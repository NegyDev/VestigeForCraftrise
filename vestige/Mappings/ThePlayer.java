package vestige.Mappings;

import com.craftrise.dR;
import cr.launcher.BlockPos;
import cr.launcher.Config;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.Math.*;

public class ThePlayer {


    public static double GetPosX() {
        return TheMinecraft.GetPlayer().bE;
    }

    public static double GetPosY() {
        return TheMinecraft.GetPlayer().aY;
    }

    public static double GetPosZ() {
        return TheMinecraft.GetPlayer().bH;
    }

    public static float GetRotationPitch() {
        return TheMinecraft.GetPlayer().N;
    }

    public static float GetrotationYaw() {
        return TheMinecraft.GetPlayer().bL;
    }

    public static double GetMotionX() {
        return TheMinecraft.GetPlayer().bh.b(5L);
    }

    public static void setRightClickTimer(float value){
        try{
            Field field = com.craftrise.client.S.class.getDeclaredField("bl");
            field.setAccessible(true);
            field.set(Config.getMinecraft(),value);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static double GetMotionY() {
        return TheMinecraft.GetPlayer().aT.b(5L);
    }

    public static double GetMotionZ() {
        return TheMinecraft.GetPlayer().bf.b(5L);
    }

    public static void SetMotionX(double value) {
        TheMinecraft.GetPlayer().bh = new dR(value);
    }

    public static void SetMotionY(double value) {
        TheMinecraft.GetPlayer().aT = new dR(value);
    }

    public static void SetMotionZ(double value) {
        TheMinecraft.GetPlayer().bf = new dR(value);
    }
    public static void SetRotationYaw(float value){
        TheMinecraft.GetPlayer().bL = value;
    }

    public static void SetRotationPitch(float value){
        TheMinecraft.GetPlayer().N = value;
    }
    public static int GethurtResistantTime() {
        return TheMinecraft.GetPlayer().bK;
    }

    public double GetprevPosX() {
        return TheMinecraft.GetPlayer().a4;
    }

    public static cr.p getb7(){
        try {
            Field field = com.craftrise.client.S.class.getDeclaredField("b7");
            field.setAccessible(true);
            return (cr.p)field.get(Config.getMinecraft());
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public double GetprevPosY() {
        return TheMinecraft.GetPlayer().L;
    }

    public double GetprevPosZ() {
        return TheMinecraft.GetPlayer().at;
    }

    public float GetprevRotationYaw() {
        return TheMinecraft.GetPlayer().C;
    }

    public float GetprevRotationPitch() {
        return TheMinecraft.GetPlayer().aM;
    }

    public int Getdimension() {
        return TheMinecraft.GetPlayer().ac;
    }

    public int GetportalCounter() {
        return TheMinecraft.GetPlayer().m;
    }

    public int GetchunkCoordX() {
        return TheMinecraft.GetPlayer().aV;
    }

    public int GetfireResistance() {
        return TheMinecraft.GetPlayer().aE;
    }

    public int Getfire() {
        return TheMinecraft.GetPlayer().aN;
    }

    public int GetticksExisted() {
        return TheMinecraft.GetPlayer().Z;
    }

    public float GetentityCollisionReduction() {
        return TheMinecraft.GetPlayer().ap;
    }

    public boolean GetnoClip() {
        return TheMinecraft.GetPlayer().by;
    }

    public double GetlastTickPosX() {
        return TheMinecraft.GetPlayer().a6;
    }

    public double GetlastTickPosY() {
        return TheMinecraft.GetPlayer().h;
    }

    public double GetlastTickPosZ() {
        return TheMinecraft.GetPlayer().G;
    }

    public float Getwidth() {
        return TheMinecraft.GetPlayer().aw;
    }

    public float Getheight() {
        return TheMinecraft.GetPlayer().t;
    }

    public float GetprevDistanceWalkedModified() {
        return TheMinecraft.GetPlayer().aG;
    }

    public boolean GetisCollidedHorizontally() {
        return TheMinecraft.GetPlayer().ax;
    }

    public boolean GetisCollidedVertically() {
        return TheMinecraft.GetPlayer().aL;
    }

    public boolean GetisCollided() {
        return TheMinecraft.GetPlayer().a1;
    }

    public boolean GetisInWeb() {
        return TheMinecraft.GetPlayer().al;
    }

    public boolean GetisDead() {
        return TheMinecraft.GetPlayer().d;
    }

    public static void

    SetprevPosX(double prevposx) {
        TheMinecraft.GetPlayer().a4 = prevposx;
    }

    public static void

    SetprevPosY(double prevposy) {
        TheMinecraft.GetPlayer().L = prevposy;
    }

    public static void

    SetprevPosZ(double prevposz) {
        TheMinecraft.GetPlayer().at = prevposz;
    }

    public static void

    SetprevRotationYaw(float prevrotationyaw) {
        TheMinecraft.GetPlayer().C = prevrotationyaw;
    }

    public static void

    SetprevRotationPitch(float prevrotationpitch) {
        TheMinecraft.GetPlayer().aM = prevrotationpitch;
    }

    public static void

    Setdimension(int dimension) {
        TheMinecraft.GetPlayer().ac = dimension;
    }

    public static void

    SetportalCounter(int portalcounter) {
        TheMinecraft.GetPlayer().m = portalcounter;
    }

    public static void

    SetchunkCoordX(int chunkcoordx) {
        TheMinecraft.GetPlayer().aV = chunkcoordx;
    }

    public static void

    SetfireResistance(int fireresistance) {
        TheMinecraft.GetPlayer().aE = fireresistance;
    }

    public static void

    Setfire(int fire) {
        TheMinecraft.GetPlayer().aN = fire;
    }

    public static void

    SetticksExisted(int ticksexisted) {
        TheMinecraft.GetPlayer().Z = ticksexisted;
    }

    public static void

    SetentityCollisionReduction(float entitycollisionreduction) {
        TheMinecraft.GetPlayer().ap = entitycollisionreduction;
    }

    public static void

    SetnoClip(boolean noclip) {
        TheMinecraft.GetPlayer().by = noclip;
    }

    public static void

    SetlastTickPosX(double lasttickposx) {
        TheMinecraft.GetPlayer().a6 = lasttickposx;
    }

    public static void

    SetlastTickPosY(double lasttickposy) {
        TheMinecraft.GetPlayer().h = lasttickposy;
    }

    public static void

    SetlastTickPosZ(double lasttickposz) {
        TheMinecraft.GetPlayer().G = lasttickposz;
    }

    public static void

    Setwidth(float width) {
        TheMinecraft.GetPlayer().aw = width;
    }

    public static void Setheight(float height) {
        TheMinecraft.GetPlayer().t = height;
    }

    public static void

    SetprevDistanceWalkedModified(float prevdistancewalkedmodified) {
        TheMinecraft.GetPlayer().aG = prevdistancewalkedmodified;
    }

    public static void

    SetisCollidedHorizontally(boolean iscollidedhorizontally) {
        TheMinecraft.GetPlayer().ax = iscollidedhorizontally;
    }

    public static void

    SetisCollidedVertically(boolean iscollidedvertically) {
        TheMinecraft.GetPlayer().aL = iscollidedvertically;
    }

    public static void

    SetisCollided(boolean iscollided) {
        TheMinecraft.GetPlayer().a1 = iscollided;
    }


    public int GetsprintingTicksLeft() {
        return TheMinecraft.GetPlayer().m;
    }

    public float GetrenderArmYaw() {
        return TheMinecraft.GetPlayer().bb;
    }

    public float GetrenderArmPitch() {
        return TheMinecraft.GetPlayer().aG;
    }

    public float GetprevRenderArmYaw() {
        return TheMinecraft.GetPlayer().aO;
    }

    public float GetprevRenderArmPitch() {
        return TheMinecraft.GetPlayer().t;
    }

    public float GettimeInPortal() {
        return TheMinecraft.GetPlayer().bg;
    }

    public float GetprevTimeInPortal() {
        return TheMinecraft.GetPlayer().bC;
    }

    public static void

    SetsprintingTicksLeft(int sprintingticksleft) {
        TheMinecraft.GetPlayer().m = sprintingticksleft;
    }

    public static void

    SetrenderArmYaw(float renderarmyaw) {
        TheMinecraft.GetPlayer().bb = renderarmyaw;
    }

    public static void

    SetrenderArmPitch(float renderarmpitch) {
        TheMinecraft.GetPlayer().aG = renderarmpitch;
    }

    public static void

    SetprevRenderArmYaw(float prevrenderarmyaw) {
        TheMinecraft.GetPlayer().aO = prevrenderarmyaw;
    }

    public static void

    SetprevRenderArmPitch(float prevrenderarmpitch) {
        TheMinecraft.GetPlayer().t = prevrenderarmpitch;
    }


    public int GetsleepTimer() {
        return TheMinecraft.GetPlayer().m;
    }

    public float GetrenderOffsetY() {
        return TheMinecraft.GetPlayer().aO;
    }

    public float GetrenderOffsetZ() {
        return TheMinecraft.GetPlayer().bb;
    }

    public int GetexperienceLevel() {
        return TheMinecraft.GetPlayer().a9;
    }

    public int GetexperienceTotal() {
        return TheMinecraft.GetPlayer().aW;
    }

    public float Getexperience() {
        return TheMinecraft.GetPlayer().cB;
    }

    public int GetxpCooldown() {
        return TheMinecraft.GetPlayer().br;
    }

    public double GetprevChasingPosY() {
        return TheMinecraft.GetPlayer().ch;
    }

    public double GetchasingPosZ() {
        return TheMinecraft.GetPlayer().cI;
    }

    public float GetprevCameraYaw() {
        return TheMinecraft.GetPlayer().b_;
    }

    public static void

    SetsleepTimer(int sleeptimer) {
        TheMinecraft.GetPlayer().m = sleeptimer;
    }

    public static void

    SetrenderOffsetY(float renderoffsety) {
        TheMinecraft.GetPlayer().aO = renderoffsety;
    }

    public static void

    SetrenderOffsetZ(float renderoffsetz) {
        TheMinecraft.GetPlayer().bb = renderoffsetz;
    }

    public static void

    SetexperienceLevel(int experiencelevel) {
        TheMinecraft.GetPlayer().a9 = experiencelevel;
    }

    public static void

    SetexperienceTotal(int experiencetotal) {
        TheMinecraft.GetPlayer().aW = experiencetotal;
    }

    public static void

    Setexperience(float experience) {
        TheMinecraft.GetPlayer().cB = experience;
    }

    public static void

    SetxpCooldown(int xpcooldown) {
        TheMinecraft.GetPlayer().br = xpcooldown;
    }

    public static void

    SetprevChasingPosY(double prevchasingposy) {
        TheMinecraft.GetPlayer().ch = prevchasingposy;
    }

    public static void

    SetchasingPosZ(double chasingposz) {
        TheMinecraft.GetPlayer().cI = chasingposz;
    }

    public static void

    SetprevCameraYaw(float prevcamerayaw) {
        TheMinecraft.GetPlayer().b_ = prevcamerayaw;
    }

    public static float GetEyeHeight() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Object ThePlayer = TheMinecraft.GetPlayer();

        Class<?> playerClass = ThePlayer.getClass();
        Method getEyeHeightMethod = playerClass.getMethod("e");
        float result = (float) getEyeHeightMethod.invoke(ThePlayer);

        return result;
    }

    public static double GetDistanceToEntity(com.craftrise.m9 m92) {
        try {
            double f2 = (TheMinecraft.GetPlayer().bE- m92.bE);
            double f3 = (TheMinecraft.GetPlayer().aY - m92.aY);
            double f4 = (TheMinecraft.GetPlayer().bH - m92.bH);
            double result = Math.sqrt(f2 * f2 + f3 * f3 + f4 * f4);
            return result;
        }
        catch (Exception e){
            e.printStackTrace();
            return -1;
        }

    }
    public static double Direction(){
        float rotationYaw = GetrotationYaw();
        if (TheMinecraft.GetPlayer().l.b.a(5L) < 0f) rotationYaw += 180f;
        float forward = 1f;
        if (TheMinecraft.GetPlayer().l.b.a(5L) < 0f) forward = -0.5f; else if (TheMinecraft.GetPlayer().l.b.a(5L) > 0f) forward = 0.5f;
        if (TheMinecraft.GetPlayer().l.c.a(5L) > 0f) rotationYaw -= 90f * forward;
        if (TheMinecraft.GetPlayer().l.c.a(5L) < 0f) rotationYaw += 90f * forward;
        return Math.toRadians(rotationYaw);
    }
    public static void Strafe(float speed){
        if (!isMoving()) return;
        SetMotionX(-sin(Direction()) * speed);;
        SetMotionZ(cos(Direction()) * speed);
    }
    public static float GetSpeed(){
        return (float) sqrt(GetMotionX() * GetMotionX() + GetMotionZ() * GetMotionZ());
    }

    public static boolean isMoving(){
        final BlockPos offset2 = null;
        return TheMinecraft.GetPlayer() != null && (TheMinecraft.GetPlayer().l.b.a(5L) != 0f || TheMinecraft.GetPlayer().l.c.a(5L) != 0f);
    }
    public static void Strafe(){
        Strafe(GetSpeed());
    }

    public static boolean onGround(){
        return TheMinecraft.GetPlayer().s.a(522424);
    }
    public static void jump() {
        try {
            Class<?> entityLivingBaseClass = Class.forName("com.craftrise.mg");
            Method jump = entityLivingBaseClass.getMethod("y", long.class);
            jump.setAccessible(true);
            jump.invoke(TheMinecraft.GetPlayer(), 5L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void SetPosition(double x, double y, double z){
        try{
            Class<?> Entity = com.craftrise.m9.class;
            Method setPosition = Entity.getMethod("b",double.class,double.class,double.class,long.class);
            setPosition.invoke(TheMinecraft.GetPlayer(),x,y,z,5L);
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }



}
