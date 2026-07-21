package com.flurry.sdk;

import android.content.Context;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class h2 {
    private static boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f10808b;

    public static synchronized void a() {
        if (a) {
            return;
        }
        try {
            g1.c(Class.forName("com.flurry.android.bridge.FlurryBridgeModule"));
        } catch (ClassNotFoundException | NoClassDefFoundError unused) {
            d1.c(3, "FlurrySDK", "Ads module not available");
        }
        a = true;
    }

    public static synchronized void b(Context context) {
        g1.d(context);
    }

    public static synchronized void c(List<e.d.a.e> list) {
        if (f10808b) {
            return;
        }
        if (list != null) {
            Iterator<e.d.a.e> it = list.iterator();
            while (it.hasNext()) {
                g1.b((h1) it.next());
            }
        }
        f10808b = true;
    }
}
