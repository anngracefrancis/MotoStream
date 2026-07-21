package com.google.firebase.crashlytics.internal.p;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.g;

/* JADX INFO: compiled from: StaticSessionData.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class g0 {

    /* JADX INFO: compiled from: StaticSessionData.java */
    @AutoValue
    public static abstract class a {
        public static a b(String str, String str2, String str3, String str4, int i2, g gVar) {
            return new c0(str, str2, str3, str4, i2, gVar);
        }

        public abstract String a();

        public abstract int c();

        public abstract g d();

        public abstract String e();

        public abstract String f();

        public abstract String g();
    }

    /* JADX INFO: compiled from: StaticSessionData.java */
    @AutoValue
    public static abstract class b {
        public static b c(int i2, String str, int i3, long j2, long j3, boolean z, int i4, String str2, String str3) {
            return new d0(i2, str, i3, j2, j3, z, i4, str2, str3);
        }

        public abstract int a();

        public abstract int b();

        public abstract long d();

        public abstract boolean e();

        public abstract String f();

        public abstract String g();

        public abstract String h();

        public abstract int i();

        public abstract long j();
    }

    /* JADX INFO: compiled from: StaticSessionData.java */
    @AutoValue
    public static abstract class c {
        public static c a(String str, String str2, boolean z) {
            return new e0(str, str2, z);
        }

        public abstract boolean b();

        public abstract String c();

        public abstract String d();
    }

    public static g0 b(a aVar, c cVar, b bVar) {
        return new b0(aVar, cVar, bVar);
    }

    public abstract a a();

    public abstract b c();

    public abstract c d();
}
