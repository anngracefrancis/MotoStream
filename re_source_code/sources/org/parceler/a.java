package org.parceler;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: IdentityCollection.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<Object> f25974b = new ArrayList();

    public a() {
        e(null);
    }

    public boolean a(int i2) {
        return i2 < this.f25974b.size();
    }

    public <T> T b(int i2) {
        return (T) this.f25974b.get(i2);
    }

    public int c(Object obj) {
        for (int i2 = 0; i2 < this.f25974b.size(); i2++) {
            if (this.f25974b.get(i2) == obj) {
                return i2;
            }
        }
        return -1;
    }

    public boolean d(int i2) {
        return this.f25974b.get(i2) == a;
    }

    public int e(Object obj) {
        this.f25974b.add(obj);
        return this.f25974b.size() - 1;
    }

    public void f(int i2, Object obj) {
        if (this.f25974b.size() > i2) {
            this.f25974b.remove(i2);
        }
        this.f25974b.add(i2, obj);
    }

    public int g() {
        return e(a);
    }
}
