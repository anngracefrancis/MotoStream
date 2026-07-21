package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.reflect.Modifier;
import kotlin.p002reflect.jvm.internal.impl.descriptors.l1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.m1;
import kotlin.p002reflect.jvm.internal.impl.descriptors.q1.b;
import kotlin.p002reflect.jvm.internal.impl.descriptors.q1.c;
import kotlin.reflect.y.internal.j0.d.a.n0.s;

/* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface v extends s {

    /* JADX INFO: compiled from: ReflectJavaModifierListOwner.kt */
    public static final class a {
        public static m1 a(v vVar) {
            int iE = vVar.E();
            if (Modifier.isPublic(iE)) {
                return l1.h.f25160c;
            }
            if (Modifier.isPrivate(iE)) {
                return l1.e.f25157c;
            }
            if (Modifier.isProtected(iE)) {
                return Modifier.isStatic(iE) ? c.f25310c : b.f25309c;
            }
            return kotlin.p002reflect.jvm.internal.impl.descriptors.q1.a.f25308c;
        }

        public static boolean b(v vVar) {
            return Modifier.isAbstract(vVar.E());
        }

        public static boolean c(v vVar) {
            return Modifier.isFinal(vVar.E());
        }

        public static boolean d(v vVar) {
            return Modifier.isStatic(vVar.E());
        }
    }

    int E();
}
