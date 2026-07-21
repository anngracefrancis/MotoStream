package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class h {
    final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f17784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f17785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f17786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f17787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f17788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f17789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Long f17790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Long f17791i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final Long f17792j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Boolean f17793k;

    h(String str, String str2, long j2, long j3, long j4, long j5, long j6, Long l, Long l2, Long l3, Boolean bool) {
        Preconditions.g(str);
        Preconditions.g(str2);
        Preconditions.a(j2 >= 0);
        Preconditions.a(j3 >= 0);
        Preconditions.a(j4 >= 0);
        Preconditions.a(j6 >= 0);
        this.a = str;
        this.f17784b = str2;
        this.f17785c = j2;
        this.f17786d = j3;
        this.f17787e = j4;
        this.f17788f = j5;
        this.f17789g = j6;
        this.f17790h = l;
        this.f17791i = l2;
        this.f17792j = l3;
        this.f17793k = bool;
    }

    final h a(long j2) {
        return new h(this.a, this.f17784b, this.f17785c, this.f17786d, this.f17787e, j2, this.f17789g, this.f17790h, this.f17791i, this.f17792j, this.f17793k);
    }

    final h b(long j2, long j3) {
        return new h(this.a, this.f17784b, this.f17785c, this.f17786d, this.f17787e, this.f17788f, j2, Long.valueOf(j3), this.f17791i, this.f17792j, this.f17793k);
    }

    final h c(Long l, Long l2, Boolean bool) {
        return new h(this.a, this.f17784b, this.f17785c, this.f17786d, this.f17787e, this.f17788f, this.f17789g, this.f17790h, l, l2, (bool == null || bool.booleanValue()) ? bool : null);
    }

    h(String str, String str2, long j2, long j3, long j4, long j5, Long l, Long l2, Long l3, Boolean bool) {
        this(str, str2, j2, j3, 0L, j4, 0L, null, null, null, null);
    }
}
