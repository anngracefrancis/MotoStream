package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import android.os.Bundle;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public abstract class zzacj<T> {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f13788b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final T f13789c;

    private zzacj(int i2, String str, T t) {
        this.a = i2;
        this.f13788b = str;
        this.f13789c = t;
        zzyt.d().b(this);
    }

    public static zzacj<Float> c(int i2, String str, float f2) {
        return new o(i2, str, Float.valueOf(f2));
    }

    public static zzacj<Integer> d(int i2, String str, int i3) {
        return new m(i2, str, Integer.valueOf(i3));
    }

    public static zzacj<Long> e(int i2, String str, long j2) {
        return new n(i2, str, Long.valueOf(j2));
    }

    public static zzacj<Boolean> f(int i2, String str, Boolean bool) {
        return new l(i2, str, bool);
    }

    public static zzacj<String> g(int i2, String str, String str2) {
        return new p(i2, str, str2);
    }

    public static zzacj<String> l(int i2, String str) {
        zzacj<String> zzacjVarG = g(i2, str, null);
        zzyt.d().c(zzacjVarG);
        return zzacjVarG;
    }

    public static zzacj<String> m(int i2, String str) {
        zzacj<String> zzacjVarG = g(i2, str, null);
        zzyt.d().d(zzacjVarG);
        return zzacjVarG;
    }

    public final String a() {
        return this.f13788b;
    }

    public final int b() {
        return this.a;
    }

    protected abstract T h(SharedPreferences sharedPreferences);

    public abstract T i(Bundle bundle);

    protected abstract T j(JSONObject jSONObject);

    public abstract void k(SharedPreferences.Editor editor, T t);

    public final T n() {
        return this.f13789c;
    }

    /* synthetic */ zzacj(int i2, String str, Object obj, l lVar) {
        this(i2, str, obj);
    }
}
