package com.aptoide.aptoide_ab_testing.model;

import cm.aptoide.pt.aab.a;
import com.google.gson.l;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FlagrJson.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BY\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\n\u0010\n\u001a\u00060\u000bj\u0002`\f\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\t\u0010\"\u001a\u00020\u0003HÆ\u0003J\t\u0010#\u001a\u00020\u0011HÆ\u0003J\t\u0010$\u001a\u00020\u0005HÆ\u0003J\t\u0010%\u001a\u00020\u0003HÆ\u0003J\t\u0010&\u001a\u00020\u0003HÆ\u0003J\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0005HÆ\u0003J\r\u0010)\u001a\u00060\u000bj\u0002`\fHÆ\u0003J\t\u0010*\u001a\u00020\u000eHÆ\u0003J\t\u0010+\u001a\u00020\u0005HÆ\u0003Jq\u0010,\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00052\f\b\u0002\u0010\n\u001a\u00060\u000bj\u0002`\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u0011HÆ\u0001J\u0013\u0010-\u001a\u00020.2\b\u0010/\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00100\u001a\u000201HÖ\u0001J\t\u00102\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0010\u001a\u00020\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0018R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001aR\u0015\u0010\n\u001a\u00060\u000bj\u0002`\f¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0018R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001a¨\u00063"}, d2 = {"Lcom/aptoide/aptoide_ab_testing/model/PostEvaluationResponseJson;", HttpUrl.FRAGMENT_ENCODE_SET, "flagID", HttpUrl.FRAGMENT_ENCODE_SET, "flagKey", HttpUrl.FRAGMENT_ENCODE_SET, "flagSnapshotID", "segmentID", "variantID", "variantKey", "variantAttachment", "Lcom/google/gson/JsonObject;", "Lcom/aptoide/aptoide_ab_testing/model/VariantAttachment;", "evalContext", "Lcom/aptoide/aptoide_ab_testing/model/EvalContext;", "timestamp", "evalDebugLog", "Lcom/aptoide/aptoide_ab_testing/model/EvalDebugLog;", "(JLjava/lang/String;JJJLjava/lang/String;Lcom/google/gson/JsonObject;Lcom/aptoide/aptoide_ab_testing/model/EvalContext;Ljava/lang/String;Lcom/aptoide/aptoide_ab_testing/model/EvalDebugLog;)V", "getEvalContext", "()Lcom/aptoide/aptoide_ab_testing/model/EvalContext;", "getEvalDebugLog", "()Lcom/aptoide/aptoide_ab_testing/model/EvalDebugLog;", "getFlagID", "()J", "getFlagKey", "()Ljava/lang/String;", "getFlagSnapshotID", "getSegmentID", "getTimestamp", "getVariantAttachment", "()Lcom/google/gson/JsonObject;", "getVariantID", "getVariantKey", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "aptoide-ab-testing"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class PostEvaluationResponseJson {
    private final EvalContext evalContext;
    private final EvalDebugLog evalDebugLog;
    private final long flagID;
    private final String flagKey;
    private final long flagSnapshotID;
    private final long segmentID;
    private final String timestamp;
    private final l variantAttachment;
    private final long variantID;
    private final String variantKey;

    public PostEvaluationResponseJson(long j2, String str, long j3, long j4, long j5, String str2, l lVar, EvalContext evalContext, String str3, EvalDebugLog evalDebugLog) {
        m.f(str, "flagKey");
        m.f(str2, "variantKey");
        m.f(lVar, "variantAttachment");
        m.f(evalContext, "evalContext");
        m.f(str3, "timestamp");
        m.f(evalDebugLog, "evalDebugLog");
        this.flagID = j2;
        this.flagKey = str;
        this.flagSnapshotID = j3;
        this.segmentID = j4;
        this.variantID = j5;
        this.variantKey = str2;
        this.variantAttachment = lVar;
        this.evalContext = evalContext;
        this.timestamp = str3;
        this.evalDebugLog = evalDebugLog;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getFlagID() {
        return this.flagID;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final EvalDebugLog getEvalDebugLog() {
        return this.evalDebugLog;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getFlagKey() {
        return this.flagKey;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getFlagSnapshotID() {
        return this.flagSnapshotID;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final long getSegmentID() {
        return this.segmentID;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final long getVariantID() {
        return this.variantID;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getVariantKey() {
        return this.variantKey;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final l getVariantAttachment() {
        return this.variantAttachment;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final EvalContext getEvalContext() {
        return this.evalContext;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final String getTimestamp() {
        return this.timestamp;
    }

    public final PostEvaluationResponseJson copy(long j2, String str, long j3, long j4, long j5, String str2, l lVar, EvalContext evalContext, String str3, EvalDebugLog evalDebugLog) {
        m.f(str, "flagKey");
        m.f(str2, "variantKey");
        m.f(lVar, "variantAttachment");
        m.f(evalContext, "evalContext");
        m.f(str3, "timestamp");
        m.f(evalDebugLog, "evalDebugLog");
        return new PostEvaluationResponseJson(j2, str, j3, j4, j5, str2, lVar, evalContext, str3, evalDebugLog);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof PostEvaluationResponseJson)) {
            return false;
        }
        PostEvaluationResponseJson postEvaluationResponseJson = (PostEvaluationResponseJson) other;
        return this.flagID == postEvaluationResponseJson.flagID && m.a(this.flagKey, postEvaluationResponseJson.flagKey) && this.flagSnapshotID == postEvaluationResponseJson.flagSnapshotID && this.segmentID == postEvaluationResponseJson.segmentID && this.variantID == postEvaluationResponseJson.variantID && m.a(this.variantKey, postEvaluationResponseJson.variantKey) && m.a(this.variantAttachment, postEvaluationResponseJson.variantAttachment) && m.a(this.evalContext, postEvaluationResponseJson.evalContext) && m.a(this.timestamp, postEvaluationResponseJson.timestamp) && m.a(this.evalDebugLog, postEvaluationResponseJson.evalDebugLog);
    }

    public final EvalContext getEvalContext() {
        return this.evalContext;
    }

    public final EvalDebugLog getEvalDebugLog() {
        return this.evalDebugLog;
    }

    public final long getFlagID() {
        return this.flagID;
    }

    public final String getFlagKey() {
        return this.flagKey;
    }

    public final long getFlagSnapshotID() {
        return this.flagSnapshotID;
    }

    public final long getSegmentID() {
        return this.segmentID;
    }

    public final String getTimestamp() {
        return this.timestamp;
    }

    public final l getVariantAttachment() {
        return this.variantAttachment;
    }

    public final long getVariantID() {
        return this.variantID;
    }

    public final String getVariantKey() {
        return this.variantKey;
    }

    public int hashCode() {
        return (((((((((((((((((a.a(this.flagID) * 31) + this.flagKey.hashCode()) * 31) + a.a(this.flagSnapshotID)) * 31) + a.a(this.segmentID)) * 31) + a.a(this.variantID)) * 31) + this.variantKey.hashCode()) * 31) + this.variantAttachment.hashCode()) * 31) + this.evalContext.hashCode()) * 31) + this.timestamp.hashCode()) * 31) + this.evalDebugLog.hashCode();
    }

    public String toString() {
        return "PostEvaluationResponseJson(flagID=" + this.flagID + ", flagKey=" + this.flagKey + ", flagSnapshotID=" + this.flagSnapshotID + ", segmentID=" + this.segmentID + ", variantID=" + this.variantID + ", variantKey=" + this.variantKey + ", variantAttachment=" + this.variantAttachment + ", evalContext=" + this.evalContext + ", timestamp=" + this.timestamp + ", evalDebugLog=" + this.evalDebugLog + ')';
    }
}
