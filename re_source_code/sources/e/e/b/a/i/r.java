package e.e.b.a.i;

import java.util.Set;

/* JADX INFO: compiled from: TransportFactoryImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class r implements e.e.b.a.g {
    private final Set<e.e.b.a.b> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final q f20841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final t f20842c;

    r(Set<e.e.b.a.b> set, q qVar, t tVar) {
        this.a = set;
        this.f20841b = qVar;
        this.f20842c = tVar;
    }

    @Override // e.e.b.a.g
    public <T> e.e.b.a.f<T> a(String str, Class<T> cls, e.e.b.a.b bVar, e.e.b.a.e<T, byte[]> eVar) {
        if (this.a.contains(bVar)) {
            return new s(this.f20841b, str, bVar, eVar, this.f20842c);
        }
        throw new IllegalArgumentException(String.format("%s is not supported byt this factory. Supported encodings are: %s.", bVar, this.a));
    }
}
