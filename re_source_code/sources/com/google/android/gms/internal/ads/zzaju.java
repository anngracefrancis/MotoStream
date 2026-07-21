package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public class zzaju<ReferenceT> implements zzajt {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, CopyOnWriteArrayList<zzaho<? super ReferenceT>>> f13925f = new HashMap();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ReferenceT f13926g;

    private final synchronized void g0(String str, final Map<String, String> map) {
        if (zzbad.a(2)) {
            String strValueOf = String.valueOf(str);
            zzawz.m(strValueOf.length() != 0 ? "Received GMSG: ".concat(strValueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzawz.m(sb.toString());
            }
        }
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f13925f.get(str);
        if (copyOnWriteArrayList != null) {
            for (final zzaho<? super ReferenceT> zzahoVar : copyOnWriteArrayList) {
                zzbbm.a.execute(new Runnable(this, zzahoVar, map) { // from class: com.google.android.gms.internal.ads.a1

                    /* JADX INFO: renamed from: f, reason: collision with root package name */
                    private final zzaju f12208f;

                    /* JADX INFO: renamed from: g, reason: collision with root package name */
                    private final zzaho f12209g;

                    /* JADX INFO: renamed from: h, reason: collision with root package name */
                    private final Map f12210h;

                    {
                        this.f12208f = this;
                        this.f12209g = zzahoVar;
                        this.f12210h = map;
                    }

                    @Override // java.lang.Runnable
                    public final void run() {
                        this.f12208f.L(this.f12209g, this.f12210h);
                    }
                });
            }
        }
    }

    public final synchronized void B() {
        this.f13925f.clear();
    }

    final /* synthetic */ void L(zzaho zzahoVar, Map map) {
        zzahoVar.a(this.f13926g, map);
    }

    public final synchronized void f(String str, zzaho<? super ReferenceT> zzahoVar) {
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f13925f.get(str);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f13925f.put(str, copyOnWriteArrayList);
        }
        copyOnWriteArrayList.add(zzahoVar);
    }

    public final synchronized void i(String str, zzaho<? super ReferenceT> zzahoVar) {
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f13925f.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        copyOnWriteArrayList.remove(zzahoVar);
    }

    public final void r0(ReferenceT referencet) {
        this.f13926g = referencet;
    }

    public final synchronized void t(String str, Predicate<zzaho<? super ReferenceT>> predicate) {
        CopyOnWriteArrayList<zzaho<? super ReferenceT>> copyOnWriteArrayList = this.f13925f.get(str);
        if (copyOnWriteArrayList == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (zzaho<? super ReferenceT> zzahoVar : copyOnWriteArrayList) {
            if (predicate.a(zzahoVar)) {
                arrayList.add(zzahoVar);
            }
        }
        copyOnWriteArrayList.removeAll(arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzajt
    public final boolean u(String str) {
        return str != null && w0(Uri.parse(str));
    }

    public final boolean w0(Uri uri) {
        if (!"gmsg".equalsIgnoreCase(uri.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            return false;
        }
        y0(uri);
        return true;
    }

    public final void y0(Uri uri) {
        String path = uri.getPath();
        zzk.zzlg();
        g0(path, zzaxi.X(uri));
    }
}
