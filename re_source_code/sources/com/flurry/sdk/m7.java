package com.flurry.sdk;

import java.text.SimpleDateFormat;
import java.util.Locale;

/* JADX INFO: loaded from: classes2.dex */
public final class m7 {
    private static SimpleDateFormat a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.US);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f10923b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f10924c;

    public m7(String str, long j2) {
        this.f10923b = str;
        this.f10924c = j2;
    }

    public final String toString() {
        return a.format(Long.valueOf(this.f10924c)) + ": " + this.f10923b + "\n";
    }
}
