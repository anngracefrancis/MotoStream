package com.google.firebase.u;

/* JADX INFO: compiled from: AutoValue_LibraryVersion.java */
/* JADX INFO: loaded from: classes2.dex */
final class c extends g {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f20131b;

    c(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("Null libraryName");
        }
        this.a = str;
        if (str2 == null) {
            throw new NullPointerException("Null version");
        }
        this.f20131b = str2;
    }

    @Override // com.google.firebase.u.g
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.u.g
    public String c() {
        return this.f20131b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return this.a.equals(gVar.b()) && this.f20131b.equals(gVar.c());
    }

    public int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f20131b.hashCode();
    }

    public String toString() {
        return "LibraryVersion{libraryName=" + this.a + ", version=" + this.f20131b + "}";
    }
}
