package com.google.firebase.crashlytics.internal.n;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.p.f0;
import java.io.File;

/* JADX INFO: compiled from: CrashlyticsReportWithSessionId.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class b0 {
    public static b0 a(f0 f0Var, String str, File file) {
        return new m(f0Var, str, file);
    }

    public abstract f0 b();

    public abstract File c();

    public abstract String d();
}
