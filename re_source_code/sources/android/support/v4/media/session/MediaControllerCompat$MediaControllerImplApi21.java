package android.support.v4.media.session;

import android.os.Bundle;
import android.os.RemoteException;
import android.os.ResultReceiver;
import android.support.v4.media.MediaMetadataCompat;
import android.util.Log;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class MediaControllerCompat$MediaControllerImplApi21 {
    final Object a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<c> f27b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HashMap<c, a> f28c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final MediaSessionCompat.Token f29d;

    private static class ExtraBinderRequestResultReceiver extends ResultReceiver {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private WeakReference<MediaControllerCompat$MediaControllerImplApi21> f30f;

        @Override // android.os.ResultReceiver
        protected void onReceiveResult(int i2, Bundle bundle) {
            MediaControllerCompat$MediaControllerImplApi21 mediaControllerCompat$MediaControllerImplApi21 = this.f30f.get();
            if (mediaControllerCompat$MediaControllerImplApi21 == null || bundle == null) {
                return;
            }
            synchronized (mediaControllerCompat$MediaControllerImplApi21.a) {
                mediaControllerCompat$MediaControllerImplApi21.f29d.b(b.a.H(androidx.core.app.e.a(bundle, "android.support.v4.media.session.EXTRA_BINDER")));
                mediaControllerCompat$MediaControllerImplApi21.f29d.c(bundle.getBundle("android.support.v4.media.session.SESSION_TOKEN2_BUNDLE"));
                mediaControllerCompat$MediaControllerImplApi21.a();
            }
        }
    }

    private static class a extends c.BinderC0004c {
        a(c cVar) {
            super(cVar);
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void Z(Bundle bundle) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void b0(List<MediaSessionCompat.QueueItem> list) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void g7(ParcelableVolumeInfo parcelableVolumeInfo) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void j4(MediaMetadataCompat mediaMetadataCompat) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void q0(CharSequence charSequence) throws RemoteException {
            throw new AssertionError();
        }

        @Override // android.support.v4.media.session.c.BinderC0004c, android.support.v4.media.session.a
        public void r0() throws RemoteException {
            throw new AssertionError();
        }
    }

    void a() {
        if (this.f29d.a() == null) {
            return;
        }
        for (c cVar : this.f27b) {
            a aVar = new a(cVar);
            this.f28c.put(cVar, aVar);
            cVar.f56c = aVar;
            try {
                this.f29d.a().Z0(aVar);
                cVar.i(13, null, null);
            } catch (RemoteException e2) {
                Log.e("MediaControllerCompat", "Dead object in registerCallback.", e2);
            }
        }
        this.f27b.clear();
    }
}
