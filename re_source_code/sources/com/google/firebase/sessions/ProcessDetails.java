package com.google.firebase.sessions;

import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.t, reason: from Kotlin metadata and from toString */
/* JADX INFO: compiled from: SessionEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0011\b\u0080\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0013\u001a\u00020\bHÆ\u0003J1\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, d2 = {"Lcom/google/firebase/sessions/ProcessDetails;", HttpUrl.FRAGMENT_ENCODE_SET, "processName", HttpUrl.FRAGMENT_ENCODE_SET, "pid", HttpUrl.FRAGMENT_ENCODE_SET, "importance", "isDefaultProcess", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;IIZ)V", "getImportance", "()I", "()Z", "getPid", "getProcessName", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "toString", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final /* data */ class ProcessDetails {

    /* JADX INFO: renamed from: a, reason: from toString */
    private final String processName;

    /* JADX INFO: renamed from: b, reason: collision with root package name and from toString */
    private final int pid;

    /* JADX INFO: renamed from: c, reason: collision with root package name and from toString */
    private final int importance;

    /* JADX INFO: renamed from: d, reason: collision with root package name and from toString */
    private final boolean isDefaultProcess;

    public ProcessDetails(String str, int i2, int i3, boolean z) {
        kotlin.jvm.internal.m.f(str, "processName");
        this.processName = str;
        this.pid = i2;
        this.importance = i3;
        this.isDefaultProcess = z;
    }

    /* JADX INFO: renamed from: a, reason: from getter */
    public final int getImportance() {
        return this.importance;
    }

    /* JADX INFO: renamed from: b, reason: from getter */
    public final int getPid() {
        return this.pid;
    }

    /* JADX INFO: renamed from: c, reason: from getter */
    public final String getProcessName() {
        return this.processName;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getIsDefaultProcess() {
        return this.isDefaultProcess;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ProcessDetails)) {
            return false;
        }
        ProcessDetails processDetails = (ProcessDetails) other;
        return kotlin.jvm.internal.m.a(this.processName, processDetails.processName) && this.pid == processDetails.pid && this.importance == processDetails.importance && this.isDefaultProcess == processDetails.isDefaultProcess;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v7, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    public int hashCode() {
        int iHashCode = ((((this.processName.hashCode() * 31) + this.pid) * 31) + this.importance) * 31;
        boolean z = this.isDefaultProcess;
        ?? r1 = z;
        if (z) {
            r1 = 1;
        }
        return iHashCode + r1;
    }

    public String toString() {
        return "ProcessDetails(processName=" + this.processName + ", pid=" + this.pid + ", importance=" + this.importance + ", isDefaultProcess=" + this.isDefaultProcess + ')';
    }
}
