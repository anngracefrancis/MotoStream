package com.flurry.sdk;

import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final class y0 extends c1<k1> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static y0 f11148e;

    protected y0() {
        super("HttpRequestManager", TimeUnit.MILLISECONDS, new PriorityBlockingQueue(11, new a1()));
    }

    public static synchronized y0 f() {
        if (f11148e == null) {
            f11148e = new y0();
        }
        return f11148e;
    }
}
