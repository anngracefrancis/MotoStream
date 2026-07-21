package com.flurry.sdk;

import android.content.Context;
import java.io.File;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class v0 {
    private final w0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f11092b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f11093c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f11094d;

    public v0() {
        this(b0.a());
    }

    private void b(String str) {
        if (str == null) {
            return;
        }
        this.f11094d = str;
    }

    public final synchronized Map<String, List<String>> a() {
        if (!this.f11093c) {
            this.f11093c = true;
            d1.c(4, "InstallLogger", "Loading referrer info from file: " + this.f11092b.getAbsolutePath());
            String strF = b2.f(this.f11092b);
            d1.e("InstallLogger", "Referrer file contents: ".concat(String.valueOf(strF)));
            b(strF);
        }
        return w0.a(this.f11094d);
    }

    public v0(Context context) {
        this.a = new w0();
        File fileStreamPath = context.getFileStreamPath(".flurryinstallreceiver.");
        this.f11092b = fileStreamPath;
        d1.c(3, "InstallLogger", "Referrer file name if it exists:  " + fileStreamPath);
    }
}
