package kotlin.reflect.y.internal.j0.m;

import kotlin.jvm.internal.m;
import kotlin.reflect.KClass;

/* JADX INFO: compiled from: AttributeArrayOwner.kt */
/* JADX INFO: loaded from: classes3.dex */
public abstract class e<K, T> extends a<K, T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private c<T> f24893f;

    protected e(c<T> cVar) {
        m.f(cVar, "arrayMap");
        this.f24893f = cVar;
    }

    @Override // kotlin.reflect.y.internal.j0.m.a
    protected final c<T> c() {
        return this.f24893f;
    }

    /* JADX WARN: Multi-variable type inference failed */
    protected final void h(KClass<? extends K> kClass, T t) {
        m.f(kClass, "tClass");
        m.f(t, "value");
        int iD = f().d(kClass);
        int iC = this.f24893f.c();
        if (iC == 0) {
            this.f24893f = new o(t, iD);
            return;
        }
        if (iC == 1) {
            c<T> cVar = this.f24893f;
            m.d(cVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.OneElementArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
            o oVar = (o) cVar;
            if (oVar.h() == iD) {
                this.f24893f = new o(t, iD);
                return;
            } else {
                d dVar = new d();
                this.f24893f = dVar;
                dVar.f(oVar.h(), oVar.i());
            }
        }
        this.f24893f.f(iD, t);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public e() {
        i iVar = i.f24904f;
        m.d(iVar, "null cannot be cast to non-null type org.jetbrains.kotlin.util.ArrayMap<T of org.jetbrains.kotlin.util.AttributeArrayOwner>");
        this(iVar);
    }
}
