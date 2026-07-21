package com.google.firebase.ktx;

import androidx.annotation.Keep;
import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.n;
import com.google.firebase.u.h;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.t;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: Logging.kt */
/* JADX INFO: loaded from: classes2.dex */
@Keep
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/ktx/FirebaseCommonLegacyRegistrar;", "Lcom/google/firebase/components/ComponentRegistrar;", "()V", "getComponents", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/components/Component;", "com.google.firebase-firebase-common-ktx"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FirebaseCommonLegacyRegistrar implements ComponentRegistrar {
    @Override // com.google.firebase.components.ComponentRegistrar
    public List<n<?>> getComponents() {
        return t.e(h.a("fire-core-ktx", "20.4.2"));
    }
}
