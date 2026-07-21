package com.google.firebase.messaging;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.firebase_messaging.zzg;
import com.google.android.gms.internal.firebase_messaging.zzh;
import com.google.android.gms.internal.firebase_messaging.zzo;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.firebase:firebase-messaging@@21.1.0 */
/* JADX INFO: loaded from: classes2.dex */
class d0 implements Closeable {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final URL f19811f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Task<Bitmap> f19812g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile InputStream f19813h;

    private d0(URL url) {
        this.f19811f = url;
    }

    private byte[] b() throws IOException {
        URLConnection uRLConnectionOpenConnection = this.f19811f.openConnection();
        if (uRLConnectionOpenConnection.getContentLength() > 1048576) {
            throw new IOException("Content-Length exceeds max size of 1048576");
        }
        InputStream inputStream = uRLConnectionOpenConnection.getInputStream();
        try {
            this.f19813h = inputStream;
            byte[] bArrA = zzg.a(zzg.b(inputStream, 1048577L));
            if (inputStream != null) {
                inputStream.close();
            }
            if (Log.isLoggable("FirebaseMessaging", 2)) {
                String strValueOf = String.valueOf(this.f19811f);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 34);
                sb.append("Downloaded ");
                sb.append(bArrA.length);
                sb.append(" bytes from ");
                sb.append(strValueOf);
                Log.v("FirebaseMessaging", sb.toString());
            }
            if (bArrA.length <= 1048576) {
                return bArrA;
            }
            throw new IOException("Image exceeds max size of 1048576");
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable th2) {
                    zzo.a(th, th2);
                }
            }
            throw th;
        }
    }

    public static d0 c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new d0(new URL(str));
        } catch (MalformedURLException unused) {
            String strValueOf = String.valueOf(str);
            Log.w("FirebaseMessaging", strValueOf.length() != 0 ? "Not downloading image, bad URL: ".concat(strValueOf) : new String("Not downloading image, bad URL: "));
            return null;
        }
    }

    public Bitmap a() throws IOException {
        String strValueOf = String.valueOf(this.f19811f);
        StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
        sb.append("Starting download of: ");
        sb.append(strValueOf);
        Log.i("FirebaseMessaging", sb.toString());
        byte[] bArrB = b();
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length);
        if (bitmapDecodeByteArray == null) {
            String strValueOf2 = String.valueOf(this.f19811f);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 24);
            sb2.append("Failed to decode image: ");
            sb2.append(strValueOf2);
            throw new IOException(sb2.toString());
        }
        if (Log.isLoggable("FirebaseMessaging", 3)) {
            String strValueOf3 = String.valueOf(this.f19811f);
            StringBuilder sb3 = new StringBuilder(strValueOf3.length() + 31);
            sb3.append("Successfully downloaded image: ");
            sb3.append(strValueOf3);
            Log.d("FirebaseMessaging", sb3.toString());
        }
        return bitmapDecodeByteArray;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        try {
            zzh.a(this.f19813h);
        } catch (NullPointerException e2) {
            Log.e("FirebaseMessaging", "Failed to close the image download stream.", e2);
        }
    }

    public Task<Bitmap> d() {
        return (Task) Preconditions.k(this.f19812g);
    }

    public void e(Executor executor) {
        this.f19812g = Tasks.c(executor, new Callable(this) { // from class: com.google.firebase.messaging.c0

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final d0 f19807f;

            {
                this.f19807f = this;
            }

            @Override // java.util.concurrent.Callable
            public Object call() {
                return this.f19807f.a();
            }
        });
    }
}
