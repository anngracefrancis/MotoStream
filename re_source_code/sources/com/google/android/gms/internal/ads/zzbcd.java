package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.google.android.gms.ads.internal.zzk;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.HttpUrl;

/* JADX INFO: loaded from: classes2.dex */
@zzard
@TargetApi(14)
public final class zzbcd extends zzbco implements MediaPlayer.OnBufferingUpdateListener, MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, MediaPlayer.OnPreparedListener, MediaPlayer.OnVideoSizeChangedListener, TextureView.SurfaceTextureListener {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Map<Integer, String> f14341h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final zzbdg f14342i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f14343j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private int f14344k;
    private int l;
    private MediaPlayer m;
    private Uri n;
    private int o;
    private int p;
    private int q;
    private int r;
    private int s;
    private zzbdd t;
    private boolean u;
    private int v;
    private zzbcn w;

    static {
        HashMap map = new HashMap();
        f14341h = map;
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 17) {
            map.put(-1004, "MEDIA_ERROR_IO");
            map.put(-1007, "MEDIA_ERROR_MALFORMED");
            map.put(-1010, "MEDIA_ERROR_UNSUPPORTED");
            map.put(-110, "MEDIA_ERROR_TIMED_OUT");
            map.put(3, "MEDIA_INFO_VIDEO_RENDERING_START");
        }
        map.put(100, "MEDIA_ERROR_SERVER_DIED");
        map.put(1, "MEDIA_ERROR_UNKNOWN");
        map.put(1, "MEDIA_INFO_UNKNOWN");
        map.put(700, "MEDIA_INFO_VIDEO_TRACK_LAGGING");
        map.put(701, "MEDIA_INFO_BUFFERING_START");
        map.put(702, "MEDIA_INFO_BUFFERING_END");
        map.put(800, "MEDIA_INFO_BAD_INTERLEAVING");
        map.put(801, "MEDIA_INFO_NOT_SEEKABLE");
        map.put(802, "MEDIA_INFO_METADATA_UPDATE");
        if (i2 >= 19) {
            map.put(901, "MEDIA_INFO_UNSUPPORTED_SUBTITLE");
            map.put(902, "MEDIA_INFO_SUBTITLE_TIMED_OUT");
        }
    }

    public zzbcd(Context context, boolean z, boolean z2, zzbde zzbdeVar, zzbdg zzbdgVar) {
        super(context);
        this.f14344k = 0;
        this.l = 0;
        setSurfaceTextureListener(this);
        this.f14342i = zzbdgVar;
        this.u = z;
        this.f14343j = z2;
        zzbdgVar.b(this);
    }

    private final void t(boolean z) {
        zzawz.m("AdMediaPlayerView release");
        zzbdd zzbddVar = this.t;
        if (zzbddVar != null) {
            zzbddVar.j();
            this.t = null;
        }
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            mediaPlayer.reset();
            this.m.release();
            this.m = null;
            u(0);
            if (z) {
                this.l = 0;
                this.l = 0;
            }
        }
    }

    private final void u(int i2) {
        if (i2 == 3) {
            this.f14342i.e();
            this.f14346g.d();
        } else if (this.f14344k == 3) {
            this.f14342i.f();
            this.f14346g.e();
        }
        this.f14344k = i2;
    }

    private final void w(float f2) {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer == null) {
            zzbad.i("AdMediaPlayerView setMediaPlayerVolume() called before onPrepared().");
        } else {
            try {
                mediaPlayer.setVolume(f2, f2);
            } catch (IllegalStateException unused) {
            }
        }
    }

    private final void x() {
        zzawz.m("AdMediaPlayerView init MediaPlayer");
        SurfaceTexture surfaceTexture = getSurfaceTexture();
        if (this.n == null || surfaceTexture == null) {
            return;
        }
        t(false);
        try {
            zzk.zzlw();
            MediaPlayer mediaPlayer = new MediaPlayer();
            this.m = mediaPlayer;
            mediaPlayer.setOnBufferingUpdateListener(this);
            this.m.setOnCompletionListener(this);
            this.m.setOnErrorListener(this);
            this.m.setOnInfoListener(this);
            this.m.setOnPreparedListener(this);
            this.m.setOnVideoSizeChangedListener(this);
            this.q = 0;
            if (this.u) {
                zzbdd zzbddVar = new zzbdd(getContext());
                this.t = zzbddVar;
                zzbddVar.b(surfaceTexture, getWidth(), getHeight());
                this.t.start();
                SurfaceTexture surfaceTextureK = this.t.k();
                if (surfaceTextureK != null) {
                    surfaceTexture = surfaceTextureK;
                } else {
                    this.t.j();
                    this.t = null;
                }
            }
            this.m.setDataSource(getContext(), this.n);
            zzk.zzlx();
            this.m.setSurface(new Surface(surfaceTexture));
            this.m.setAudioStreamType(3);
            this.m.setScreenOnWhilePlaying(true);
            this.m.prepareAsync();
            u(1);
        } catch (IOException | IllegalArgumentException | IllegalStateException e2) {
            String strValueOf = String.valueOf(this.n);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 36);
            sb.append("Failed to initialize MediaPlayer at ");
            sb.append(strValueOf);
            zzbad.d(sb.toString(), e2);
            onError(this.m, 1, 0);
        }
    }

    private final void y() {
        if (this.f14343j && z() && this.m.getCurrentPosition() > 0 && this.l != 3) {
            zzawz.m("AdMediaPlayerView nudging MediaPlayer");
            w(0.0f);
            this.m.start();
            int currentPosition = this.m.getCurrentPosition();
            long jA = zzk.zzln().a();
            while (z() && this.m.getCurrentPosition() == currentPosition && zzk.zzln().a() - jA <= 250) {
            }
            this.m.pause();
            b();
        }
    }

    private final boolean z() {
        int i2;
        return (this.m == null || (i2 = this.f14344k) == -1 || i2 == 0 || i2 == 1) ? false : true;
    }

    @Override // com.google.android.gms.internal.ads.zzbco, com.google.android.gms.internal.ads.g8
    public final void b() {
        w(this.f14346g.a());
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void c() {
        zzawz.m("AdMediaPlayerView pause");
        if (z() && this.m.isPlaying()) {
            this.m.pause();
            u(4);
            zzaxi.a.post(new v7(this));
        }
        this.l = 4;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void d() {
        zzawz.m("AdMediaPlayerView play");
        if (z()) {
            this.m.start();
            u(3);
            this.f14345f.b();
            zzaxi.a.post(new u7(this));
        }
        this.l = 3;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getCurrentPosition() {
        if (z()) {
            return this.m.getCurrentPosition();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getDuration() {
        if (z()) {
            return this.m.getDuration();
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoHeight() {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoHeight();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final int getVideoWidth() {
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            return mediaPlayer.getVideoWidth();
        }
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void h(int i2) {
        StringBuilder sb = new StringBuilder(34);
        sb.append("AdMediaPlayerView seek ");
        sb.append(i2);
        zzawz.m(sb.toString());
        if (!z()) {
            this.v = i2;
        } else {
            this.m.seekTo(i2);
            this.v = 0;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void i() {
        zzawz.m("AdMediaPlayerView stop");
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.m.release();
            this.m = null;
            u(0);
            this.l = 0;
        }
        this.f14342i.a();
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void j(float f2, float f3) {
        zzbdd zzbddVar = this.t;
        if (zzbddVar != null) {
            zzbddVar.e(f2, f3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void k(zzbcn zzbcnVar) {
        this.w = zzbcnVar;
    }

    @Override // android.media.MediaPlayer.OnBufferingUpdateListener
    public final void onBufferingUpdate(MediaPlayer mediaPlayer, int i2) {
        this.q = i2;
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public final void onCompletion(MediaPlayer mediaPlayer) {
        zzawz.m("AdMediaPlayerView completion");
        u(5);
        this.l = 5;
        zzaxi.a.post(new p7(this));
    }

    @Override // android.media.MediaPlayer.OnErrorListener
    public final boolean onError(MediaPlayer mediaPlayer, int i2, int i3) {
        Map<Integer, String> map = f14341h;
        String str = map.get(Integer.valueOf(i2));
        String str2 = map.get(Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 38 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer error: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzbad.i(sb.toString());
        u(-1);
        this.l = -1;
        zzaxi.a.post(new q7(this, str, str2));
        return true;
    }

    @Override // android.media.MediaPlayer.OnInfoListener
    public final boolean onInfo(MediaPlayer mediaPlayer, int i2, int i3) {
        Map<Integer, String> map = f14341h;
        String str = map.get(Integer.valueOf(i2));
        String str2 = map.get(Integer.valueOf(i3));
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 37 + String.valueOf(str2).length());
        sb.append("AdMediaPlayerView MediaPlayer info: ");
        sb.append(str);
        sb.append(":");
        sb.append(str2);
        zzawz.m(sb.toString());
        return true;
    }

    @Override // android.view.View
    protected final void onMeasure(int i2, int i3) {
        int i4;
        int i5;
        int defaultSize = TextureView.getDefaultSize(this.o, i2);
        int defaultSize2 = TextureView.getDefaultSize(this.p, i3);
        if (this.o > 0 && this.p > 0 && this.t == null) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            int size2 = View.MeasureSpec.getSize(i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                int i6 = this.o;
                int i7 = i6 * size2;
                int i8 = this.p;
                if (i7 < size * i8) {
                    defaultSize = (i6 * size2) / i8;
                } else {
                    if (i6 * size2 > size * i8) {
                        defaultSize2 = (i8 * size) / i6;
                        defaultSize = size;
                    }
                    defaultSize = size;
                }
                defaultSize2 = size2;
            } else if (mode == 1073741824) {
                int i9 = (this.p * size) / this.o;
                if (mode2 != Integer.MIN_VALUE || i9 <= size2) {
                    defaultSize2 = i9;
                    defaultSize = size;
                }
                defaultSize = size;
                defaultSize2 = size2;
            } else {
                if (mode2 == 1073741824) {
                    i5 = (this.o * size2) / this.p;
                    if (mode == Integer.MIN_VALUE && i5 > size) {
                        defaultSize = size;
                    }
                    defaultSize2 = size2;
                } else {
                    int i10 = this.o;
                    int i11 = this.p;
                    if (mode2 != Integer.MIN_VALUE || i11 <= size2) {
                        i5 = i10;
                        size2 = i11;
                    } else {
                        i5 = (size2 * i10) / i11;
                    }
                    if (mode == Integer.MIN_VALUE && i5 > size) {
                        defaultSize2 = (i11 * size) / i10;
                        defaultSize = size;
                    }
                }
                defaultSize = i5;
                defaultSize2 = size2;
            }
        }
        setMeasuredDimension(defaultSize, defaultSize2);
        zzbdd zzbddVar = this.t;
        if (zzbddVar != null) {
            zzbddVar.i(defaultSize, defaultSize2);
        }
        if (Build.VERSION.SDK_INT == 16) {
            int i12 = this.r;
            if ((i12 > 0 && i12 != defaultSize) || ((i4 = this.s) > 0 && i4 != defaultSize2)) {
                y();
            }
            this.r = defaultSize;
            this.s = defaultSize2;
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public final void onPrepared(MediaPlayer mediaPlayer) {
        zzawz.m("AdMediaPlayerView prepared");
        u(2);
        this.f14342i.d();
        zzaxi.a.post(new o7(this));
        this.o = mediaPlayer.getVideoWidth();
        this.p = mediaPlayer.getVideoHeight();
        int i2 = this.v;
        if (i2 != 0) {
            h(i2);
        }
        y();
        int i3 = this.o;
        int i4 = this.p;
        StringBuilder sb = new StringBuilder(62);
        sb.append("AdMediaPlayerView stream dimensions: ");
        sb.append(i3);
        sb.append(" x ");
        sb.append(i4);
        zzbad.h(sb.toString());
        if (this.l == 3) {
            d();
        }
        b();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        zzawz.m("AdMediaPlayerView surface created");
        x();
        zzaxi.a.post(new r7(this));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        zzawz.m("AdMediaPlayerView surface destroyed");
        MediaPlayer mediaPlayer = this.m;
        if (mediaPlayer != null && this.v == 0) {
            this.v = mediaPlayer.getCurrentPosition();
        }
        zzbdd zzbddVar = this.t;
        if (zzbddVar != null) {
            zzbddVar.j();
        }
        zzaxi.a.post(new t7(this));
        t(true);
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
        zzawz.m("AdMediaPlayerView surface changed");
        boolean z = this.l == 3;
        boolean z2 = this.o == i2 && this.p == i3;
        if (this.m != null && z && z2) {
            int i4 = this.v;
            if (i4 != 0) {
                h(i4);
            }
            d();
        }
        zzbdd zzbddVar = this.t;
        if (zzbddVar != null) {
            zzbddVar.i(i2, i3);
        }
        zzaxi.a.post(new s7(this, i2, i3));
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public final void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        this.f14342i.c(this);
        this.f14345f.a(surfaceTexture, this.w);
    }

    @Override // android.media.MediaPlayer.OnVideoSizeChangedListener
    public final void onVideoSizeChanged(MediaPlayer mediaPlayer, int i2, int i3) {
        StringBuilder sb = new StringBuilder(57);
        sb.append("AdMediaPlayerView size changed: ");
        sb.append(i2);
        sb.append(" x ");
        sb.append(i3);
        zzawz.m(sb.toString());
        this.o = mediaPlayer.getVideoWidth();
        int videoHeight = mediaPlayer.getVideoHeight();
        this.p = videoHeight;
        if (this.o == 0 || videoHeight == 0) {
            return;
        }
        requestLayout();
    }

    @Override // android.view.View
    protected final void onWindowVisibilityChanged(final int i2) {
        StringBuilder sb = new StringBuilder(58);
        sb.append("AdMediaPlayerView window visibility changed to ");
        sb.append(i2);
        zzawz.m(sb.toString());
        zzaxi.a.post(new Runnable(this, i2) { // from class: com.google.android.gms.internal.ads.n7

            /* JADX INFO: renamed from: f, reason: collision with root package name */
            private final zzbcd f13026f;

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            private final int f13027g;

            {
                this.f13026f = this;
                this.f13027g = i2;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.f13026f.v(this.f13027g);
            }
        });
        super.onWindowVisibilityChanged(i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final String r() {
        String str = this.u ? " spherical" : HttpUrl.FRAGMENT_ENCODE_SET;
        return str.length() != 0 ? "MediaPlayer".concat(str) : new String("MediaPlayer");
    }

    @Override // com.google.android.gms.internal.ads.zzbco
    public final void setVideoPath(String str) {
        Uri uri = Uri.parse(str);
        zzvv zzvvVarZ = zzvv.z(uri);
        if (zzvvVarZ == null || zzvvVarZ.f16863f != null) {
            if (zzvvVarZ != null) {
                uri = Uri.parse(zzvvVarZ.f16863f);
            }
            this.n = uri;
            this.v = 0;
            x();
            requestLayout();
            invalidate();
        }
    }

    @Override // android.view.View
    public final String toString() {
        String name = zzbcd.class.getName();
        String hexString = Integer.toHexString(hashCode());
        StringBuilder sb = new StringBuilder(name.length() + 1 + String.valueOf(hexString).length());
        sb.append(name);
        sb.append("@");
        sb.append(hexString);
        return sb.toString();
    }

    final /* synthetic */ void v(int i2) {
        zzbcn zzbcnVar = this.w;
        if (zzbcnVar != null) {
            zzbcnVar.onWindowVisibilityChanged(i2);
        }
    }
}
