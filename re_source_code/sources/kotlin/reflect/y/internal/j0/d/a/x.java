package kotlin.reflect.y.internal.j0.d.a;

import java.util.EnumMap;
import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: JavaTypeQualifiersByElementType.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class x {
    private final EnumMap<b, q> a;

    public x(EnumMap<b, q> enumMap) {
        m.f(enumMap, "defaultQualifiers");
        this.a = enumMap;
    }

    public final q a(b bVar) {
        return this.a.get(bVar);
    }

    public final EnumMap<b, q> b() {
        return this.a;
    }
}
