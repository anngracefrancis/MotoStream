package com.google.android.gms.internal.ads;

import android.app.AlertDialog;
import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.google.android.gms.ads.impl.R;
import com.google.android.gms.ads.internal.zzk;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
@zzard
public final class zzapu extends zzaqb {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Map<String, String> f14054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Context f14055d;

    public zzapu(zzbgz zzbgzVar, Map<String, String> map) {
        super(zzbgzVar, "storePicture");
        this.f14054c = map;
        this.f14055d = zzbgzVar.a();
    }

    public final void h() {
        if (this.f14055d == null) {
            e("Activity context is not available");
            return;
        }
        zzk.zzlg();
        if (!zzaxi.y(this.f14055d).d()) {
            e("Feature is not supported by the device.");
            return;
        }
        String str = this.f14054c.get("iurl");
        if (TextUtils.isEmpty(str)) {
            e("Image url cannot be empty.");
            return;
        }
        if (!URLUtil.isValidUrl(str)) {
            String strValueOf = String.valueOf(str);
            e(strValueOf.length() != 0 ? "Invalid image url: ".concat(strValueOf) : new String("Invalid image url: "));
            return;
        }
        String lastPathSegment = Uri.parse(str).getLastPathSegment();
        zzk.zzlg();
        if (!zzaxi.R(lastPathSegment)) {
            String strValueOf2 = String.valueOf(lastPathSegment);
            e(strValueOf2.length() != 0 ? "Image type not recognized: ".concat(strValueOf2) : new String("Image type not recognized: "));
            return;
        }
        Resources resourcesB = zzk.zzlk().b();
        zzk.zzlg();
        AlertDialog.Builder builderX = zzaxi.x(this.f14055d);
        builderX.setTitle(resourcesB != null ? resourcesB.getString(R.string.s1) : "Save image");
        builderX.setMessage(resourcesB != null ? resourcesB.getString(R.string.s2) : "Allow Ad to store image in Picture gallery?");
        builderX.setPositiveButton(resourcesB != null ? resourcesB.getString(R.string.s3) : "Accept", new k3(this, str, lastPathSegment));
        builderX.setNegativeButton(resourcesB != null ? resourcesB.getString(R.string.s4) : "Decline", new l3(this));
        builderX.create().show();
    }
}
