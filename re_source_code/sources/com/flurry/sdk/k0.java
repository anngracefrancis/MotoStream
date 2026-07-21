package com.flurry.sdk;

import android.text.TextUtils;

/* JADX INFO: loaded from: classes2.dex */
public final class k0 {
    private static k0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10859b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f10860c;

    private k0() {
    }

    public static k0 a() {
        if (a == null) {
            a = new k0();
        }
        return a;
    }

    private static boolean d() {
        return f1.a() == 0;
    }

    public final String b() {
        if (TextUtils.isEmpty(this.f10859b)) {
            c();
        }
        d1.c(3, "APIKeyProvider", "Getting streaming apikey: " + this.f10859b);
        return this.f10859b;
    }

    public final void c() {
        if (TextUtils.isEmpty(this.f10859b)) {
            this.f10859b = this.f10860c;
            if (!d()) {
                this.f10859b += "0";
            }
            d1.c(3, "APIKeyProvider", "Generating a streaming apikey: " + this.f10859b);
        }
    }
}
