package vestige.Events.Transformers;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Label;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class PacketEvents {
	public static byte[] TransformClient(byte[] originalBytes)
    {
        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        ClassVisitor classVisitor = new ClassVisitor(Opcodes.ASM9, classWriter)
        {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor original_mv = cv.visitMethod(access, name, descriptor, signature, exceptions);
                if (name.equals("a") && descriptor.equals("(Lio/netty/channel/ChannelHandlerContext;Lcom/craftrise/lv;J)V"))
                {
                    return new MethodVisitor(Opcodes.ASM9, original_mv) {
                        @Override
                        public void visitCode()
                        {
                        	 mv.visitTypeInsn(Opcodes.NEW, "vestige/event/impl/EventReceivePacket");
                             mv.visitInsn(Opcodes.DUP);
                             mv.visitVarInsn(Opcodes.ALOAD, 2);
                             mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "vestige/event/impl/EventReceivePacket", "<init>", "(Lcom/craftrise/lv;)V", false);
                             mv.visitVarInsn(Opcodes.ASTORE, 8);
                             mv.visitVarInsn(Opcodes.ALOAD, 8);
                             mv.visitMethodInsn(Opcodes.INVOKESTATIC, "vestige/event/impl/EventReceivePacket", "call", "()V", false);
                             mv.visitVarInsn(Opcodes.ALOAD, 8);
                             mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "vestige/event/impl/EventReceivePacket", "isCancelled", "()Z", false);
                             Label label = new Label();
                             mv.visitJumpInsn(Opcodes.IFEQ, label);
                             mv.visitInsn(Opcodes.RETURN);
                             mv.visitLabel(label);
                             mv.visitCode();

                        }
                    };
                }else if(name.equals("a") && descriptor.equals("(Lcom/craftrise/lv;J)V")) {
                	return new MethodVisitor(Opcodes.ASM9, original_mv) {
	                    @Override
	                    public void visitCode() {
	                        mv.visitTypeInsn(Opcodes.NEW, "vestige/event/impl/EventSendPacket");
                            mv.visitInsn(Opcodes.DUP);
                            mv.visitVarInsn(Opcodes.ALOAD, 1);
	                        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "vestige/event/impl/EventSendPacket", "<init>", "(Lcom/craftrise/lv;)V", false);
	                        mv.visitVarInsn(Opcodes.ASTORE, 8);
	                        mv.visitVarInsn(Opcodes.ALOAD, 8);
                            mv.visitMethodInsn(Opcodes.INVOKESTATIC, "vestige/event/impl/EventSendPacket", "call", "()V", false);
                            mv.visitVarInsn(Opcodes.ALOAD, 8);
                            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "vestige/event/impl/EventSendPacket", "isCancelled", "()Z", false);
                            Label labell = new Label();
                            mv.visitJumpInsn(Opcodes.IFEQ, labell);
                            mv.visitInsn(Opcodes.RETURN);
                            mv.visitLabel(labell);
                            mv.visitCode();
	                    }
	                };
                }
                return original_mv;
            }
        };

        ClassReader classReader = new ClassReader(originalBytes);
        classReader.accept(classVisitor, 0);
        return classWriter.toByteArray();
    }

}
