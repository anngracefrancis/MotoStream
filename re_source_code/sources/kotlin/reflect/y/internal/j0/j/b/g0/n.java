package kotlin.reflect.y.internal.j0.j.b.g0;

import java.util.List;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.n1.c;

/* JADX INFO: compiled from: DeserializedAnnotations.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n extends a {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(kotlin.reflect.y.internal.j0.k.n nVar, Function0<? extends List<? extends c>> function0) {
        super(nVar, function0);
        m.f(nVar, "storageManager");
        m.f(function0, "compute");
    }

    @Override // kotlin.reflect.y.internal.j0.j.b.g0.a, kotlin.p002reflect.jvm.internal.impl.descriptors.n1.g
    public boolean isEmpty() {
        return false;
    }
}
