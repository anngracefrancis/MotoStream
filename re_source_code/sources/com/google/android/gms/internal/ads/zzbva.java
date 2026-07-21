package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbva extends zzbts<zzue> implements zzue {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Map<View, zzua> f14745g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f14746h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzcxm f14747i;

    public zzbva(Context context, Set<zzbuz<zzue>> set, zzcxm zzcxmVar) {
        super(set);
        this.f14745g = new WeakHashMap(1);
        this.f14746h = context;
        this.f14747i = zzcxmVar;
    }

    public final synchronized void Y(View view) {
        zzua zzuaVar = this.f14745g.get(view);
        if (zzuaVar == null) {
            zzuaVar = new zzua(this.f14746h, view);
            zzuaVar.d(this);
            this.f14745g.put(view, zzuaVar);
        }
        zzcxm zzcxmVar = this.f14747i;
        if (zzcxmVar != null && zzcxmVar.N) {
            if (((Boolean) zzyt.e().c(zzacu.R1)).booleanValue()) {
                zzuaVar.j(((Long) zzyt.e().c(zzacu.Q1)).longValue());
                return;
            }
        }
        zzuaVar.m();
    }

    public final synchronized void f0(View view) {
        if (this.f14745g.containsKey(view)) {
            this.f14745g.get(view).e(this);
            this.f14745g.remove(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzue
    public final synchronized void r0(final zzud zzudVar) {
        T(new zzbtu(zzudVar) { // from class: com.google.android.gms.internal.ads.af
            private final zzud a;

            {
                this.a = zzudVar;
            }

            @Override // com.google.android.gms.internal.ads.zzbtu
            public final void a(Object obj) {
                ((zzue) obj).r0(this.a);
            }
        });
    }
}
