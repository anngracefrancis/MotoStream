package com.google.android.gms.internal.ads;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.net.Uri;
import android.os.Environment;
import cm.aptoide.pt.download.DownloadAnalytics;
import com.google.android.gms.ads.internal.zzk;

/* JADX INFO: loaded from: classes2.dex */
final class k3 implements DialogInterface.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final /* synthetic */ String f12850f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final /* synthetic */ String f12851g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final /* synthetic */ zzapu f12852h;

    k3(zzapu zzapuVar, String str, String str2) {
        this.f12852h = zzapuVar;
        this.f12850f = str;
        this.f12851g = str2;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i2) {
        DownloadManager downloadManager = (DownloadManager) this.f12852h.f14055d.getSystemService(DownloadAnalytics.RAKAM_DOWNLOAD_EVENT);
        try {
            String str = this.f12850f;
            String str2 = this.f12851g;
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(str));
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_PICTURES, str2);
            zzk.zzli();
            request.allowScanningByMediaScanner();
            request.setNotificationVisibility(1);
            downloadManager.enqueue(request);
        } catch (IllegalStateException unused) {
            this.f12852h.e("Could not store picture.");
        }
    }
}
