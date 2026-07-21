package io.sentry;

import java.io.IOException;
import java.util.Locale;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: SentryItemType.java */
/* JADX INFO: loaded from: classes2.dex */
@ApiStatus.Internal
public enum r4 implements r2 {
    Session("session"),
    Event("event"),
    UserFeedback("user_report"),
    Attachment("attachment"),
    Transaction("transaction"),
    Profile("profile"),
    ClientReport("client_report"),
    ReplayEvent("replay_event"),
    ReplayRecording("replay_recording"),
    CheckIn("check_in"),
    Unknown("__unknown__");

    private final String itemType;

    /* JADX INFO: compiled from: SentryItemType.java */
    static final class a implements l2<r4> {
        a() {
        }

        @Override // io.sentry.l2
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public r4 a(n2 n2Var, w1 w1Var) throws Exception {
            return r4.valueOfLabel(n2Var.J().toLowerCase(Locale.ROOT));
        }
    }

    r4(String str) {
        this.itemType = str;
    }

    public static r4 resolve(Object obj) {
        if (obj instanceof l4) {
            return Event;
        }
        if (obj instanceof io.sentry.protocol.x) {
            return Transaction;
        }
        if (obj instanceof d5) {
            return Session;
        }
        return obj instanceof io.sentry.clientreport.b ? ClientReport : Attachment;
    }

    public static r4 valueOfLabel(String str) {
        for (r4 r4Var : values()) {
            if (r4Var.itemType.equals(str)) {
                return r4Var;
            }
        }
        return Unknown;
    }

    public String getItemType() {
        return this.itemType;
    }

    @Override // io.sentry.r2
    public void serialize(h3 h3Var, w1 w1Var) throws IOException {
        h3Var.b(this.itemType);
    }
}
