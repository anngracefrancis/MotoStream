package com.airbnb.lottie.s;

import com.airbnb.lottie.s.j.n;
import java.util.List;

/* JADX INFO: compiled from: FontCharacter.java */
/* JADX INFO: loaded from: classes.dex */
public class d {
    private final List<n> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char f8701b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final double f8702c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final double f8703d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f8704e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final String f8705f;

    public d(List<n> list, char c2, double d2, double d3, String str, String str2) {
        this.a = list;
        this.f8701b = c2;
        this.f8702c = d2;
        this.f8703d = d3;
        this.f8704e = str;
        this.f8705f = str2;
    }

    public static int c(char c2, String str, String str2) {
        return ((((0 + c2) * 31) + str.hashCode()) * 31) + str2.hashCode();
    }

    public List<n> a() {
        return this.a;
    }

    public double b() {
        return this.f8703d;
    }

    public int hashCode() {
        return c(this.f8701b, this.f8705f, this.f8704e);
    }
}
