package kotlin.reflect.y.internal.j0.l.v1;

import java.util.List;
import kotlin.jvm.internal.m;
import kotlin.reflect.y.internal.j0.l.z0;

/* JADX INFO: compiled from: TypeAttributeTranslators.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private final List<z0> a;

    /* JADX WARN: Multi-variable type inference failed */
    public a(List<? extends z0> list) {
        m.f(list, "translators");
        this.a = list;
    }

    public final List<z0> a() {
        return this.a;
    }
}
