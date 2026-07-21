package com.google.android.gms.common.api.internal;

import android.os.RemoteException;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Status;

/* JADX INFO: loaded from: classes2.dex */
public final class zaf extends m0<Void> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RegisterListenerMethod<Api.AnyClient, ?> f11854c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final UnregisterListenerMethod<Api.AnyClient, ?> f11855d;

    @Override // com.google.android.gms.common.api.internal.m0, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void b(Status status) {
        super.b(status);
    }

    @Override // com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void d(zaab zaabVar, boolean z) {
    }

    @Override // com.google.android.gms.common.api.internal.m0, com.google.android.gms.common.api.internal.zab
    public final /* bridge */ /* synthetic */ void e(RuntimeException runtimeException) {
        super.e(runtimeException);
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final Feature[] g(GoogleApiManager.zaa<?> zaaVar) {
        return this.f11854c.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean h(GoogleApiManager.zaa<?> zaaVar) {
        return this.f11854c.e();
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // com.google.android.gms.common.api.internal.m0
    public final void i(GoogleApiManager.zaa<?> zaaVar) throws RemoteException {
        this.f11854c.d(zaaVar.l(), this.f11771b);
        if (this.f11854c.b() != null) {
            zaaVar.u().put(this.f11854c.b(), new zabw(this.f11854c, this.f11855d));
        }
    }
}
