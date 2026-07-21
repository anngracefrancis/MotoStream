package kotlin.reflect.y.internal.j0.l.u1;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.collections.u;
import kotlin.jvm.internal.m;
import kotlin.p002reflect.jvm.internal.impl.descriptors.h;
import kotlin.reflect.y.internal.j0.b.e;
import kotlin.reflect.y.internal.j0.l.e0;
import kotlin.reflect.y.internal.j0.l.e1;
import kotlin.reflect.y.internal.j0.l.t1.g;

/* JADX INFO: compiled from: ErrorTypeConstructor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class i implements e1 {
    private final j a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String[] f24845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f24846c;

    public i(j jVar, String... strArr) {
        m.f(jVar, "kind");
        m.f(strArr, "formatParams");
        this.a = jVar;
        this.f24845b = strArr;
        String strK = b.ERROR_TYPE.k();
        String strK2 = jVar.k();
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length);
        String str = String.format(strK2, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        m.e(str, "format(this, *args)");
        String str2 = String.format(strK, Arrays.copyOf(new Object[]{str}, 1));
        m.e(str2, "format(this, *args)");
        this.f24846c = str2;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public Collection<e0> a() {
        return u.j();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public e1 b(g gVar) {
        m.f(gVar, "kotlinTypeRefiner");
        return this;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    /* JADX INFO: renamed from: c */
    public h w() {
        return k.a.h();
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public boolean e() {
        return false;
    }

    public final j g() {
        return this.a;
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public List<kotlin.p002reflect.jvm.internal.impl.descriptors.e1> getParameters() {
        return u.j();
    }

    public final String h(int i2) {
        return this.f24845b[i2];
    }

    @Override // kotlin.reflect.y.internal.j0.l.e1
    public kotlin.reflect.y.internal.j0.b.h o() {
        return e.f23157h.a();
    }

    public String toString() {
        return this.f24846c;
    }
}
