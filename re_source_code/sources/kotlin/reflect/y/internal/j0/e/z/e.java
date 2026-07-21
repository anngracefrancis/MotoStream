package kotlin.reflect.y.internal.j0.e.z;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.protobuf.h;

/* JADX INFO: compiled from: ProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends h.d<M>, T> T a(h.d<M> dVar, h.f<M, T> fVar) {
        m.f(dVar, "<this>");
        m.f(fVar, "extension");
        if (dVar.x(fVar)) {
            return (T) dVar.u(fVar);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <M extends h.d<M>, T> T b(h.d<M> dVar, h.f<M, List<T>> fVar, int i2) {
        m.f(dVar, "<this>");
        m.f(fVar, "extension");
        if (i2 < dVar.w(fVar)) {
            return (T) dVar.v(fVar, i2);
        }
        return null;
    }
}
