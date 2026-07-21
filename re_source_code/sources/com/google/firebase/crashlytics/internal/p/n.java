package com.google.firebase.crashlytics.internal.p;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
/* JADX INFO: loaded from: classes2.dex */
final class n extends f0.e.d.a.b {
    private final List<f0.e.d.a.b.AbstractC0220e> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f0.e.d.a.b.c f19434b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final f0.a f19435c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final f0.e.d.a.b.AbstractC0218d f19436d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<f0.e.d.a.b.AbstractC0214a> f19437e;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_Application_Execution.java */
    static final class b extends f0.e.d.a.b.AbstractC0216b {
        private List<f0.e.d.a.b.AbstractC0220e> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private f0.e.d.a.b.c f19438b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private f0.a f19439c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private f0.e.d.a.b.AbstractC0218d f19440d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private List<f0.e.d.a.b.AbstractC0214a> f19441e;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0216b
        public f0.e.d.a.b a() {
            f0.e.d.a.b.AbstractC0218d abstractC0218d = this.f19440d;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (abstractC0218d == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " signal";
            }
            if (this.f19441e == null) {
                str = str + " binaries";
            }
            if (str.isEmpty()) {
                return new n(this.a, this.f19438b, this.f19439c, this.f19440d, this.f19441e);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0216b
        public f0.e.d.a.b.AbstractC0216b b(f0.a aVar) {
            this.f19439c = aVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0216b
        public f0.e.d.a.b.AbstractC0216b c(List<f0.e.d.a.b.AbstractC0214a> list) {
            if (list == null) {
                throw new NullPointerException("Null binaries");
            }
            this.f19441e = list;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0216b
        public f0.e.d.a.b.AbstractC0216b d(f0.e.d.a.b.c cVar) {
            this.f19438b = cVar;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0216b
        public f0.e.d.a.b.AbstractC0216b e(f0.e.d.a.b.AbstractC0218d abstractC0218d) {
            if (abstractC0218d == null) {
                throw new NullPointerException("Null signal");
            }
            this.f19440d = abstractC0218d;
            return this;
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b.AbstractC0216b
        public f0.e.d.a.b.AbstractC0216b f(List<f0.e.d.a.b.AbstractC0220e> list) {
            this.a = list;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b
    public f0.a b() {
        return this.f19435c;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b
    public List<f0.e.d.a.b.AbstractC0214a> c() {
        return this.f19437e;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b
    public f0.e.d.a.b.c d() {
        return this.f19434b;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b
    public f0.e.d.a.b.AbstractC0218d e() {
        return this.f19436d;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof f0.e.d.a.b)) {
            return false;
        }
        f0.e.d.a.b bVar = (f0.e.d.a.b) obj;
        List<f0.e.d.a.b.AbstractC0220e> list = this.a;
        if (list != null ? list.equals(bVar.f()) : bVar.f() == null) {
            f0.e.d.a.b.c cVar = this.f19434b;
            if (cVar != null ? cVar.equals(bVar.d()) : bVar.d() == null) {
                f0.a aVar = this.f19435c;
                if (aVar != null ? aVar.equals(bVar.b()) : bVar.b() == null) {
                    if (this.f19436d.equals(bVar.e()) && this.f19437e.equals(bVar.c())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.a.b
    public List<f0.e.d.a.b.AbstractC0220e> f() {
        return this.a;
    }

    public int hashCode() {
        List<f0.e.d.a.b.AbstractC0220e> list = this.a;
        int iHashCode = ((list == null ? 0 : list.hashCode()) ^ 1000003) * 1000003;
        f0.e.d.a.b.c cVar = this.f19434b;
        int iHashCode2 = (iHashCode ^ (cVar == null ? 0 : cVar.hashCode())) * 1000003;
        f0.a aVar = this.f19435c;
        return ((((iHashCode2 ^ (aVar != null ? aVar.hashCode() : 0)) * 1000003) ^ this.f19436d.hashCode()) * 1000003) ^ this.f19437e.hashCode();
    }

    public String toString() {
        return "Execution{threads=" + this.a + ", exception=" + this.f19434b + ", appExitInfo=" + this.f19435c + ", signal=" + this.f19436d + ", binaries=" + this.f19437e + "}";
    }

    private n(List<f0.e.d.a.b.AbstractC0220e> list, f0.e.d.a.b.c cVar, f0.a aVar, f0.e.d.a.b.AbstractC0218d abstractC0218d, List<f0.e.d.a.b.AbstractC0214a> list2) {
        this.a = list;
        this.f19434b = cVar;
        this.f19435c = aVar;
        this.f19436d = abstractC0218d;
        this.f19437e = list2;
    }
}
