package com.google.android.gms.internal.ads;

import java.util.Random;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzyt {
    private static zzyt a = new zzyt();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzazt f17002b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzyh f17003c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f17004d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzacp f17005e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzacq f17006f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzacr f17007g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbai f17008h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final Random f17009i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final WeakHashMap<Object, String> f17010j;

    protected zzyt() {
        this(new zzazt(), new zzyh(new zzxx(), new zzxw(), new zzabk(), new zzagk(), new zzatf(), new zzauj(), new zzaqf(), new zzagl()), new zzacp(), new zzacq(), new zzacr(), zzazt.x(), new zzbai(0, 15000000, true), new Random(), new WeakHashMap());
    }

    public static zzazt a() {
        return a.f17002b;
    }

    public static zzyh b() {
        return a.f17003c;
    }

    public static zzacq c() {
        return a.f17006f;
    }

    public static zzacp d() {
        return a.f17005e;
    }

    public static zzacr e() {
        return a.f17007g;
    }

    public static String f() {
        return a.f17004d;
    }

    public static zzbai g() {
        return a.f17008h;
    }

    public static Random h() {
        return a.f17009i;
    }

    private zzyt(zzazt zzaztVar, zzyh zzyhVar, zzacp zzacpVar, zzacq zzacqVar, zzacr zzacrVar, String str, zzbai zzbaiVar, Random random, WeakHashMap<Object, String> weakHashMap) {
        this.f17002b = zzaztVar;
        this.f17003c = zzyhVar;
        this.f17005e = zzacpVar;
        this.f17006f = zzacqVar;
        this.f17007g = zzacrVar;
        this.f17004d = str;
        this.f17008h = zzbaiVar;
        this.f17009i = random;
        this.f17010j = weakHashMap;
    }
}
