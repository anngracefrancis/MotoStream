package com.google.firebase.crashlytics.internal.n;

/* JADX INFO: compiled from: AutoValue_InstallIdProvider_InstallIds.java */
/* JADX INFO: loaded from: classes2.dex */
final class n extends j0.a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19065b;

    n(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null crashlyticsInstallId");
        }
        this.a = str;
        this.f19065b = str2;
    }

    @Override // com.google.firebase.crashlytics.h.n.j0.a
    public String c() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.n.j0.a
    public String d() {
        return this.f19065b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j0.a)) {
            return false;
        }
        j0.a aVar = (j0.a) obj;
        if (this.a.equals(aVar.c())) {
            String str = this.f19065b;
            if (str == null) {
                if (aVar.d() == null) {
                    return true;
                }
            } else if (str.equals(aVar.d())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19065b;
        return iHashCode ^ (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "InstallIds{crashlyticsInstallId=" + this.a + ", firebaseInstallationId=" + this.f19065b + "}";
    }
}
