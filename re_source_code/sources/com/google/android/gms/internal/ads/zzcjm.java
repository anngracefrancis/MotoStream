package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.SparseArray;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes2.dex */
public final class zzcjm {
    private static final SparseArray<zzwt.zzi.zzc> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f15299b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzbbh<Bundle> f15300c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final TelephonyManager f15301d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final zzcji f15302e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzcjc f15303f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private zzwx f15304g;

    static {
        SparseArray<zzwt.zzi.zzc> sparseArray = new SparseArray<>();
        a = sparseArray;
        sparseArray.put(NetworkInfo.DetailedState.CONNECTED.ordinal(), zzwt.zzi.zzc.CONNECTED);
        int iOrdinal = NetworkInfo.DetailedState.AUTHENTICATING.ordinal();
        zzwt.zzi.zzc zzcVar = zzwt.zzi.zzc.CONNECTING;
        sparseArray.put(iOrdinal, zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.CONNECTING.ordinal(), zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.OBTAINING_IPADDR.ordinal(), zzcVar);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTING.ordinal(), zzwt.zzi.zzc.DISCONNECTING);
        int iOrdinal2 = NetworkInfo.DetailedState.BLOCKED.ordinal();
        zzwt.zzi.zzc zzcVar2 = zzwt.zzi.zzc.DISCONNECTED;
        sparseArray.put(iOrdinal2, zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.DISCONNECTED.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.FAILED.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.IDLE.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.SCANNING.ordinal(), zzcVar2);
        sparseArray.put(NetworkInfo.DetailedState.SUSPENDED.ordinal(), zzwt.zzi.zzc.SUSPENDED);
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            sparseArray.put(NetworkInfo.DetailedState.CAPTIVE_PORTAL_CHECK.ordinal(), zzcVar);
        }
        if (i2 >= 16) {
            sparseArray.put(NetworkInfo.DetailedState.VERIFYING_POOR_LINK.ordinal(), zzcVar);
        }
    }

    zzcjm(Context context, zzbbh<Bundle> zzbbhVar, zzcji zzcjiVar, zzcjc zzcjcVar) {
        this.f15299b = context;
        this.f15300c = zzbbhVar;
        this.f15302e = zzcjiVar;
        this.f15303f = zzcjcVar;
        this.f15301d = (TelephonyManager) context.getSystemService("phone");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] d(boolean z, ArrayList<zzwt.zza.EnumC0187zza> arrayList, zzwt.zzg zzgVar, zzwt.zzi.zzc zzcVar) {
        return ((zzwt.zzi.zza) ((zzdob) zzwt.zzi.zza.W().w(arrayList).G(e(zzk.zzli().o(this.f15299b.getContentResolver()) != 0)).H(zzk.zzli().h(this.f15299b, this.f15301d)).C(this.f15302e.b()).D(this.f15302e.d()).A(this.f15302e.a()).v(zzcVar).u(zzgVar).I(this.f15304g).E(e(z)).B(zzk.zzln().a()).F(e(zzk.zzli().d(this.f15299b.getContentResolver()) != 0)).p0())).g();
    }

    private static zzwx e(boolean z) {
        return z ? zzwx.ENUM_TRUE : zzwx.ENUM_FALSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzwt.zzg i(Bundle bundle) {
        zzwt.zzg.zzb zzbVar;
        zzwt.zzg.zza zzaVarB = zzwt.zzg.B();
        int i2 = bundle.getInt("cnt", -2);
        int i3 = bundle.getInt("gnt", 0);
        if (i2 == -1) {
            this.f15304g = zzwx.ENUM_TRUE;
        } else {
            this.f15304g = zzwx.ENUM_FALSE;
            if (i2 == 0) {
                zzaVarB.v(zzwt.zzg.zzc.CELL);
            } else if (i2 != 1) {
                zzaVarB.v(zzwt.zzg.zzc.NETWORKTYPE_UNSPECIFIED);
            } else {
                zzaVarB.v(zzwt.zzg.zzc.WIFI);
            }
            switch (i3) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                case 16:
                    zzbVar = zzwt.zzg.zzb.TWO_G;
                    break;
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                case 17:
                    zzbVar = zzwt.zzg.zzb.THREE_G;
                    break;
                case 13:
                    zzbVar = zzwt.zzg.zzb.LTE;
                    break;
                default:
                    zzbVar = zzwt.zzg.zzb.CELLULAR_NETWORK_TYPE_UNSPECIFIED;
                    break;
            }
            zzaVarB.u(zzbVar);
        }
        return (zzwt.zzg) ((zzdob) zzaVarB.p0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static zzwt.zzi.zzc j(Bundle bundle) {
        return a.get(zzcxz.a(zzcxz.a(bundle, "device"), "network").getInt("active_network_state", -1), zzwt.zzi.zzc.UNSPECIFIED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:19:0x0050  */
    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:25:0x006b  */
    /* JADX WARN: Code duplicated, block: B:26:0x006d  */
    /* JADX WARN: Code duplicated, block: B:29:0x0076  */
    /* JADX WARN: Code duplicated, block: B:30:0x0078  */
    /* JADX WARN: Code duplicated, block: B:33:0x0081  */
    /* JADX WARN: Code duplicated, block: B:34:0x0083  */
    /* JADX WARN: Code duplicated, block: B:37:0x008c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    /* JADX WARN: Code duplicated, block: B:40:0x0093  */
    /* JADX WARN: Code duplicated, block: B:41:0x0096  */
    /* JADX WARN: Code duplicated, block: B:42:0x0099  */
    /* JADX WARN: Code duplicated, block: B:43:0x009c  */
    public static ArrayList<zzwt.zza.EnumC0187zza> k(Bundle bundle) {
        List<String> listEmptyList;
        List listAsList;
        ArrayList<zzwt.zza.EnumC0187zza> arrayList;
        zzwt.zza.EnumC0187zza enumC0187zza;
        Object obj = bundle.get("ad_types");
        if (!(obj instanceof List)) {
            if (obj instanceof String[]) {
                listAsList = Arrays.asList((String[]) obj);
            } else {
                listEmptyList = Collections.emptyList();
            }
            arrayList = new ArrayList<>();
            for (String str : listEmptyList) {
                str.hashCode();
                switch (str) {
                    case "banner":
                        enumC0187zza = zzwt.zza.EnumC0187zza.BANNER;
                        break;
                    case "native":
                        enumC0187zza = zzwt.zza.EnumC0187zza.NATIVE_APP_INSTALL;
                        break;
                    case "rewarded":
                        enumC0187zza = zzwt.zza.EnumC0187zza.REWARD_BASED_VIDEO_AD;
                        break;
                    case "interstitial":
                        enumC0187zza = zzwt.zza.EnumC0187zza.INTERSTITIAL;
                        break;
                    default:
                        enumC0187zza = zzwt.zza.EnumC0187zza.AD_FORMAT_TYPE_UNSPECIFIED;
                        break;
                }
                arrayList.add(enumC0187zza);
            }
            return arrayList;
        }
        listAsList = (List) obj;
        ArrayList arrayList2 = new ArrayList(listAsList.size());
        for (Object obj2 : listAsList) {
            if (obj2 instanceof String) {
                arrayList2.add((String) obj2);
            }
        }
        listEmptyList = Collections.unmodifiableList(arrayList2);
        arrayList = new ArrayList<>();
        while (r4.hasNext()) {
            str.hashCode();
            switch (str) {
                case -1396342996:
                    if (str.equals("banner")) {
                    }
                    break;
                case -1052618729:
                    if (str.equals("native")) {
                    }
                    break;
                case -239580146:
                    if (str.equals("rewarded")) {
                    }
                    break;
                case 604727084:
                    if (str.equals("interstitial")) {
                    }
                    break;
            }
            /*  JADX ERROR: Method code generation error
                java.lang.NullPointerException: Switch insn not found in header
                	at java.base/java.util.Objects.requireNonNull(Objects.java:246)
                	at jadx.core.codegen.RegionGen.makeSwitch(RegionGen.java:246)
                	at jadx.core.dex.regions.SwitchRegion.generate(SwitchRegion.java:90)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                	at jadx.core.codegen.RegionGen.makeLoop(RegionGen.java:226)
                	at jadx.core.dex.regions.loops.LoopRegion.generate(LoopRegion.java:173)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                */
            /*
                java.lang.String r0 = "ad_types"
                java.lang.Object r4 = r4.get(r0)
                boolean r0 = r4 instanceof java.util.List
                if (r0 == 0) goto Ld
                java.util.List r4 = (java.util.List) r4
                goto L17
            Ld:
                boolean r0 = r4 instanceof java.lang.String[]
                if (r0 == 0) goto L3d
                java.lang.String[] r4 = (java.lang.String[]) r4
                java.util.List r4 = java.util.Arrays.asList(r4)
            L17:
                java.util.ArrayList r0 = new java.util.ArrayList
                int r1 = r4.size()
                r0.<init>(r1)
                java.util.Iterator r4 = r4.iterator()
            L24:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L38
                java.lang.Object r1 = r4.next()
                boolean r2 = r1 instanceof java.lang.String
                if (r2 == 0) goto L24
                java.lang.String r1 = (java.lang.String) r1
                r0.add(r1)
                goto L24
            L38:
                java.util.List r4 = java.util.Collections.unmodifiableList(r0)
                goto L41
            L3d:
                java.util.List r4 = java.util.Collections.emptyList()
            L41:
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r4 = r4.iterator()
            L4a:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto La2
                java.lang.Object r1 = r4.next()
                java.lang.String r1 = (java.lang.String) r1
                r1.hashCode()
                r2 = -1
                int r3 = r1.hashCode()
                switch(r3) {
                    case -1396342996: goto L83;
                    case -1052618729: goto L78;
                    case -239580146: goto L6d;
                    case 604727084: goto L62;
                    default: goto L61;
                }
            L61:
                goto L8d
            L62:
                java.lang.String r3 = "interstitial"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L6b
                goto L8d
            L6b:
                r2 = 3
                goto L8d
            L6d:
                java.lang.String r3 = "rewarded"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L76
                goto L8d
            L76:
                r2 = 2
                goto L8d
            L78:
                java.lang.String r3 = "native"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L81
                goto L8d
            L81:
                r2 = 1
                goto L8d
            L83:
                java.lang.String r3 = "banner"
                boolean r1 = r1.equals(r3)
                if (r1 != 0) goto L8c
                goto L8d
            L8c:
                r2 = 0
            L8d:
                switch(r2) {
                    case 0: goto L9c;
                    case 1: goto L99;
                    case 2: goto L96;
                    case 3: goto L93;
                    default: goto L90;
                }
            L90:
                com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0187zza.AD_FORMAT_TYPE_UNSPECIFIED
                goto L9e
            L93:
                com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0187zza.INTERSTITIAL
                goto L9e
            L96:
                com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0187zza.REWARD_BASED_VIDEO_AD
                goto L9e
            L99:
                com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0187zza.NATIVE_APP_INSTALL
                goto L9e
            L9c:
                com.google.android.gms.internal.ads.zzwt$zza$zza r1 = com.google.android.gms.internal.ads.zzwt.zza.EnumC0187zza.BANNER
            L9e:
                r0.add(r1)
                goto L4a
            La2:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcjm.k(android.os.Bundle):java.util.ArrayList");
        }

        public final void g(boolean z) {
            zzbar.f(this.f15300c, new zj(this, z), zzbbm.f14331b);
        }
    }
