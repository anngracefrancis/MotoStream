package com.aptoide.aptoide_ab_testing.model;

import cm.aptoide.pt.DeepLinkIntentReceiver;
import cm.aptoide.pt.aab.a;
import kotlin.Metadata;
import kotlin.jvm.internal.m;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: FlagrJson.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0014"}, d2 = {"Lcom/aptoide/aptoide_ab_testing/model/Tag;", HttpUrl.FRAGMENT_ENCODE_SET, DeepLinkIntentReceiver.DeepLinksKeys.ID, HttpUrl.FRAGMENT_ENCODE_SET, "value", HttpUrl.FRAGMENT_ENCODE_SET, "(JLjava/lang/String;)V", "getId", "()J", "getValue", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", HttpUrl.FRAGMENT_ENCODE_SET, "other", "hashCode", HttpUrl.FRAGMENT_ENCODE_SET, "toString", "aptoide-ab-testing"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final /* data */ class Tag {
    private final long id;
    private final String value;

    public Tag(long j2, String str) {
        m.f(str, "value");
        this.id = j2;
        this.value = str;
    }

    public static /* synthetic */ Tag copy$default(Tag tag, long j2, String str, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            j2 = tag.id;
        }
        if ((i2 & 2) != 0) {
            str = tag.value;
        }
        return tag.copy(j2, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getId() {
        return this.id;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    public final Tag copy(long id, String value) {
        m.f(value, "value");
        return new Tag(id, value);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Tag)) {
            return false;
        }
        Tag tag = (Tag) other;
        return this.id == tag.id && m.a(this.value, tag.value);
    }

    public final long getId() {
        return this.id;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        return (a.a(this.id) * 31) + this.value.hashCode();
    }

    public String toString() {
        return "Tag(id=" + this.id + ", value=" + this.value + ')';
    }
}
