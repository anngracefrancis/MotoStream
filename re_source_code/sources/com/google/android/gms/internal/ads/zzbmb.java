package com.google.android.gms.internal.ads;

import cm.aptoide.pt.database.room.RoomNotification;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class zzbmb implements zzbls {
    private final zzaxb a;

    public zzbmb(zzaxb zzaxbVar) {
        this.a = zzaxbVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbls
    public final void a(Map<String, String> map) {
        String str = map.get(RoomNotification.KEY);
        String str2 = map.get("value");
        if ("auto_collect_location".equals(str)) {
            this.a.n(Boolean.parseBoolean(str2));
        }
    }
}
