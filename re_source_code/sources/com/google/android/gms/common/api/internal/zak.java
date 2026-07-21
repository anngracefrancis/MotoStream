package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes2.dex */
public final class zak {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f11870d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final c.e.a<zai<?>, String> f11868b = new c.e.a<>();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final TaskCompletionSource<Map<zai<?>, String>> f11869c = new TaskCompletionSource<>();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f11871e = false;
    private final c.e.a<zai<?>, ConnectionResult> a = new c.e.a<>();

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
    public zak(Iterable<? extends GoogleApi<?>> iterable) {
        Iterator<? extends GoogleApi<?>> it = iterable.iterator();
        while (it.hasNext()) {
            this.a.put(it.next().l(), null);
        }
        this.f11870d = this.a.keySet().size();
    }

    public final Task<Map<zai<?>, String>> a() {
        return this.f11869c.a();
    }

    public final void b(zai<?> zaiVar, ConnectionResult connectionResult, String str) {
        this.a.put(zaiVar, connectionResult);
        this.f11868b.put(zaiVar, str);
        this.f11870d--;
        if (!connectionResult.e0()) {
            this.f11871e = true;
        }
        if (this.f11870d == 0) {
            if (!this.f11871e) {
                this.f11869c.c(this.f11868b);
            } else {
                this.f11869c.b(new AvailabilityException(this.a));
            }
        }
    }

    public final Set<zai<?>> c() {
        return this.a.keySet();
    }
}
