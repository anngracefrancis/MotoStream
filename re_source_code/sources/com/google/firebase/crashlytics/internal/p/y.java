package com.google.firebase.crashlytics.internal.p;

import java.util.List;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutsState.java */
/* JADX INFO: loaded from: classes2.dex */
final class y extends f0.e.d.f {
    private final List<f0.e.d.AbstractC0226e> a;

    /* JADX INFO: compiled from: AutoValue_CrashlyticsReport_Session_Event_RolloutsState.java */
    static final class b extends f0.e.d.f.a {
        private List<f0.e.d.AbstractC0226e> a;

        b() {
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.f.a
        public f0.e.d.f a() {
            List<f0.e.d.AbstractC0226e> list = this.a;
            String str = HttpUrl.FRAGMENT_ENCODE_SET;
            if (list == null) {
                str = HttpUrl.FRAGMENT_ENCODE_SET + " rolloutAssignments";
            }
            if (str.isEmpty()) {
                return new y(this.a);
            }
            throw new IllegalStateException("Missing required properties:" + str);
        }

        @Override // com.google.firebase.crashlytics.h.p.f0.e.d.f.a
        public f0.e.d.f.a b(List<f0.e.d.AbstractC0226e> list) {
            if (list == null) {
                throw new NullPointerException("Null rolloutAssignments");
            }
            this.a = list;
            return this;
        }
    }

    @Override // com.google.firebase.crashlytics.h.p.f0.e.d.f
    public List<f0.e.d.AbstractC0226e> b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof f0.e.d.f) {
            return this.a.equals(((f0.e.d.f) obj).b());
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode() ^ 1000003;
    }

    public String toString() {
        return "RolloutsState{rolloutAssignments=" + this.a + "}";
    }

    private y(List<f0.e.d.AbstractC0226e> list) {
        this.a = list;
    }
}
