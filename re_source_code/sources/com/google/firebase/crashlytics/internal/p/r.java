package com.google.firebase.crashlytics.internal.p;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
/* JADX INFO: loaded from: classes2.dex */
final class r extends f0.e.d.a.b.AbstractC0220e {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f19460b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> f19461c;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.java */
    static final class b extends f0.e.d.a.b.AbstractC0220e.AbstractC0221a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Integer f19462b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> f19463c;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0221a
        public f0.e.d.a.b.AbstractC0220e a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " name";
            }
            if (this.f19462b == null) {
                str2 = str2 + " importance";
            }
            if (this.f19463c == null) {
                str2 = str2 + " frames";
            }
            if (str2.isEmpty()) {
                return new r(this.a, this.f19462b.intValue(), this.f19463c);
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0221a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0221a b(List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f19463c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0221a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0221a c(int i2) {
            this.f19462b = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e.AbstractC0221a
        public f0.e.d.a.b.AbstractC0220e.AbstractC0221a d(String str) {
            if (str == null) {
                throw new NullPointerException("Null name");
            }
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e
    public List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> b() {
        return this.f19461c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e
    public int c() {
        return this.f19460b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0220e
    public String d() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.AbstractC0220e)) {
            return false;
        }
        f0.e.d.a.b.AbstractC0220e abstractC0220e = (f0.e.d.a.b.AbstractC0220e) obj;
        return this.a.equals(abstractC0220e.d()) && this.f19460b == abstractC0220e.c() && this.f19461c.equals(abstractC0220e.b());
    }

    public int hashCode() {
        return ((((this.a.hashCode() ^ 1000003) * 1000003) ^ this.f19460b) * 1000003) ^ this.f19461c.hashCode();
    }

    public String toString() {
        return "Thread{name=" + this.a + ", importance=" + this.f19460b + ", frames=" + this.f19461c + "}";
    }

    private r(String str, int i2, List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> list) {
        this.a = str;
        this.f19460b = i2;
        this.f19461c = list;
    }
}
