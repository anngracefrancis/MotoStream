package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzazr {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static List<MediaCodecInfo> f14306b;
    private static Map<String, List<Map<String, Object>>> a = new HashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f14307c = new Object();

    @TargetApi(21)
    private static Integer[] a(Range<Integer> range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }

    @TargetApi(16)
    public static List<Map<String, Object>> b(String str) {
        ArrayList arrayList;
        Object obj = f14307c;
        synchronized (obj) {
            if (a.containsKey(str)) {
                return a.get(str);
            }
            try {
                synchronized (obj) {
                    if (f14306b == null) {
                        int i2 = Build.VERSION.SDK_INT;
                        if (i2 >= 21) {
                            f14306b = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else if (i2 >= 16) {
                            int codecCount = MediaCodecList.getCodecCount();
                            f14306b = new ArrayList(codecCount);
                            for (int i3 = 0; i3 < codecCount; i3++) {
                                f14306b.add(MediaCodecList.getCodecInfoAt(i3));
                            }
                        } else {
                            f14306b = Collections.emptyList();
                        }
                    }
                    arrayList = new ArrayList();
                    for (MediaCodecInfo mediaCodecInfo : f14306b) {
                        if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                            HashMap map = new HashMap();
                            map.put("codecName", mediaCodecInfo.getName());
                            MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                            ArrayList arrayList2 = new ArrayList();
                            for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                                arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                            }
                            map.put("profileLevels", arrayList2);
                            int i4 = Build.VERSION.SDK_INT;
                            if (i4 >= 21) {
                                MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                                map.put("bitRatesBps", a(videoCapabilities.getBitrateRange()));
                                map.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                                map.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                                map.put("frameRates", a(videoCapabilities.getSupportedFrameRates()));
                                map.put("widths", a(videoCapabilities.getSupportedWidths()));
                                map.put("heights", a(videoCapabilities.getSupportedHeights()));
                            }
                            if (i4 >= 23) {
                                map.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                            }
                            arrayList.add(map);
                        }
                    }
                    a.put(str, arrayList);
                }
                return arrayList;
            } catch (LinkageError | RuntimeException e2) {
                HashMap map2 = new HashMap();
                map2.put("error", e2.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(map2);
                a.put(str, arrayList3);
                return arrayList3;
            }
        }
    }
}
