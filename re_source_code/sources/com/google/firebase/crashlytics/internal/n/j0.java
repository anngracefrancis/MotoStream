package com.google.firebase.crashlytics.internal.n;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: InstallIdProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public interface j0 {

    /* JADX INFO: compiled from: InstallIdProvider.java */
    @AutoValue
    public static abstract class a {
        static a a(String str, String str2) {
            return new n(str, str2);
        }

        public static a b(String str) {
            return a(str, null);
        }

        public abstract String c();

        public abstract String d();
    }

    a a();
}
