package com.google.firebase.crashlytics.internal.p;

import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.java */
/* JADX INFO: loaded from: classes2.dex */
final class d extends f0.a.AbstractC0210a {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19344b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f19345c;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.java */
    static final class b extends f0.a.AbstractC0210a.AbstractC0211a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19346b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f19347c;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a.AbstractC0211a
        public f0.a.AbstractC0210a a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " arch";
            }
            if (this.f19346b == null) {
                str2 = str2 + " libraryName";
            }
            if (this.f19347c == null) {
                str2 = str2 + " buildId";
            }
            if (str2.isEmpty()) {
                return new d(this.a, this.f19346b, this.f19347c);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a.AbstractC0211a
        public f0.a.AbstractC0210a.AbstractC0211a b(String str) {
            if (str == null) {
                throw new NullPointerException("Null arch");
            }
            this.a = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a.AbstractC0211a
        public f0.a.AbstractC0210a.AbstractC0211a c(String str) {
            if (str == null) {
                throw new NullPointerException("Null buildId");
            }
            this.f19347c = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a.AbstractC0211a
        public f0.a.AbstractC0210a.AbstractC0211a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null libraryName");
            }
            this.f19346b = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a
    public String b() {
        return this.a;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a
    public String c() {
        return this.f19345c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.a.AbstractC0210a
    public String d() {
        return this.f19344b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.a.AbstractC0210a)) {
            return false;
        }
        f0.a.AbstractC0210a abstractC0210a = (f0.a.AbstractC0210a) obj;
        return this.a.equals(abstractC0210a.b()) && this.f19344b.equals(abstractC0210a.d()) && this.f19345c.equals(abstractC0210a.c());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19344b.hashCode()) * 1000003) ^ this.f19345c.hashCode();
    }

    public String toString() {
        return "BuildIdMappingForArch{arch=" + this.a + ", libraryName=" + this.f19344b + ", buildId=" + this.f19345c + "}";
    }

    private d(String str, String str2, String str3) {
        this.a = str;
        this.f19344b = str2;
        this.f19345c = str3;
    }
}
