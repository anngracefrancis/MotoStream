package com.google.firebase.crashlytics.internal.n;

import com.google.firebase.crashlytics.internal.h;
import com.google.firebase.crashlytics.internal.r.f;
import java.io.File;
import java.io.IOException;

/* JADX INFO: compiled from: CrashlyticsFileMarker.java */
/* JADX INFO: loaded from: classes2.dex */
class z {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final f f19139b;

    public z(String str, f fVar) {
        this.a = str;
        this.f19139b = fVar;
    }

    private File b() {
        return this.f19139b.e(this.a);
    }

    public boolean a() {
        try {
            return b().createNewFile();
        } catch (IOException e2) {
            h.f().e("Error creating marker: " + this.a, e2);
            return false;
        }
    }

    public boolean c() {
        return b().exists();
    }

    public boolean d() {
        return b().delete();
    }
}
