package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class m2 {
    static m2 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public t2 f10913b = new t2();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public z6 f10914c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v6 f10915d;

    private m2() {
        int iA = f1.a();
        this.f10915d = (iA == 0 || iA == 2) ? f1.c() ? new k2() : new j2() : null;
        this.f10914c = new z6(this.f10915d);
    }

    public static synchronized m2 a() {
        if (a == null) {
            a = new m2();
        }
        return a;
    }

    public final void b(u6 u6Var) {
        if (u6Var != null) {
            this.f10913b.a(u6Var);
        } else {
            d1.c(5, "StreamingManager", "sendFrameToStreaming failed -- message is null");
        }
    }
}
