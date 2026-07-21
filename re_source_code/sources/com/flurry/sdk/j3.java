package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public interface j3 {

    public enum a {
        DO_NOT_FLUSH("DO_NOT_FLUSH"),
        REASON_STICKY_SET_COMPLETE("Sticky set is complete"),
        REASON_APP_STATE_CHANGE("App State has changed"),
        REASON_SESSION_FINALIZE("Session Finalized"),
        REASON_APP_CRASH("App crashed"),
        REASON_FORCE_FLUSH("Force to Flush"),
        REASON_STARTUP("App Started"),
        REASON_PUSH_TOKEN_REFRESH("Push Token Refreshed"),
        REASON_DATA_DELETION("Delete Data");

        public final String p;

        a(String str) {
            this.p = str;
        }
    }

    void b(u6 u6Var);
}
