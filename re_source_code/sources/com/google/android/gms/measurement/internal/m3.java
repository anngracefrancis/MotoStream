package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
final class m3 implements Runnable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final URL f17860f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final byte[] f17861g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final j3 f17862h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final String f17863i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Map<String, String> f17864j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final /* synthetic */ zzex f17865k;

    public m3(zzex zzexVar, String str, URL url, byte[] bArr, Map<String, String> map, j3 j3Var) {
        this.f17865k = zzexVar;
        Preconditions.g(str);
        Preconditions.k(url);
        Preconditions.k(j3Var);
        this.f17860f = url;
        this.f17861g = bArr;
        this.f17862h = j3Var;
        this.f17863i = str;
        this.f17864j = map;
    }

    /* JADX WARN: Code duplicated, block: B:47:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:60:0x0122  */
    /* JADX WARN: Code duplicated, block: B:63:0x00cd A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x0108 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.measurement.internal.n3.<init>(java.lang.String, com.google.android.gms.measurement.internal.j3, int, java.lang.Throwable, byte[], java.util.Map, com.google.android.gms.measurement.internal.l3):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:309)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:224)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:93)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:27)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    @Override // java.lang.Runnable
    public final void run() throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 315
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.m3.run():void");
    }
}
