package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import androidx.recyclerview.widget.RecyclerView;
import cm.aptoide.pt.file.CacheHelper;
import com.google.android.gms.ads.AdRequest;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import okhttp3.internal.http2.Http2;
import okhttp3.internal.http2.Http2Connection;

/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class zzpi {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final SparseIntArray f16583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final SparseIntArray f16584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Map<String, Integer> f16585f;
    private static final zzpd a = zzpd.g("OMX.google.raw.decoder");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Pattern f16581b = Pattern.compile("^\\D?(\\d+)$");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final HashMap<a, List<zzpd>> f16582c = new HashMap<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static int f16586g = -1;

    static final class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16587b;

        public a(String str, boolean z) {
            this.a = str;
            this.f16587b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.a, aVar.a) && this.f16587b == aVar.f16587b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f16587b ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16583d = sparseIntArray;
        sparseIntArray.put(66, 1);
        sparseIntArray.put(77, 2);
        sparseIntArray.put(88, 4);
        sparseIntArray.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f16584e = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        sparseIntArray2.put(11, 4);
        sparseIntArray2.put(12, 8);
        sparseIntArray2.put(13, 16);
        sparseIntArray2.put(20, 32);
        sparseIntArray2.put(21, 64);
        sparseIntArray2.put(22, 128);
        sparseIntArray2.put(30, 256);
        sparseIntArray2.put(31, AdRequest.MAX_CONTENT_URL_LENGTH);
        sparseIntArray2.put(32, 1024);
        sparseIntArray2.put(40, RecyclerView.l.FLAG_MOVED);
        sparseIntArray2.put(41, RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT);
        sparseIntArray2.put(42, 8192);
        sparseIntArray2.put(50, Http2.INITIAL_MAX_FRAME_SIZE);
        sparseIntArray2.put(51, 32768);
        sparseIntArray2.put(52, 65536);
        HashMap map = new HashMap();
        f16585f = map;
        map.put("L30", 1);
        map.put("L60", 4);
        map.put("L63", 16);
        map.put("L90", 64);
        map.put("L93", 256);
        map.put("L120", 1024);
        map.put("L123", Integer.valueOf(RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT));
        map.put("L150", Integer.valueOf(Http2.INITIAL_MAX_FRAME_SIZE));
        map.put("L153", 65536);
        map.put("L156", 262144);
        map.put("L180", Integer.valueOf(CacheHelper.VALUE_TO_CONVERT_MB_TO_BYTES));
        map.put("L183", 4194304);
        map.put("L186", Integer.valueOf(Http2Connection.OKHTTP_CLIENT_WINDOW_SIZE));
        map.put("H30", 2);
        map.put("H60", 8);
        map.put("H63", 32);
        map.put("H90", 128);
        map.put("H93", Integer.valueOf(AdRequest.MAX_CONTENT_URL_LENGTH));
        map.put("H120", Integer.valueOf(RecyclerView.l.FLAG_MOVED));
        map.put("H123", 8192);
        map.put("H150", 32768);
        map.put("H153", 131072);
        map.put("H156", 524288);
        map.put("H180", 2097152);
        map.put("H183", 8388608);
        map.put("H186", 33554432);
    }

    private static Pair<Integer, Integer> a(String str, String[] strArr) {
        Integer numValueOf;
        Integer numValueOf2;
        if (strArr.length < 2) {
            String strValueOf = String.valueOf(str);
            Log.w("MediaCodecUtil", strValueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
            } else {
                if (strArr.length < 3) {
                    String strValueOf2 = String.valueOf(str);
                    Log.w("MediaCodecUtil", strValueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf2) : new String("Ignoring malformed AVC codec string: "));
                    return null;
                }
                Integer numValueOf3 = Integer.valueOf(Integer.parseInt(strArr[1]));
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[2]));
                numValueOf2 = numValueOf3;
            }
            Integer numValueOf4 = Integer.valueOf(f16583d.get(numValueOf2.intValue()));
            if (numValueOf4 == null) {
                String strValueOf3 = String.valueOf(numValueOf2);
                StringBuilder sb = new StringBuilder(strValueOf3.length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(strValueOf3);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer numValueOf5 = Integer.valueOf(f16584e.get(numValueOf.intValue()));
            if (numValueOf5 != null) {
                return new Pair<>(numValueOf4, numValueOf5);
            }
            String strValueOf4 = String.valueOf(numValueOf);
            StringBuilder sb2 = new StringBuilder(strValueOf4.length() + 19);
            sb2.append("Unknown AVC level: ");
            sb2.append(strValueOf4);
            Log.w("MediaCodecUtil", sb2.toString());
            return null;
        } catch (NumberFormatException unused) {
            String strValueOf5 = String.valueOf(str);
            Log.w("MediaCodecUtil", strValueOf5.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf5) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }

    /* JADX WARN: Code duplicated, block: B:103:0x017f  */
    /* JADX WARN: Code duplicated, block: B:123:0x01c8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x0129  */
    /* JADX WARN: Code duplicated, block: B:81:0x012f A[Catch: Exception -> 0x0278, TRY_ENTER, TryCatch #2 {Exception -> 0x0278, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:29:0x006c, B:33:0x0078, B:35:0x0080, B:40:0x0090, B:42:0x0098, B:44:0x00a2, B:46:0x00aa, B:48:0x00b2, B:50:0x00ba, B:52:0x00c2, B:54:0x00ca, B:56:0x00d2, B:58:0x00da, B:60:0x00e2, B:62:0x00ea, B:64:0x00f2, B:68:0x00fe, B:70:0x0106, B:72:0x0110, B:74:0x0118, B:76:0x0120, B:81:0x012f, B:83:0x0137, B:85:0x0141, B:87:0x014b, B:89:0x0153, B:91:0x0159, B:93:0x0161, B:97:0x016c, B:99:0x0174, B:105:0x0182, B:107:0x018a, B:147:0x0200, B:150:0x0208, B:152:0x020e, B:153:0x0232, B:154:0x0262), top: B:167:0x0004 }] */
    /* JADX WARN: Code duplicated, block: B:96:0x016a  */
    /* JADX WARN: Code duplicated, block: B:97:0x016c A[Catch: Exception -> 0x0278, TryCatch #2 {Exception -> 0x0278, blocks: (B:3:0x0004, B:5:0x0016, B:9:0x0028, B:12:0x0030, B:14:0x0036, B:16:0x003e, B:18:0x0046, B:20:0x004e, B:22:0x0056, B:24:0x005e, B:29:0x006c, B:33:0x0078, B:35:0x0080, B:40:0x0090, B:42:0x0098, B:44:0x00a2, B:46:0x00aa, B:48:0x00b2, B:50:0x00ba, B:52:0x00c2, B:54:0x00ca, B:56:0x00d2, B:58:0x00da, B:60:0x00e2, B:62:0x00ea, B:64:0x00f2, B:68:0x00fe, B:70:0x0106, B:72:0x0110, B:74:0x0118, B:76:0x0120, B:81:0x012f, B:83:0x0137, B:85:0x0141, B:87:0x014b, B:89:0x0153, B:91:0x0159, B:93:0x0161, B:97:0x016c, B:99:0x0174, B:105:0x0182, B:107:0x018a, B:147:0x0200, B:150:0x0208, B:152:0x020e, B:153:0x0232, B:154:0x0262), top: B:167:0x0004 }] */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzpk.<init>(java.lang.Throwable, com.google.android.gms.internal.ads.p20):void, class status: GENERATED_AND_UNLOADED
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
    private static java.util.List<com.google.android.gms.internal.ads.zzpd> b(com.google.android.gms.internal.ads.zzpi.a r17, com.google.android.gms.internal.ads.q20 r18) throws com.google.android.gms.internal.ads.zzpk {
        /*
            Method dump skipped, instruction units count: 642
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpi.b(com.google.android.gms.internal.ads.zzpi$a, com.google.android.gms.internal.ads.q20):java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:7:0x001b  */
    public static Pair<Integer, Integer> c(String str) {
        if (str == null) {
            return null;
        }
        String[] strArrSplit = str.split("\\.");
        byte b2 = 0;
        String str2 = strArrSplit[0];
        str2.hashCode();
        int i2 = 2;
        switch (str2.hashCode()) {
            case 3006243:
                if (!str2.equals("avc1")) {
                    b2 = -1;
                }
                break;
            case 3006244:
                if (!str2.equals("avc2")) {
                    b2 = -1;
                } else {
                    b2 = 1;
                }
                break;
            case 3199032:
                if (!str2.equals("hev1")) {
                    b2 = -1;
                } else {
                    b2 = 2;
                }
                break;
            case 3214780:
                if (!str2.equals("hvc1")) {
                    b2 = -1;
                } else {
                    b2 = 3;
                }
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 1:
                return a(str, strArrSplit);
            case 2:
            case 3:
                if (strArrSplit.length < 4) {
                    Log.w("MediaCodecUtil", str.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(str) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                Matcher matcher = f16581b.matcher(strArrSplit[1]);
                if (!matcher.matches()) {
                    Log.w("MediaCodecUtil", str.length() != 0 ? "Ignoring malformed HEVC codec string: ".concat(str) : new String("Ignoring malformed HEVC codec string: "));
                    return null;
                }
                String strGroup = matcher.group(1);
                if ("1".equals(strGroup)) {
                    i2 = 1;
                } else if (!"2".equals(strGroup)) {
                    String strValueOf = String.valueOf(strGroup);
                    Log.w("MediaCodecUtil", strValueOf.length() != 0 ? "Unknown HEVC profile string: ".concat(strValueOf) : new String("Unknown HEVC profile string: "));
                    return null;
                }
                Integer num = f16585f.get(strArrSplit[3]);
                if (num != null) {
                    return new Pair<>(Integer.valueOf(i2), num);
                }
                String strValueOf2 = String.valueOf(matcher.group(1));
                Log.w("MediaCodecUtil", strValueOf2.length() != 0 ? "Unknown HEVC level string: ".concat(strValueOf2) : new String("Unknown HEVC level string: "));
                return null;
            default:
                return null;
        }
    }

    public static zzpd d(String str, boolean z) throws zzpk {
        List<zzpd> listE = e(str, z);
        if (listE.isEmpty()) {
            return null;
        }
        return listE.get(0);
    }

    private static synchronized List<zzpd> e(String str, boolean z) throws zzpk {
        a aVar = new a(str, z);
        HashMap<a, List<zzpd>> map = f16582c;
        List<zzpd> list = map.get(aVar);
        if (list != null) {
            return list;
        }
        int i2 = zzsy.a;
        List<zzpd> listB = b(aVar, i2 >= 21 ? new s20(z) : new r20());
        if (z && listB.isEmpty() && 21 <= i2 && i2 <= 23) {
            listB = b(aVar, new r20());
            if (!listB.isEmpty()) {
                String str2 = listB.get(0).a;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
        }
        List<zzpd> listUnmodifiableList = Collections.unmodifiableList(listB);
        map.put(aVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static zzpd f() {
        return a;
    }

    public static int g() throws zzpk {
        if (f16586g == -1) {
            int iMax = 0;
            zzpd zzpdVarD = d("video/avc", false);
            if (zzpdVarD != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrJ = zzpdVarD.j();
                int length = codecProfileLevelArrJ.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArrJ[iMax].level;
                    int i3 = 9437184;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i3 = 101376;
                                break;
                            case 64:
                                i3 = 202752;
                                break;
                            case 128:
                            case 256:
                                i3 = 414720;
                                break;
                            case AdRequest.MAX_CONTENT_URL_LENGTH /* 512 */:
                                i3 = 921600;
                                break;
                            case 1024:
                                i3 = 1310720;
                                break;
                            case RecyclerView.l.FLAG_MOVED /* 2048 */:
                            case RecyclerView.l.FLAG_APPEARED_IN_PRE_LAYOUT /* 4096 */:
                                i3 = 2097152;
                                break;
                            case 8192:
                                i3 = 2228224;
                                break;
                            case Http2.INITIAL_MAX_FRAME_SIZE /* 16384 */:
                                i3 = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                break;
                            default:
                                i3 = -1;
                                break;
                        }
                    } else {
                        i3 = 25344;
                    }
                    iMax2 = Math.max(i3, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, zzsy.a >= 21 ? 345600 : 172800);
            }
            f16586g = iMax;
        }
        return f16586g;
    }
}
