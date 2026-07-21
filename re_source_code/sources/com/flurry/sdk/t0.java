package com.flurry.sdk;

/* JADX INFO: loaded from: classes2.dex */
public final class t0 extends p0 {
    public t0() {
        super("Analytics", "FlurryStreamingUpdateDataSender");
    }

    @Override // com.flurry.sdk.p0
    protected final void u(int i2, String str, String str2) {
        if (e7.a().l.r.get()) {
            c2.e(i2, str, str2, true);
            return;
        }
        p2.b("last_legacy_http_error_code", i2);
        p2.d("last_legacy_http_error_message", str);
        p2.d("last_legacy_http_report_identifier", str2);
    }

    @Override // com.flurry.sdk.p0
    protected final String z() {
        return "https://data.flurry.com/aap.do";
    }
}
