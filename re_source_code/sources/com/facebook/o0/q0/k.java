package com.facebook.o0.q0;

import android.os.AsyncTask;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.URL;

/* JADX INFO: compiled from: FileDownloadTask.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class k extends AsyncTask<String, Void, Boolean> {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final File f10423b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f10424c;

    /* JADX INFO: compiled from: FileDownloadTask.kt */
    public interface a {
        void a(File file);
    }

    public k(String str, File file, a aVar) {
        kotlin.jvm.internal.m.f(str, "uriStr");
        kotlin.jvm.internal.m.f(file, "destFile");
        kotlin.jvm.internal.m.f(aVar, "onSuccess");
        this.a = str;
        this.f10423b = file;
        this.f10424c = aVar;
    }

    @Override // android.os.AsyncTask
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public Boolean doInBackground(String... strArr) {
        kotlin.jvm.internal.m.f(strArr, "args");
        try {
            URL url = new URL(this.a);
            int contentLength = url.openConnection().getContentLength();
            DataInputStream dataInputStream = new DataInputStream(url.openStream());
            byte[] bArr = new byte[contentLength];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(this.f10423b));
            dataOutputStream.write(bArr);
            dataOutputStream.flush();
            dataOutputStream.close();
            return Boolean.TRUE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    protected void b(boolean z) {
        if (z) {
            this.f10424c.a(this.f10423b);
        }
    }

    @Override // android.os.AsyncTask
    public /* bridge */ /* synthetic */ void onPostExecute(Boolean bool) {
        b(bool.booleanValue());
    }
}
