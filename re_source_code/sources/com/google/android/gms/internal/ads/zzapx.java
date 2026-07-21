package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzapx {
    private final boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f14056b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f14057c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f14058d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final boolean f14059e;

    private zzapx(zzapz zzapzVar) {
        this.a = zzapzVar.a;
        this.f14056b = zzapzVar.f14060b;
        this.f14057c = zzapzVar.f14061c;
        this.f14058d = zzapzVar.f14062d;
        this.f14059e = zzapzVar.f14063e;
    }

    public final JSONObject a() {
        try {
            return new JSONObject().put("sms", this.a).put("tel", this.f14056b).put("calendar", this.f14057c).put("storePicture", this.f14058d).put("inlineVideo", this.f14059e);
        } catch (JSONException e2) {
            zzbad.c("Error occured while obtaining the MRAID capabilities.", e2);
            return null;
        }
    }
}
