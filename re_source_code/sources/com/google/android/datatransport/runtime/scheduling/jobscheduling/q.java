package com.google.android.datatransport.runtime.scheduling.jobscheduling;

import java.util.Map;

/* JADX INFO: compiled from: AutoValue_SchedulerConfig.java */
/* JADX INFO: loaded from: classes2.dex */
final class q extends t {
    private final e.e.b.a.i.c0.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Map<e.e.b.a.d, t.b> f11343b;

    q(e.e.b.a.i.c0.a aVar, Map<e.e.b.a.d, t.b> map) {
        if (aVar == null) {
            throw new NullPointerException("Null clock");
        }
        this.a = aVar;
        if (map == null) {
            throw new NullPointerException("Null values");
        }
        this.f11343b = map;
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t
    e.e.b.a.i.c0.a e() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof t)) {
            return false;
        }
        t tVar = (t) obj;
        return this.a.equals(tVar.e()) && this.f11343b.equals(tVar.h());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.jobscheduling.t
    Map<e.e.b.a.d, t.b> h() {
        return this.f11343b;
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f11343b.hashCode();
    }

    public String toString() {
        return "SchedulerConfig{clock=" + this.a + ", values=" + this.f11343b + "}";
    }
}
