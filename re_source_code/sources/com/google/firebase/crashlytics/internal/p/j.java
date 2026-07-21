package com.google.firebase.crashlytics.internal.p;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Application_Organization.java */
/* JADX INFO: loaded from: classes2.dex */
final class j extends f0.e.a.b {
    private final String a;

    @Override // com.google.firebase.crashlytics.h.p.f0.e.a.b
    public String a() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.a.b) {
            return this.a.equals(((f0.e.a.b) obj).a());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "Organization{clsId=" + this.a + "}";
    }
}
