package com.facebook.internal.s0;

import kotlin.jvm.internal.m;

/* JADX INFO: compiled from: GateKeeper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f9857b;

    public a(String str, boolean z) {
        m.f(str, "name");
        this.a = str;
        this.f9857b = z;
    }

    public final String a() {
        return this.a;
    }

    public final boolean b() {
        return this.f9857b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return m.a(this.a, aVar.a) && this.f9857b == aVar.f9857b;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v2 */
    /* JADX WARN: Type inference failed for: r1v3 */
    public int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        boolean z = this.f9857b;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "GateKeeper(name=" + this.a + ", value=" + this.f9857b + ')';
    }
}
