package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import java.util.HashMap;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzgx {
    private static final HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> a = new HashMap<>();

    static final class a {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f16264b;

        public a(String str, boolean z) {
            this.a = str;
            this.f16264b = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == a.class) {
                a aVar = (a) obj;
                if (TextUtils.equals(this.a, aVar.a) && this.f16264b == aVar.f16264b) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.a;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.f16264b ? 1231 : 1237);
        }
    }

    private static Pair<String, MediaCodecInfo.CodecCapabilities> a(a aVar, gz gzVar) throws zzgz {
        try {
            String str = aVar.a;
            int iC = gzVar.c();
            boolean zB = gzVar.b();
            boolean z = false;
            int i2 = 0;
            while (i2 < iC) {
                MediaCodecInfo mediaCodecInfoA = gzVar.a(i2);
                String name = mediaCodecInfoA.getName();
                if (!mediaCodecInfoA.isEncoder() && name.startsWith("OMX.") && (zB || !name.endsWith(".secure"))) {
                    String[] supportedTypes = mediaCodecInfoA.getSupportedTypes();
                    int i3 = 0;
                    while (i3 < supportedTypes.length) {
                        String str2 = supportedTypes[i3];
                        if (str2.equalsIgnoreCase(str)) {
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfoA.getCapabilitiesForType(str2);
                            boolean zD = gzVar.d(aVar.a, capabilitiesForType);
                            if (zB) {
                                a.put(aVar.f16264b == zD ? aVar : new a(str, zD), Pair.create(name, capabilitiesForType));
                            } else {
                                HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> map = a;
                                map.put(aVar.f16264b ? new a(str, z) : aVar, Pair.create(name, capabilitiesForType));
                                if (zD) {
                                    map.put(aVar.f16264b ? aVar : new a(str, true), Pair.create(name.concat(".secure"), capabilitiesForType));
                                }
                            }
                            HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> map2 = a;
                            if (map2.containsKey(aVar)) {
                                return map2.get(aVar);
                            }
                        }
                        i3++;
                        z = false;
                    }
                }
                i2++;
                z = false;
            }
            return null;
        } catch (Exception e2) {
            throw new zzgz(e2);
        }
    }

    public static zzgc b(String str, boolean z) throws zzgz {
        Pair<String, MediaCodecInfo.CodecCapabilities> pairC = c(str, z);
        if (pairC == null) {
            return null;
        }
        return new zzgc((String) pairC.first, zzkq.a >= 19 ? ((MediaCodecInfo.CodecCapabilities) pairC.second).isFeatureSupported("adaptive-playback") : false);
    }

    private static synchronized Pair<String, MediaCodecInfo.CodecCapabilities> c(String str, boolean z) throws zzgz {
        a aVar = new a(str, z);
        HashMap<a, Pair<String, MediaCodecInfo.CodecCapabilities>> map = a;
        if (map.containsKey(aVar)) {
            return map.get(aVar);
        }
        int i2 = zzkq.a;
        Pair<String, MediaCodecInfo.CodecCapabilities> pairA = a(aVar, i2 >= 21 ? new iz(z) : new hz());
        if (z && pairA == null && i2 >= 21 && (pairA = a(aVar, new hz())) != null) {
            String str2 = (String) pairA.first;
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
            sb.append("MediaCodecList API didn't list secure decoder for: ");
            sb.append(str);
            sb.append(". Assuming: ");
            sb.append(str2);
            Log.w("MediaCodecUtil", sb.toString());
        }
        return pairA;
    }
}
