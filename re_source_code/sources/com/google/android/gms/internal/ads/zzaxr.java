package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.provider.Settings;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.text.TextUtils;
import android.webkit.WebSettings;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.SharedPreferencesUtils;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(17)
public class zzaxr extends zzaxt {
    @Override // com.google.android.gms.internal.ads.zzaxo
    public final String a(Context context) {
        zzazm zzazmVarA = zzazm.a();
        if (TextUtils.isEmpty(zzazmVarA.f14301b)) {
            zzazmVarA.f14301b = ClientLibraryUtils.c() ? (String) zzazl.a(context, new c6(zzazmVarA, context)) : (String) zzazl.a(context, new d6(zzazmVarA, GooglePlayServicesUtilLight.getRemoteContext(context), context));
        }
        return zzazmVarA.f14301b;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int d(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "wifi_on", 0);
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final Drawable e(Context context, Bitmap bitmap, boolean z, float f2) {
        if (!z || f2 <= 0.0f || f2 > 25.0f) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
        try {
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, bitmap.getWidth(), bitmap.getHeight(), false);
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmapCreateScaledBitmap);
            RenderScript renderScriptCreate = RenderScript.create(context);
            ScriptIntrinsicBlur scriptIntrinsicBlurCreate = ScriptIntrinsicBlur.create(renderScriptCreate, Element.U8_4(renderScriptCreate));
            Allocation allocationCreateFromBitmap = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateScaledBitmap);
            Allocation allocationCreateFromBitmap2 = Allocation.createFromBitmap(renderScriptCreate, bitmapCreateBitmap);
            scriptIntrinsicBlurCreate.setRadius(f2);
            scriptIntrinsicBlurCreate.setInput(allocationCreateFromBitmap);
            scriptIntrinsicBlurCreate.forEach(allocationCreateFromBitmap2);
            allocationCreateFromBitmap2.copyTo(bitmapCreateBitmap);
            return new BitmapDrawable(context.getResources(), bitmapCreateBitmap);
        } catch (RuntimeException unused) {
            return new BitmapDrawable(context.getResources(), bitmap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaxt, com.google.android.gms.internal.ads.zzaxo
    public final boolean k(Context context, WebSettings webSettings) {
        super.k(context, webSettings);
        webSettings.setMediaPlaybackRequiresUserGesture(false);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final void m(Context context) {
        zzazm zzazmVarA = zzazm.a();
        zzawz.m("Updating user agent.");
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        if (!defaultUserAgent.equals(zzazmVarA.f14301b)) {
            Context remoteContext = GooglePlayServicesUtilLight.getRemoteContext(context);
            if (ClientLibraryUtils.c() || remoteContext == null) {
                SharedPreferences.Editor editorPutString = context.getSharedPreferences("admob_user_agent", 0).edit().putString("user_agent", WebSettings.getDefaultUserAgent(context));
                if (remoteContext == null) {
                    editorPutString.apply();
                } else {
                    SharedPreferencesUtils.a(context, editorPutString, "admob_user_agent");
                }
            }
            zzazmVarA.f14301b = defaultUserAgent;
        }
        zzawz.m("User agent is updated.");
    }

    @Override // com.google.android.gms.internal.ads.zzaxo
    public final int o(ContentResolver contentResolver) {
        return Settings.Global.getInt(contentResolver, "airplane_mode_on", 0);
    }
}
