package com.google.zxing;

/* JADX INFO: compiled from: Dimension.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f20302b;

    public int a() {
        return this.f20302b;
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.a == bVar.a && this.f20302b == bVar.f20302b) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (this.a * 32713) + this.f20302b;
    }

    public String toString() {
        return this.a + "x" + this.f20302b;
    }
}
