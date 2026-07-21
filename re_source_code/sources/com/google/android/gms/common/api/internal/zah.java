package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: loaded from: classes2.dex */
public final class zah extends m0<Boolean> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ListenerHolder.ListenerKey<?> f11859c;

    public zah(ListenerHolder.ListenerKey<?> listenerKey, TaskCompletionSource<Boolean> taskCompletionSource) {
        super(4, taskCompletionSource);
        this.f11859c = listenerKey;
    }

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
        zabw zabwVar = zaaVar.u().get(this.f11859c);
        if (zabwVar == null) {
            return null;
        }
        return zabwVar.a.c();
    }

    @Override // com.google.android.gms.common.api.internal.zac
    public final boolean h(GoogleApiManager.zaa<?> zaaVar) {
        zabw zabwVar = zaaVar.u().get(this.f11859c);
        return zabwVar != null && zabwVar.a.e();
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
    /*  JADX ERROR: JadxRuntimeException in pass: FinishTypeInference
        jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r0v4 boolean
        	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:236)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.lambda$visit$0(FinishTypeInference.java:27)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
        	at jadx.core.dex.visitors.typeinference.FinishTypeInference.visit(FinishTypeInference.java:22)
        */
    @Override // com.google.android.gms.common.api.internal.m0
    public final void i(com.google.android.gms.common.api.internal.GoogleApiManager.zaa<?> r4) throws android.os.RemoteException {
        /*
            r3 = this;
            java.util.Map r0 = r4.u()
            com.google.android.gms.common.api.internal.ListenerHolder$ListenerKey<?> r1 = r3.f11859c
            java.lang.Object r0 = r0.remove(r1)
            com.google.android.gms.common.api.internal.zabw r0 = (com.google.android.gms.common.api.internal.zabw) r0
            if (r0 == 0) goto L1f
            com.google.android.gms.common.api.internal.UnregisterListenerMethod<com.google.android.gms.common.api.Api$AnyClient, ?> r1 = r0.f11836b
            com.google.android.gms.common.api.Api$Client r4 = r4.l()
            com.google.android.gms.tasks.TaskCompletionSource<T> r2 = r3.f11771b
            r1.a(r4, r2)
            com.google.android.gms.common.api.internal.RegisterListenerMethod<com.google.android.gms.common.api.Api$AnyClient, ?> r4 = r0.a
            r4.a()
            return
        L1f:
            com.google.android.gms.tasks.TaskCompletionSource<T> r4 = r3.f11771b
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r4.e(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.internal.zah.i(com.google.android.gms.common.api.internal.GoogleApiManager$zaa):void");
    }
}
