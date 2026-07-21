package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class v {
    public final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final a f11078b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f11079c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f11080d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f11081e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f11082f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f11083g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final String f11084h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f11085i;

    public enum a {
        NONE_OR_UNKNOWN(0),
        NETWORK_AVAILABLE(1),
        WIFI(2),
        CELL(3);


        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public int f11091k;

        a(int i2) {
            this.f11091k = i2;
        }
    }

    v(a aVar, boolean z, String str, String str2, String str3, String str4, String str5, String str6, int i2) {
        this.a = z;
        this.f11078b = aVar;
        this.f11079c = str;
        this.f11080d = str2;
        this.f11081e = str3;
        this.f11082f = str4;
        this.f11083g = str5;
        this.f11084h = str6;
        this.f11085i = i2;
    }
}
