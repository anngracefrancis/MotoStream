package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.lang.reflect.AnnotatedElement;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.d.a.n0.d;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface h extends d {

    /* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
    public static final class a {
        public static e a(h hVar, c cVar) {
            Annotation[] declaredAnnotations;
            m.f(cVar, "fqName");
            AnnotatedElement annotatedElementW = hVar.w();
            if (annotatedElementW == null || (declaredAnnotations = annotatedElementW.getDeclaredAnnotations()) == null) {
                return null;
            }
            return i.a(declaredAnnotations, cVar);
        }

        public static List<e> b(h hVar) {
            Annotation[] declaredAnnotations;
            List<e> listB;
            AnnotatedElement annotatedElementW = hVar.w();
            return (annotatedElementW == null || (declaredAnnotations = annotatedElementW.getDeclaredAnnotations()) == null || (listB = i.b(declaredAnnotations)) == null) ? u.j() : listB;
        }

        public static boolean c(h hVar) {
            return false;
        }
    }

    AnnotatedElement w();
}
