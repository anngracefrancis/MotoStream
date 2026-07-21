package com.google.firebase.crashlytics.internal.p;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
/* JADX INFO: loaded from: classes2.dex */
final class p extends f0.e.d.a.b.c {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19448b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> f19449c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f0.e.d.a.b.c f19450d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f19451e;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.java */
    static final class b extends f0.e.d.a.b.c.AbstractC0217a {
        private String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private String f19452b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> f19453c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f0.e.d.a.b.c f19454d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private Integer f19455e;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c.AbstractC0217a
        public f0.e.d.a.b.c a() {
            String str = this.a;
            String str2 = HttpUrl.FRAGMENT_ENCODE_SET;
            if (str == null) {
                str2 = HttpUrl.FRAGMENT_ENCODE_SET + " type";
            }
            if (this.f19453c == null) {
                str2 = str2 + " frames";
            }
            if (this.f19455e == null) {
                str2 = str2 + " overflowCount";
            }
            if (str2.isEmpty()) {
                return new p(this.a, this.f19452b, this.f19453c, this.f19454d, this.f19455e.intValue());
            }
            throw new IllegalStateException("Missing required properties:" + str2);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c.AbstractC0217a
        public f0.e.d.a.b.c.AbstractC0217a b(f0.e.d.a.b.c cVar) {
            this.f19454d = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c.AbstractC0217a
        public f0.e.d.a.b.c.AbstractC0217a c(List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> list) {
            if (list == null) {
                throw new NullPointerException("Null frames");
            }
            this.f19453c = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c.AbstractC0217a
        public f0.e.d.a.b.c.AbstractC0217a d(int i2) {
            this.f19455e = Integer.valueOf(i2);
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c.AbstractC0217a
        public f0.e.d.a.b.c.AbstractC0217a e(String str) {
            this.f19452b = str;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c.AbstractC0217a
        public f0.e.d.a.b.c.AbstractC0217a f(String str) {
            if (str == null) {
                throw new NullPointerException("Null type");
            }
            this.a = str;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c
    public f0.e.d.a.b.c b() {
        return this.f19450d;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c
    public List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> c() {
        return this.f19449c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c
    public int d() {
        return this.f19451e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c
    public String e() {
        return this.f19448b;
    }

    public boolean equals(Object obj) {
        String str;
        f0.e.d.a.b.c cVar;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b.c)) {
            return false;
        }
        f0.e.d.a.b.c cVar2 = (f0.e.d.a.b.c) obj;
        return this.a.equals(cVar2.f()) && ((str = this.f19448b) != null ? str.equals(cVar2.e()) : cVar2.e() == null) && this.f19449c.equals(cVar2.c()) && ((cVar = this.f19450d) != null ? cVar.equals(cVar2.b()) : cVar2.b() == null) && this.f19451e == cVar2.d();
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.c
    public String f() {
        return this.a;
    }

    public int hashCode() {
        int iHashCode = (this.a.hashCode() ^ 1000003) * 1000003;
        String str = this.f19448b;
        int iHashCode2 = (((iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003) ^ this.f19449c.hashCode()) * 1000003;
        f0.e.d.a.b.c cVar = this.f19450d;
        return ((iHashCode2 ^ (cVar != null ? cVar.hashCode() : 0)) * 1000003) ^ this.f19451e;
    }

    public String toString() {
        return "Exception{type=" + this.a + ", reason=" + this.f19448b + ", frames=" + this.f19449c + ", causedBy=" + this.f19450d + ", overflowCount=" + this.f19451e + "}";
    }

    private p(String str, String str2, List<f0.e.d.a.b.AbstractC0220e.AbstractC0222b> list, f0.e.d.a.b.c cVar, int i2) {
        this.a = str;
        this.f19448b = str2;
        this.f19449c = list;
        this.f19450d = cVar;
        this.f19451e = i2;
    }
}
