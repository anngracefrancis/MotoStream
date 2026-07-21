package com.google.firebase.crashlytics.internal;

import android.content.Context;
import com.google.firebase.crashlytics.internal.n.t;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: compiled from: DevelopmentPlatformProvider.java */
/* JADX INFO: loaded from: classes2.dex */
public class g {
    private final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private b f18999b = null;

    /* JADX INFO: compiled from: DevelopmentPlatformProvider.java */
    private class b {
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final String f19000b;

        private b() {
            int iP = t.p(g.this.a, "com.google.firebase.crashlytics.unity_version", "string");
            if (iP == 0) {
                if (!g.this.c("flutter_assets/NOTICES.Z")) {
                    this.a = null;
                    this.f19000b = null;
                    return;
                } else {
                    this.a = "Flutter";
                    this.f19000b = null;
                    h.f().i("Development platform is: Flutter");
                    return;
                }
            }
            this.a = "Unity";
            String string = g.this.a.getResources().getString(iP);
            this.f19000b = string;
            h.f().i("Unity Editor version is: " + string);
        }
    }

    public g(Context context) {
        this.a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(String str) {
        if (this.a.getAssets() == null) {
            return false;
        }
        try {
            InputStream inputStreamOpen = this.a.getAssets().open(str);
            if (inputStreamOpen != null) {
                inputStreamOpen.close();
            }
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    private b f() {
        if (this.f18999b == null) {
            this.f18999b = new b();
        }
        return this.f18999b;
    }

    public String d() {
        return f().a;
    }

    public String e() {
        return f().f19000b;
    }
}
