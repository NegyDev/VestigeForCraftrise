package vestige.Events.Transformers;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Opcodes;

public class EventMotionUpdate {
	
	public static byte[] TransformClient(byte[] originalBytes) {
	    ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
	    ClassReader classReader = new ClassReader(originalBytes);
	    classReader.accept(new ClassVisitor(Opcodes.ASM9, classWriter) {
	        @Override
	        public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
	            MethodVisitor originalMethodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
	            if (name.equals("V") && descriptor.equals("(J)V")) {
	                return new MethodVisitor(Opcodes.ASM9, originalMethodVisitor) {
	                    @Override
	                    public void visitCode() {
	                        super.visitCode();
	                        mv.visitTypeInsn(Opcodes.NEW, "vestige/event/impl/EventMotionUpdate");
                            mv.visitInsn(Opcodes.DUP);
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitFieldInsn(Opcodes.GETFIELD, "com/craftrise/client/fa", "bE", "D");
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "com/craftrise/client/fa", "a", "()Lcom/craftrise/ah;", false);
                            mv.visitFieldInsn(Opcodes.GETFIELD, "com/craftrise/ah", "a", "D");
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitFieldInsn(Opcodes.GETFIELD, "com/craftrise/client/fa", "bH", "D");
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitFieldInsn(Opcodes.GETFIELD, "com/craftrise/client/fa", "bL", "F");
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitFieldInsn(Opcodes.GETFIELD, "com/craftrise/client/fa", "N", "F");
                            mv.visitVarInsn(Opcodes.ALOAD, 0);
                            mv.visitFieldInsn(Opcodes.GETFIELD, "com/craftrise/client/fa", "s", "Lcr/launcher/eb;");
                            mv.visitLdcInsn(new Long(522424L));
                            mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "cr/launcher/eb", "a", "(J)Z", false);
	                        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "vestige/event/impl/EventMotionUpdate", "<init>", "(DDDFFZ)V", false);
	                        mv.visitVarInsn(Opcodes.ASTORE, 6);
	                        mv.visitVarInsn(Opcodes.ALOAD, 6);
	                        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "vestige/event/impl/EventMotionUpdate", "call", "()V", false);
	                        
	                    }
	                };
	            }else if (name.equals("v") && descriptor.equals("(J)V")) {
	                return new MethodVisitor(Opcodes.ASM9, originalMethodVisitor) {
	                    @Override
	                    public void visitCode() {
	                        super.visitCode();
	                        mv.visitTypeInsn(Opcodes.NEW, "vestige/event/impl/EventUpdate");
                            mv.visitInsn(Opcodes.DUP);
	                        mv.visitMethodInsn(Opcodes.INVOKESPECIAL, "vestige/event/impl/EventUpdate", "<init>", "()V", false);
	                        mv.visitMethodInsn(Opcodes.INVOKEVIRTUAL, "vestige/event/impl/EventUpdate", "call", "()V", false);
	                    }
	                };
	            }
	            return originalMethodVisitor;
	        }
	    }, 0);
	    return classWriter.toByteArray();
	}


}
