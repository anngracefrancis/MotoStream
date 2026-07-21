package com.google.firebase.u;

import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: LibraryVersion.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
abstract class g {
    g() {
    }

    static g a(String str, String str2) {
        return new c(str, str2);
    }

    public abstract String b();

    public abstract String c();
}
