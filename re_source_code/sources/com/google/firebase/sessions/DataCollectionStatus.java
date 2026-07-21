package com.google.firebase.sessions;

import cm.aptoide.pt.app.x0;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.m, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: SessionEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0080\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0006HÆ\u0003J'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/google/firebase/sessions/DataCollectionStatus;", HttpUrl.FRAGMENT_ENCODE_SET, "performance", "Lcom/google/firebase/sessions/DataCollectionState;", "crashlytics", "sessionSamplingRate", HttpUrl.FRAGMENT_ENCODE_SET, "(Lcom/google/firebase/sessions/DataCollectionState;Lcom/google/firebase/sessions/DataCollectionState;D)V", "getCrashlytics", "()Lcom/google/firebase/sessions/DataCollectionState;", "getPerformance", "getSessionSamplingRate", "()D", "component1", "component2", "component3", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", HttpUrl.FRAGMENT_ENCODE_SET, "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class DataCollectionStatus {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final DataCollectionState performance;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
    private final DataCollectionState crashlytics;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
    private final double sessionSamplingRate;

    public DataCollectionStatus() {
        this(null, null, 0.0d, 7, null);
    }

    public DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d2) {
        kotlin.jvm.internal.m.f(dataCollectionState, "performance");
        kotlin.jvm.internal.m.f(dataCollectionState2, "crashlytics");
        this.performance = dataCollectionState;
        this.crashlytics = dataCollectionState2;
        this.sessionSamplingRate = d2;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final DataCollectionState getCrashlytics() {
        return this.crashlytics;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final DataCollectionState getPerformance() {
        return this.performance;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final double getSessionSamplingRate() {
        return this.sessionSamplingRate;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DataCollectionStatus)) {
            return false;
        }
        DataCollectionStatus dataCollectionStatus = (DataCollectionStatus) other;
        return this.performance == dataCollectionStatus.performance && this.crashlytics == dataCollectionStatus.crashlytics && kotlin.jvm.internal.m.a(Double.valueOf(this.sessionSamplingRate), Double.valueOf(dataCollectionStatus.sessionSamplingRate));
    }

    public int hashCode() {
        return (((this.performance.hashCode() * 31) + this.crashlytics.hashCode()) * 31) + x0.a(this.sessionSamplingRate);
    }

    public String toString() {
        return "DataCollectionStatus(performance=" + this.performance + ", crashlytics=" + this.crashlytics + ", sessionSamplingRate=" + this.sessionSamplingRate + ')';
    }

    public /* synthetic */ DataCollectionStatus(DataCollectionState dataCollectionState, DataCollectionState dataCollectionState2, double d2, int i2, kotlin.jvm.internal.g gVar) {
        this((i2 & 1) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState, (i2 & 2) != 0 ? DataCollectionState.COLLECTION_SDK_NOT_INSTALLED : dataCollectionState2, (i2 & 4) != 0 ? 1.0d : d2);
    }
}
