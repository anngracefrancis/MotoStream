package kotlin.p002reflect.jvm.internal.impl.descriptors.r1.b;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.a;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.f.c;

/* JADX INFO: compiled from: ReflectJavaAnnotationOwner.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {
    /* JADX WARN: Code duplicated, block: B:11:0x002e  */
    /* JADX WARN: Code duplicated, block: B:15:? A[RETURN, SYNTHETIC] */
    public static final e a(Annotation[] annotationArr, c cVar) {
        m.f(annotationArr, "<this>");
        m.f(cVar, "fqName");
        for (Annotation annotation : annotationArr) {
            if (m.a(d.a(a.b(a.a(annotation))).b(), cVar)) {
                if (annotation != null) {
                    return new e(annotation);
                }
                return null;
            }
        }
        annotation = null;
        if (annotation != null) {
            return new e(annotation);
        }
        return null;
    }

    public static final List<e> b(Annotation[] annotationArr) {
        m.f(annotationArr, "<this>");
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new e(annotation));
        }
        return arrayList;
    }
}
