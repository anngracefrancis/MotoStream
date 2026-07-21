package com.google.firebase.r;

import java.util.List;

/* JADX INFO: compiled from: AutoValue_HeartBeatResult.java */
/* JADX INFO: loaded from: classes2.dex */
final class e extends l {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<String> f19893b;

    e(String str, List<String> list) {
        if (str == null) {
            throw new NullPointerException("Null userAgent");
        }
        this.a = str;
        if (list == null) {
            throw new NullPointerException("Null usedDates");
        }
        this.f19893b = list;
    }

    @Override // com.google.firebase.r.l
    public List<String> b() {
        return this.f19893b;
    }

    @Override // com.google.firebase.r.l
    public String c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return this.a.equals(lVar.c()) && this.f19893b.equals(lVar.b());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19893b.hashCode();
    }

    public String toString() {
        return "HeartBeatResult{userAgent=" + this.a + ", usedDates=" + this.f19893b + "}";
    }
}
