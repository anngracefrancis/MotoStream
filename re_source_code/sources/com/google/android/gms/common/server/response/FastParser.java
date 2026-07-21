package com.google.android.gms.common.server.response;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Stack;

/* JADX INFO: loaded from: classes2.dex */
@ShowFirstParty
@KeepForSdk
public class FastParser<T extends FastJsonResponse> {
    private static final char[] a = {'u', 'l', 'l'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f12113b = {'r', 'u', 'e'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f12114c = {'r', 'u', 'e', '\"'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char[] f12115d = {'a', 'l', 's', 'e'};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final char[] f12116e = {'a', 'l', 's', 'e', '\"'};

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final char[] f12117f = {'\n'};

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final a<Integer> f12118g = new com.google.android.gms.common.server.response.a();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final a<Long> f12119h = new b();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a<Float> f12120i = new c();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final a<Double> f12121j = new d();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final a<Boolean> f12122k = new e();
    private static final a<String> l = new f();
    private static final a<BigInteger> m = new g();
    private static final a<BigDecimal> n = new h();
    private final char[] o = new char[1];
    private final char[] p = new char[32];
    private final char[] q = new char[1024];
    private final StringBuilder r = new StringBuilder(32);
    private final StringBuilder s = new StringBuilder(1024);
    private final Stack<Integer> t = new Stack<>();

    @ShowFirstParty
    @KeepForSdk
    public static class ParseException extends Exception {
    }

    /* JADX INFO: Access modifiers changed from: private */
    interface a<O> {
    }
}
