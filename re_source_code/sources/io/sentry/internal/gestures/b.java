package io.sentry.internal.gestures;

import io.sentry.util.q;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: UiElement.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    final WeakReference<Object> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final String f22439b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final String f22440c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final String f22441d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final String f22442e;

    /* JADX INFO: compiled from: UiElement.java */
    public enum a {
        CLICKABLE,
        SCROLLABLE
    }

    public b(Object obj, String str, String str2, String str3, String str4) {
        this.a = new WeakReference<>(obj);
        this.f22439b = str;
        this.f22440c = str2;
        this.f22441d = str3;
        this.f22442e = str4;
    }

    public String a() {
        return this.f22439b;
    }

    public String b() {
        String str = this.f22440c;
        return str != null ? str : (String) q.c(this.f22441d, "UiElement.tag can't be null");
    }

    public String c() {
        return this.f22442e;
    }

    public String d() {
        return this.f22440c;
    }

    public String e() {
        return this.f22441d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || b.class != obj.getClass()) {
            return false;
        }
        b bVar = (b) obj;
        return q.a(this.f22439b, bVar.f22439b) && q.a(this.f22440c, bVar.f22440c) && q.a(this.f22441d, bVar.f22441d);
    }

    public Object f() {
        return this.a.get();
    }

    public int hashCode() {
        return q.b(this.a, this.f22440c, this.f22441d);
    }
}
