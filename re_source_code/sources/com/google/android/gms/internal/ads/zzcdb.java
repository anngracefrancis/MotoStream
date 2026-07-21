package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcdb extends zzbpc {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Context f15087f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final zzbwz f15088g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final zzbup f15089h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbrp f15090i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzbpv f15091j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final zzatq f15092k;
    private final zzdan l;
    private boolean m = false;

    zzcdb(Context context, zzbwz zzbwzVar, zzbup zzbupVar, zzbrp zzbrpVar, zzbry zzbryVar, zzbpv zzbpvVar, zzcxm zzcxmVar, zzdan zzdanVar) {
        this.f15087f = context;
        this.f15088g = zzbwzVar;
        this.f15089h = zzbupVar;
        this.f15090i = zzbrpVar;
        this.f14663c = zzbryVar;
        this.f15091j = zzbpvVar;
        this.l = zzdanVar;
        this.f15092k = new zzaup(zzcxmVar.l);
    }

    public final boolean g() {
        return this.f15091j.a();
    }

    public final zzbry h() {
        return this.f14663c;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void i(boolean z, Activity activity) {
        Context context;
        if (((Boolean) zzyt.e().c(zzacu.L0)).booleanValue()) {
            zzk.zzlg();
            if (zzaxi.A(this.f15087f)) {
                zzbad.i("Rewarded ad can not be shown when app is not in foreground.");
                this.f15090i.R(3);
                if (((Boolean) zzyt.e().c(zzacu.M0)).booleanValue()) {
                    this.l.a(this.a.f15747b.f15744b.f15736b);
                    return;
                }
                return;
            }
        }
        if (this.m) {
            zzbad.i("The rewarded ad have been showed.");
            this.f15090i.R(1);
            return;
        }
        this.m = true;
        this.f15089h.y();
        if (activity == null) {
            context = activity;
            context = this.f15087f;
        }
        context = activity;
        this.f15088g.a(z, context);
    }

    public final zzatq j() {
        return this.f15092k;
    }
}
