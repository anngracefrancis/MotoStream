package com.airbnb.lottie.r;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import com.airbnb.lottie.g;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: ImageAssetManager.java */
/* JADX INFO: loaded from: classes.dex */
public class b {
    private static final Object a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f8682b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private com.airbnb.lottie.b f8684d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final Map<String, g> f8685e;

    public b(Drawable.Callback callback, String str, com.airbnb.lottie.b bVar, Map<String, g> map) {
        this.f8683c = str;
        if (!TextUtils.isEmpty(str)) {
            String str2 = this.f8683c;
            if (str2.charAt(str2.length() - 1) != '/') {
                this.f8683c += '/';
            }
        }
        if (callback instanceof View) {
            this.f8682b = ((View) callback).getContext();
            this.f8685e = map;
            e(bVar);
        } else {
            Log.w("LOTTIE", "LottieDrawable must be inside of a view for images to work.");
            this.f8685e = new HashMap();
            this.f8682b = null;
        }
    }

    private Bitmap c(String str, Bitmap bitmap) {
        synchronized (a) {
            this.f8685e.get(str).d(bitmap);
        }
        return bitmap;
    }

    public Bitmap a(String str) {
        g gVar = this.f8685e.get(str);
        if (gVar == null) {
            return null;
        }
        Bitmap bitmapA = gVar.a();
        if (bitmapA != null) {
            return bitmapA;
        }
        com.airbnb.lottie.b bVar = this.f8684d;
        if (bVar != null) {
            Bitmap bitmapA2 = bVar.a(gVar);
            if (bitmapA2 != null) {
                c(str, bitmapA2);
            }
            return bitmapA2;
        }
        String strB = gVar.b();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = true;
        options.inDensity = 160;
        if (strB.startsWith("data:") && strB.indexOf("base64,") > 0) {
            try {
                byte[] bArrDecode = Base64.decode(strB.substring(strB.indexOf(44) + 1), 0);
                return c(str, BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length, options));
            } catch (IllegalArgumentException e2) {
                Log.w("LOTTIE", "data URL did not have correct base64 format.", e2);
                return null;
            }
        }
        try {
            if (TextUtils.isEmpty(this.f8683c)) {
                throw new IllegalStateException("You must set an images folder before loading an image. Set it with LottieComposition#setImagesFolder or LottieDrawable#setImagesFolder");
            }
            return c(str, BitmapFactory.decodeStream(this.f8682b.getAssets().open(this.f8683c + strB), null, options));
        } catch (IOException e3) {
            Log.w("LOTTIE", "Unable to open asset.", e3);
            return null;
        }
    }

    public boolean b(Context context) {
        return (context == null && this.f8682b == null) || this.f8682b.equals(context);
    }

    public void d() {
        synchronized (a) {
            Iterator<Map.Entry<String, g>> it = this.f8685e.entrySet().iterator();
            while (it.hasNext()) {
                g value = it.next().getValue();
                Bitmap bitmapA = value.a();
                if (bitmapA != null) {
                    bitmapA.recycle();
                    value.d(null);
                }
            }
        }
    }

    public void e(com.airbnb.lottie.b bVar) {
        this.f8684d = bVar;
    }
}
