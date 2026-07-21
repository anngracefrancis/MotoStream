package com.google.firebase.installations;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: InstallationTokenResult.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class l {

    /* JADX INFO: compiled from: InstallationTokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract l a();

        public abstract a b(String str);

        public abstract a c(long j2);

        public abstract a d(long j2);
    }

    public static a a() {
        return new f.b();
    }

    public abstract String b();

    public abstract long c();

    public abstract long d();
}
