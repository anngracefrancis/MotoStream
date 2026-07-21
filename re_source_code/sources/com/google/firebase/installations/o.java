package com.google.firebase.installations;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: Utils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o {
    public static final long a = TimeUnit.HOURS.toSeconds(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f19695b = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static o f19696c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final com.google.firebase.installations.s.a f19697d;

    private o(com.google.firebase.installations.s.a aVar) {
        this.f19697d = aVar;
    }

    public static o c() {
        return d(com.google.firebase.installations.s.b.b());
    }

    public static o d(com.google.firebase.installations.s.a aVar) {
        if (f19696c == null) {
            f19696c = new o(aVar);
        }
        return f19696c;
    }

    static boolean g(String str) {
        return f19695b.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f19697d.a();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(com.google.firebase.installations.q.d dVar) {
        return TextUtils.isEmpty(dVar.b()) || dVar.h() + dVar.c() < b() + a;
    }
}
