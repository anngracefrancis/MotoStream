package com.trello.rxlifecycle;

/* JADX INFO: compiled from: UntilEventObservableTransformer.java */
/* JADX INFO: loaded from: classes2.dex */
final class f<T, R> implements b<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final rx.e<R> f20656f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final R f20657g;

    public f(rx.e<R> eVar, R r) {
        this.f20656f = eVar;
        this.f20657g = r;
    }

    @Override // rx.m.e
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public rx.e<T> call(rx.e<T> eVar) {
        return eVar.P0(d.b(this.f20656f, this.f20657g));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || f.class != obj.getClass()) {
            return false;
        }
        f fVar = (f) obj;
        if (this.f20656f.equals(fVar.f20656f)) {
            return this.f20657g.equals(fVar.f20657g);
        }
        return false;
    }

    public int hashCode() {
        return (this.f20656f.hashCode() * 31) + this.f20657g.hashCode();
    }

    public String toString() {
        return "UntilEventObservableTransformer{lifecycle=" + this.f20656f + ", event=" + this.f20657g + '}';
    }
}
