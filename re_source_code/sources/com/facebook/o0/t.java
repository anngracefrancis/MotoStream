package com.facebook.o0;

import com.facebook.AccessToken;
import com.facebook.internal.p0;
import java.io.ObjectStreamException;
import java.io.Serializable;

/* JADX INFO: compiled from: AccessTokenAppIdPair.kt */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Serializable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f10492f = new a(null);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f10493g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final String f10494h;

    /* JADX INFO: compiled from: AccessTokenAppIdPair.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AccessTokenAppIdPair.kt */
    public static final class b implements Serializable {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f10495f = new a(null);

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final String f10496g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final String f10497h;

        /* JADX INFO: compiled from: AccessTokenAppIdPair.kt */
        public static final class a {
            private a() {
            }

            public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
                this();
            }
        }

        public b(String str, String str2) {
            kotlin.jvm.internal.m.f(str2, "appId");
            this.f10496g = str;
            this.f10497h = str2;
        }

        private final Object readResolve() throws ObjectStreamException {
            return new t(this.f10496g, this.f10497h);
        }
    }

    public t(String str, String str2) {
        kotlin.jvm.internal.m.f(str2, "applicationId");
        this.f10493g = str2;
        p0 p0Var = p0.a;
        this.f10494h = p0.a0(str) ? null : str;
    }

    private final Object writeReplace() throws ObjectStreamException {
        return new b(this.f10494h, this.f10493g);
    }

    public final String a() {
        return this.f10494h;
    }

    public final String b() {
        return this.f10493g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof t)) {
            return false;
        }
        p0 p0Var = p0.a;
        t tVar = (t) obj;
        return p0.c(tVar.f10494h, this.f10494h) && p0.c(tVar.f10493g, this.f10493g);
    }

    public int hashCode() {
        String str = this.f10494h;
        return (str == null ? 0 : str.hashCode()) ^ this.f10493g.hashCode();
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public t(AccessToken accessToken) {
        kotlin.jvm.internal.m.f(accessToken, "accessToken");
        String strL = accessToken.l();
        com.facebook.a0 a0Var = com.facebook.a0.a;
        this(strL, com.facebook.a0.d());
    }
}
