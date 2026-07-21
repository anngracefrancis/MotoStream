package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes2.dex */
public abstract class zzbjm implements zzblp {
    private static zzbjm a;

    public static zzbjm b(Context context, zzamp zzampVar, int i2) {
        zzbjm zzbjmVarO = o(context, i2);
        zzbjmVarO.h().c(zzampVar);
        return zzbjmVarO;
    }

    @Deprecated
    private static zzbjm c(zzbai zzbaiVar, Context context, zzbkw.zza zzaVar) {
        zzbjm zzbjmVar;
        synchronized (zzbjm.class) {
            if (a == null) {
                a = new zzbkn().c(new zzbjn(new zzbjn.zza().b(zzbaiVar).d(context))).a(new zzbkw(zzaVar)).b();
                zzacu.a(context);
                zzk.zzlk().k(context, zzbaiVar);
                zzk.zzlm().c(context);
                zzk.zzlg().u(context);
                zzk.zzlg().v(context);
                zzawx.a(context);
                zzk.zzlj().c(context);
                zzk.zzmb().a(context);
                if (((Boolean) zzyt.e().c(zzacu.a5)).booleanValue()) {
                    new zzcjr(context, zzbaiVar, new zzwj(new zzwo(context)), new zzcjc(new zzcja(context), a.f())).a();
                }
            }
            zzbjmVar = a;
        }
        return zzbjmVar;
    }

    @Deprecated
    public static zzbjm o(Context context, int i2) {
        synchronized (zzbjm.class) {
            zzbjm zzbjmVar = a;
            return zzbjmVar != null ? zzbjmVar : c(new zzbai(15000000, i2, true, false), context, new zzbkb());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzblp
    public final zzcvs a(zzarx zzarxVar) {
        return d(new zzcwx(zzarxVar));
    }

    protected abstract zzcvs d(zzcwx zzcwxVar);

    public abstract Executor e();

    public abstract zzbbl f();

    public abstract zzbtb g();

    public abstract zzclc h();

    public abstract zzbkz i();

    public abstract zzbod j();

    public abstract zzbwt k();

    public abstract zzbxp l();

    public abstract zzcdg m();

    public abstract zzcqp n();
}
