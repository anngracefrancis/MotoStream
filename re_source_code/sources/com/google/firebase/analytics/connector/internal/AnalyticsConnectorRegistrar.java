package com.google.firebase.analytics.connector.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.components.v;
import com.google.firebase.j;
import com.google.firebase.u.h;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@17.2.0 */
/* JADX INFO: loaded from: classes2.dex */
@Keep
@KeepForSdk
public class AnalyticsConnectorRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    @Keep
    @KeepForSdk
    @SuppressLint({"MissingPermission"})
    public List<n<?>> getComponents() {
        return Arrays.asList(n.c(com.google.firebase.analytics.a.a.class).b(v.k(j.class)).b(v.k(Context.class)).b(v.k(com.google.firebase.q.d.class)).f(a.a).e().d(), h.a("fire-analytics", "17.2.0"));
    }
}
