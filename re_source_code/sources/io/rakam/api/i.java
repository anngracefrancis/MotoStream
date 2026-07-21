package io.rakam.api;

import java.util.HashSet;
import java.util.Set;

/* JADX INFO: compiled from: TrackingOptions.java */
/* JADX INFO: loaded from: classes2.dex */
public class i {
    private static String[] a = {"city", "country", "dma", "ip_address", "lat_lng", "region"};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Set<String> f21986b = new HashSet();

    private boolean g(String str) {
        return !this.f21986b.contains(str);
    }

    boolean a() {
        return g("adid");
    }

    boolean b() {
        return g("carrier");
    }

    boolean c() {
        return g("country");
    }

    boolean d() {
        return g("device_brand");
    }

    boolean e() {
        return g("device_manufacturer");
    }

    boolean f() {
        return g("device_model");
    }

    boolean h() {
        return g("language");
    }

    boolean i() {
        return g("lat_lng");
    }

    boolean j() {
        return g("os_name");
    }

    boolean k() {
        return g("os_version");
    }

    boolean l() {
        return g("platform");
    }

    boolean m() {
        return g("version_name");
    }
}
