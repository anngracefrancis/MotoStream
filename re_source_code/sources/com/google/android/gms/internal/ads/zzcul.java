package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.HttpUrl;
import org.json.JSONArray;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcul implements zzcva<zzcuk> {
    private final zzbbl a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScheduledExecutorService f15636b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<zzcpk> f15637c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f15638d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzcxv f15639e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f15640f;

    public zzcul(zzbbl zzbblVar, ScheduledExecutorService scheduledExecutorService, String str, zzcpf zzcpfVar, Context context, zzcxv zzcxvVar) {
        this.a = zzbblVar;
        this.f15636b = scheduledExecutorService;
        this.f15640f = str;
        this.f15638d = context;
        this.f15639e = zzcxvVar;
        if (zzcpfVar.b().containsKey(zzcxvVar.f15752f)) {
            this.f15637c = zzcpfVar.b().get(zzcxvVar.f15752f);
        } else {
            this.f15637c = Collections.emptyList();
        }
    }

    static final /* synthetic */ zzcuk d(List list) throws Exception {
        JSONArray jSONArray = new JSONArray();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            try {
                jSONArray.put(((zzbbh) it.next()).get());
            } catch (InterruptedException | ExecutionException unused) {
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzcuk(jSONArray.toString());
    }

    final /* synthetic */ void a(zzcpk zzcpkVar, Bundle bundle, zzcpl zzcplVar, zzbbr zzbbrVar) {
        try {
            zzcpkVar.f15497d.u3(ObjectWrapper.E0(this.f15638d), this.f15640f, bundle, zzcpkVar.f15496c, this.f15639e.f15751e, zzcplVar);
        } catch (Exception e2) {
            zzbbrVar.c(new Exception("Error calling adapter"));
            zzbad.c(HttpUrl.FRAGMENT_ENCODE_SET, e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcva
    public final zzbbh<zzcuk> b() {
        return ((Boolean) zzyt.e().c(zzacu.a2)).booleanValue() ? zzbar.c(this.a.submit(new Callable(this) { // from class: com.google.android.gms.internal.ads.to

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzcul f13357f;

            {
                this.f13357f = this;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f13357f.c();
            }
        }), new zzbal(this) { // from class: com.google.android.gms.internal.ads.uo
            private final zzcul a;

            {
                this.a = this;
            }

            @Override // com.google.android.gms.internal.ads.zzbal
            public final zzbbh zzf(Object obj) {
                return this.a.e((List) obj);
            }
        }, this.a) : zzbar.o(null);
    }

    final /* synthetic */ List c() throws Exception {
        ArrayList arrayList = new ArrayList();
        for (final zzcpk zzcpkVar : this.f15637c) {
            final zzbbr zzbbrVar = new zzbbr();
            final zzcpl zzcplVar = new zzcpl(zzcpkVar, zzbbrVar);
            Bundle bundle = this.f15639e.f15750d.r;
            final Bundle bundle2 = bundle != null ? bundle.getBundle(zzcpkVar.a) : null;
            arrayList.add(zzbar.b(zzbbrVar, ((Long) zzyt.e().c(zzacu.Z1)).longValue(), TimeUnit.MILLISECONDS, this.f15636b));
            this.a.execute(new Runnable(this, zzcpkVar, bundle2, zzcplVar, zzbbrVar) { // from class: com.google.android.gms.internal.ads.vo

                /* JADX INFO: renamed from: f, reason: collision with root package name */
                private final zzcul f13461f;

                /* JADX INFO: renamed from: g, reason: collision with root package name */
                private final zzcpk f13462g;

                /* JADX INFO: renamed from: h, reason: collision with root package name */
                private final Bundle f13463h;

                /* JADX INFO: renamed from: i, reason: collision with root package name */
                private final zzcpl f13464i;

                /* JADX INFO: renamed from: j, reason: collision with root package name */
                private final zzbbr f13465j;

                {
                    this.f13461f = this;
                    this.f13462g = zzcpkVar;
                    this.f13463h = bundle2;
                    this.f13464i = zzcplVar;
                    this.f13465j = zzbbrVar;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    this.f13461f.a(this.f13462g, this.f13463h, this.f13464i, this.f13465j);
                }
            });
        }
        return arrayList;
    }

    final /* synthetic */ zzbbh e(final List list) throws Exception {
        return zzbar.n(list).a(new Callable(list) { // from class: com.google.android.gms.internal.ads.wo

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final List f13517f;

            {
                this.f13517f = list;
            }

            @Override // java.util.concurrent.Callable
            public final Object call() {
                return zzcul.d(this.f13517f);
            }
        }, this.a);
    }
}
