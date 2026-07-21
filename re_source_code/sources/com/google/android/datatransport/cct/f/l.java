package com.google.android.datatransport.cct.f;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: LogEvent.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class l {

    /* JADX INFO: compiled from: LogEvent.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract l a();

        public abstract a b(Integer num);

        public abstract a c(long j2);

        public abstract a d(long j2);

        public abstract a e(o oVar);

        abstract a f(byte[] bArr);

        abstract a g(String str);

        public abstract a h(long j2);
    }

    private static a a() {
        return new f.b();
    }

    public static a i(String str) {
        return a().g(str);
    }

    public static a j(byte[] bArr) {
        return a().f(bArr);
    }

    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    public abstract o e();

    public abstract byte[] f();

    public abstract String g();

    public abstract long h();
}
