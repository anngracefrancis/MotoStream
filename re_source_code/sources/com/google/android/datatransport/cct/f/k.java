package com.google.android.datatransport.cct.f;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: ClientInfo.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class k {

    /* JADX INFO: compiled from: ClientInfo.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract k a();

        public abstract a b(com.google.android.datatransport.cct.f.a aVar);

        public abstract a c(b bVar);
    }

    /* JADX INFO: compiled from: ClientInfo.java */
    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final int f11282i;

        b(int i2) {
            this.f11282i = i2;
        }
    }

    public static a a() {
        return new e.b();
    }

    public abstract com.google.android.datatransport.cct.f.a b();

    public abstract b c();
}
