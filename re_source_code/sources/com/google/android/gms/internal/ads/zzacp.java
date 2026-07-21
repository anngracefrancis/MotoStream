package com.google.android.gms.internal.ads;

import android.content.SharedPreferences;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzacp {
    private final Collection<zzacj<?>> a = new ArrayList();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Collection<zzacj<String>> f13790b = new ArrayList();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Collection<zzacj<String>> f13791c = new ArrayList();

    public final void a(SharedPreferences.Editor editor, int i2, JSONObject jSONObject) {
        for (zzacj<?> zzacjVar : this.a) {
            if (zzacjVar.b() == 1) {
                zzacjVar.k(editor, zzacjVar.j(jSONObject));
            }
        }
        if (jSONObject != null) {
            editor.putString("flag_configuration", jSONObject.toString());
        } else {
            zzbad.g("Flag Json is null.");
        }
    }

    public final void b(zzacj zzacjVar) {
        this.a.add(zzacjVar);
    }

    public final void c(zzacj<String> zzacjVar) {
        this.f13790b.add(zzacjVar);
    }

    public final void d(zzacj<String> zzacjVar) {
        this.f13791c.add(zzacjVar);
    }

    public final List<String> e() {
        ArrayList arrayList = new ArrayList();
        Iterator<zzacj<String>> it = this.f13790b.iterator();
        while (it.hasNext()) {
            String str = (String) zzyt.e().c(it.next());
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }

    public final List<String> f() {
        List<String> listE = e();
        Iterator<zzacj<String>> it = this.f13791c.iterator();
        while (it.hasNext()) {
            String str = (String) zzyt.e().c(it.next());
            if (str != null) {
                listE.add(str);
            }
        }
        return listE;
    }
}
