package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.o.l;
import com.google.firebase.v.a.b.a;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.crashlytics.h.f, reason: from Kotlin metadata */
/* JADX INFO: compiled from: CrashlyticsRemoteConfigListener.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/google/firebase/crashlytics/internal/CrashlyticsRemoteConfigListener;", "Lcom/google/firebase/remoteconfig/interop/rollouts/RolloutsStateSubscriber;", "userMetadata", "Lcom/google/firebase/crashlytics/internal/metadata/UserMetadata;", "(Lcom/google/firebase/crashlytics/internal/metadata/UserMetadata;)V", "onRolloutsStateChanged", HttpUrl.FRAGMENT_ENCODE_SET, "rolloutsState", "Lcom/google/firebase/remoteconfig/interop/rollouts/RolloutsState;", "com.google.firebase-firebase-crashlytics"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CrashlyticsRemoteConfigListener implements a {
    private final l a;

    public CrashlyticsRemoteConfigListener(l lVar) {
        m.f(lVar, "userMetadata");
        this.a = lVar;
    }
}
