package com.bumptech.glide.load.n;

import android.net.Uri;
import android.text.TextUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.Map;

/* JADX INFO: compiled from: GlideUrl.java */
/* JADX INFO: loaded from: classes.dex */
public class g implements com.bumptech.glide.load.f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final h f9304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final URL f9305c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f9306d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f9307e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private URL f9308f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile byte[] f9309g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f9310h;

    public g(URL url) {
        this(url, h.f9311b);
    }

    private byte[] b() {
        if (this.f9309g == null) {
            this.f9309g = a().getBytes(com.bumptech.glide.load.f.a);
        }
        return this.f9309g;
    }

    private String d() {
        if (TextUtils.isEmpty(this.f9307e)) {
            String string = this.f9306d;
            if (TextUtils.isEmpty(string)) {
                string = ((URL) com.bumptech.glide.r.j.d(this.f9305c)).toString();
            }
            this.f9307e = Uri.encode(string, "@#&=*+-_.,:!?()/~'%;$");
        }
        return this.f9307e;
    }

    private URL e() throws MalformedURLException {
        if (this.f9308f == null) {
            this.f9308f = new URL(d());
        }
        return this.f9308f;
    }

    public String a() {
        String str = this.f9306d;
        return str != null ? str : ((URL) com.bumptech.glide.r.j.d(this.f9305c)).toString();
    }

    public Map<String, String> c() {
        return this.f9304b.a();
    }

    @Override // com.bumptech.glide.load.f
    public boolean equals(Object obj) {
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return a().equals(gVar.a()) && this.f9304b.equals(gVar.f9304b);
    }

    public URL f() throws MalformedURLException {
        return e();
    }

    @Override // com.bumptech.glide.load.f
    public int hashCode() {
        if (this.f9310h == 0) {
            int iHashCode = a().hashCode();
            this.f9310h = iHashCode;
            this.f9310h = (iHashCode * 31) + this.f9304b.hashCode();
        }
        return this.f9310h;
    }

    public String toString() {
        return a();
    }

    @Override // com.bumptech.glide.load.f
    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(b());
    }

    public g(String str) {
        this(str, h.f9311b);
    }

    public g(URL url, h hVar) {
        this.f9305c = (URL) com.bumptech.glide.r.j.d(url);
        this.f9306d = null;
        this.f9304b = (h) com.bumptech.glide.r.j.d(hVar);
    }

    public g(String str, h hVar) {
        this.f9305c = null;
        this.f9306d = com.bumptech.glide.r.j.b(str);
        this.f9304b = (h) com.bumptech.glide.r.j.d(hVar);
    }
}
