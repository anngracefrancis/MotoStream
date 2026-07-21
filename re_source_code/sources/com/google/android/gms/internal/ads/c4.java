package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(21)
final class c4 {
    private static final Map<String, String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f12394b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<String> f12395c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzauq f12396d;

    static {
        HashMap map = new HashMap();
        if (PlatformVersion.h()) {
            map.put("android.webkit.resource.AUDIO_CAPTURE", "android.permission.RECORD_AUDIO");
            map.put("android.webkit.resource.VIDEO_CAPTURE", "android.permission.CAMERA");
        }
        a = map;
    }

    c4(Context context, List<String> list, zzauq zzauqVar) {
        this.f12394b = context;
        this.f12395c = list;
        this.f12396d = zzauqVar;
    }

    final List<String> a(String[] strArr) {
        boolean z;
        boolean z2;
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Iterator<String> it = this.f12395c.iterator();
            while (true) {
                z = true;
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
                String next = it.next();
                if (!next.equals(str)) {
                    if ((next.length() != 0 ? "android.webkit.resource.".concat(next) : new String("android.webkit.resource.")).equals(str)) {
                    }
                }
                z2 = true;
                break;
            }
            if (z2) {
                Map<String, String> map = a;
                if (map.containsKey(str)) {
                    zzk.zzlg();
                    if (!zzaxi.f0(this.f12394b, map.get(str))) {
                        z = false;
                    }
                }
                if (z) {
                    arrayList.add(str);
                } else {
                    this.f12396d.l(str);
                }
            } else {
                this.f12396d.k(str);
            }
        }
        return arrayList;
    }
}
