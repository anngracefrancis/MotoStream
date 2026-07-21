package com.google.firebase.sessions;

import com.google.firebase.encoders.json.NumberedEnum;
import kotlin.Metadata;
import okhttp3.HttpUrl;

/* JADX INFO: renamed from: com.google.firebase.sessions.p, reason: from Kotlin metadata */
/* JADX INFO: compiled from: SessionEvent.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u00012\u00020\u0002B\u000f\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lcom/google/firebase/sessions/EventType;", HttpUrl.FRAGMENT_ENCODE_SET, "Lcom/google/firebase/encoders/json/NumberedEnum;", "number", HttpUrl.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;II)V", "getNumber", "()I", "EVENT_TYPE_UNKNOWN", "SESSION_START", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 7, 1}, xi = 48)
public enum EventType implements NumberedEnum {
    EVENT_TYPE_UNKNOWN(0),
    SESSION_START(1);


    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final int f20077i;

    EventType(int i2) {
        this.f20077i = i2;
    }

    @Override // com.google.firebase.encoders.json.NumberedEnum
    /* JADX INFO: renamed from: f, reason: from getter */
    public int getF20077i() {
        return this.f20077i;
    }
}
