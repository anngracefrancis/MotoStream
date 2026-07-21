package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzuo {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f16807b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f16808c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f16809d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzvb f16810e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzvk f16811f;
    private int n;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final Object f16812g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private ArrayList<String> f16813h = new ArrayList<>();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ArrayList<String> f16814i = new ArrayList<>();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ArrayList<zzuz> f16815j = new ArrayList<>();

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f16816k = 0;
    private int l = 0;
    private int m = 0;
    private String o = HttpUrl.FRAGMENT_ENCODE_SET;
    private String p = HttpUrl.FRAGMENT_ENCODE_SET;
    private String q = HttpUrl.FRAGMENT_ENCODE_SET;

    public zzuo(int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        this.a = i2;
        this.f16807b = i3;
        this.f16808c = i4;
        this.f16809d = z;
        this.f16810e = new zzvb(i5);
        this.f16811f = new zzvk(i6, i7, i8);
    }

    private static String b(ArrayList<String> arrayList, int i2) {
        if (arrayList.isEmpty()) {
            return HttpUrl.FRAGMENT_ENCODE_SET;
        }
        StringBuilder sb = new StringBuilder();
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            String str = arrayList.get(i3);
            i3++;
            sb.append(str);
            sb.append(' ');
            if (sb.length() > 100) {
                break;
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        String string = sb.toString();
        return string.length() < 100 ? string : string.substring(0, 100);
    }

    private final void f(String str, boolean z, float f2, float f3, float f4, float f5) {
        if (str == null || str.length() < this.f16808c) {
            return;
        }
        synchronized (this.f16812g) {
            this.f16813h.add(str);
            this.f16816k += str.length();
            if (z) {
                this.f16814i.add(str);
                this.f16815j.add(new zzuz(f2, f3, f4, f5, this.f16814i.size() - 1));
            }
        }
    }

    @VisibleForTesting
    private final int g(int i2, int i3) {
        return this.f16809d ? this.f16807b : (i2 * this.a) + (i3 * this.f16807b);
    }

    public final int a() {
        return this.n;
    }

    public final void c(String str, boolean z, float f2, float f3, float f4, float f5) {
        f(str, z, f2, f3, f4, f5);
        synchronized (this.f16812g) {
            if (this.m < 0) {
                zzbad.e("ActivityContent: negative number of WebViews.");
            }
            p();
        }
    }

    public final void d(String str, boolean z, float f2, float f3, float f4, float f5) {
        f(str, z, f2, f3, f4, f5);
    }

    public final void e(int i2) {
        this.l = i2;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzuo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        String str = ((zzuo) obj).o;
        return str != null && str.equals(this.o);
    }

    public final boolean h() {
        boolean z;
        synchronized (this.f16812g) {
            z = this.m == 0;
        }
        return z;
    }

    public final int hashCode() {
        return this.o.hashCode();
    }

    public final String i() {
        return this.o;
    }

    public final String j() {
        return this.p;
    }

    public final String k() {
        return this.q;
    }

    public final void l() {
        synchronized (this.f16812g) {
            this.n -= 100;
        }
    }

    public final void m() {
        synchronized (this.f16812g) {
            this.m--;
        }
    }

    public final void n() {
        synchronized (this.f16812g) {
            this.m++;
        }
    }

    public final void o() {
        synchronized (this.f16812g) {
            int iG = g(this.f16816k, this.l);
            if (iG > this.n) {
                this.n = iG;
            }
        }
    }

    public final void p() {
        synchronized (this.f16812g) {
            int iG = g(this.f16816k, this.l);
            if (iG > this.n) {
                this.n = iG;
                if (!zzk.zzlk().r().k()) {
                    this.o = this.f16810e.a(this.f16813h);
                    this.p = this.f16810e.a(this.f16814i);
                }
                if (!zzk.zzlk().r().b()) {
                    this.q = this.f16811f.a(this.f16814i, this.f16815j);
                }
            }
        }
    }

    @VisibleForTesting
    final int q() {
        return this.f16816k;
    }

    public final String toString() {
        int i2 = this.l;
        int i3 = this.n;
        int i4 = this.f16816k;
        String strB = b(this.f16813h, 100);
        String strB2 = b(this.f16814i, 100);
        String str = this.o;
        String str2 = this.p;
        String str3 = this.q;
        StringBuilder sb = new StringBuilder(String.valueOf(strB).length() + 165 + String.valueOf(strB2).length() + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb.append("ActivityContent fetchId: ");
        sb.append(i2);
        sb.append(" score:");
        sb.append(i3);
        sb.append(" total_length:");
        sb.append(i4);
        sb.append("\n text: ");
        sb.append(strB);
        sb.append("\n viewableText");
        sb.append(strB2);
        sb.append("\n signture: ");
        sb.append(str);
        sb.append("\n viewableSignture: ");
        sb.append(str2);
        sb.append("\n viewableSignatureForVertical: ");
        sb.append(str3);
        return sb.toString();
    }
}
