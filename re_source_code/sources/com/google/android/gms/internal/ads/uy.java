package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
final class uy implements o30 {
    private final Map<String, List<zzr<?>>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final zzd f13411b;

    uy(zzd zzdVar) {
        this.f13411b = zzdVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final synchronized boolean d(zzr<?> zzrVar) {
        String strM = zzrVar.M();
        if (!this.a.containsKey(strM)) {
            this.a.put(strM, null);
            zzrVar.D(this);
            if (zzag.f13871b) {
                zzag.a("new request, sending to network %s", strM);
            }
            return false;
        }
        List<zzr<?>> arrayList = this.a.get(strM);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
        }
        zzrVar.I("waiting-for-response");
        arrayList.add(zzrVar);
        this.a.put(strM, arrayList);
        if (zzag.f13871b) {
            zzag.a("Request for cacheKey=%s is in flight, putting on hold.", strM);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.o30
    public final synchronized void a(zzr<?> zzrVar) {
        try {
            String strM = zzrVar.M();
            List<zzr<?>> listRemove = this.a.remove(strM);
            if (listRemove != null && !listRemove.isEmpty()) {
                if (zzag.f13871b) {
                    zzag.c("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(listRemove.size()), strM);
                }
                zzr<?> zzrVarRemove = listRemove.remove(0);
                this.a.put(strM, listRemove);
                zzrVarRemove.D(this);
                try {
                    this.f13411b.f15812h.put(zzrVarRemove);
                } catch (InterruptedException e2) {
                    zzag.b("Couldn't add request to queue. %s", e2.toString());
                    Thread.currentThread().interrupt();
                    this.f13411b.b();
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // com.google.android.gms.internal.ads.o30
    public final void b(zzr<?> zzrVar, zzy<?> zzyVar) {
        List<zzr<?>> listRemove;
        zzc zzcVar = zzyVar.f16974b;
        if (zzcVar == null || zzcVar.a()) {
            a(zzrVar);
            return;
        }
        String strM = zzrVar.M();
        synchronized (this) {
            listRemove = this.a.remove(strM);
        }
        if (listRemove != null) {
            if (zzag.f13871b) {
                zzag.c("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(listRemove.size()), strM);
            }
            Iterator<zzr<?>> it = listRemove.iterator();
            while (it.hasNext()) {
                this.f13411b.f15814j.c(it.next(), zzyVar);
            }
        }
    }
}
