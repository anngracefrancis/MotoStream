package cm.aptoide.aptoideviews.video;

import android.animation.LayoutTransition;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import cm.aptoide.aptoideviews.ExtensionsKt;
import cm.aptoide.aptoideviews.R;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.m;
import kotlin.u;
import okhttp3.HttpUrl;

/* JADX INFO: compiled from: YoutubePlayer.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B!\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0016\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\fJ\b\u0010\u0016\u001a\u00020\u0013H\u0002R\u0012\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcm/aptoide/aptoideviews/video/YoutubePlayer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", HttpUrl.FRAGMENT_ENCODE_SET, "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "currentEnableSubtitles", HttpUrl.FRAGMENT_ENCODE_SET, "Ljava/lang/Boolean;", "currentVideoId", HttpUrl.FRAGMENT_ENCODE_SET, "threadHandler", "Landroid/os/Handler;", "loadVideo", HttpUrl.FRAGMENT_ENCODE_SET, "videoId", "enableSubtitles", "setListeners", "aptoide-views_prodRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class YoutubePlayer extends FrameLayout {
    public Map<Integer, View> _$_findViewCache;
    private Boolean currentEnableSubtitles;
    private String currentVideoId;
    private final Handler threadHandler;

    /* JADX INFO: renamed from: cm.aptoide.aptoideviews.video.YoutubePlayer$setListeners$1, reason: invalid class name */
    /* JADX INFO: compiled from: YoutubePlayer.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass1 extends Lambda implements Function0<u> {
        AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: invoke$lambda-0, reason: not valid java name */
        public static final void m13invoke$lambda0(YoutubePlayer youtubePlayer) {
            m.f(youtubePlayer, "this$0");
            ((YoutubeWebViewPlayer) youtubePlayer._$_findCachedViewById(R.id.webview)).setVisibility(0);
            ((ProgressBar) youtubePlayer._$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
            ((TextView) youtubePlayer._$_findCachedViewById(R.id.status_text)).setVisibility(8);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ u invoke() {
            invoke2();
            return u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Handler handler = YoutubePlayer.this.threadHandler;
            final YoutubePlayer youtubePlayer = YoutubePlayer.this;
            handler.postDelayed(new Runnable() { // from class: cm.aptoide.aptoideviews.video.b
                @Override // java.lang.Runnable
                public final void run() {
                    YoutubePlayer.AnonymousClass1.m13invoke$lambda0(youtubePlayer);
                }
            }, 500L);
        }
    }

    /* JADX INFO: renamed from: cm.aptoide.aptoideviews.video.YoutubePlayer$setListeners$2, reason: invalid class name */
    /* JADX INFO: compiled from: YoutubePlayer.kt */
    @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", HttpUrl.FRAGMENT_ENCODE_SET, "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
    static final class AnonymousClass2 extends Lambda implements Function0<u> {
        AnonymousClass2() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ u invoke() {
            invoke2();
            return u.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ((TextView) YoutubePlayer.this._$_findCachedViewById(R.id.status_text)).setVisibility(0);
            ((YoutubeWebViewPlayer) YoutubePlayer.this._$_findCachedViewById(R.id.webview)).setVisibility(4);
            ((ProgressBar) YoutubePlayer.this._$_findCachedViewById(R.id.progress_bar)).setVisibility(8);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoutubePlayer(Context context) {
        this(context, null);
        m.f(context, "context");
    }

    private final void setListeners() {
        int i2 = R.id.webview;
        ((YoutubeWebViewPlayer) _$_findCachedViewById(i2)).setOnPageFinishedAction(new AnonymousClass1());
        ((YoutubeWebViewPlayer) _$_findCachedViewById(i2)).setOnErrorAction(new AnonymousClass2());
        ((TextView) _$_findCachedViewById(R.id.status_text)).setOnClickListener(new View.OnClickListener() { // from class: cm.aptoide.aptoideviews.video.a
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                YoutubePlayer.m12setListeners$lambda0(this.f3735f, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: setListeners$lambda-0, reason: not valid java name */
    public static final void m12setListeners$lambda0(YoutubePlayer youtubePlayer, View view) {
        m.f(youtubePlayer, "this$0");
        ((ProgressBar) youtubePlayer._$_findCachedViewById(R.id.progress_bar)).setVisibility(0);
        ((TextView) youtubePlayer._$_findCachedViewById(R.id.status_text)).setVisibility(8);
        ExtensionsKt.safeLet(youtubePlayer.currentVideoId, youtubePlayer.currentEnableSubtitles, new YoutubePlayer$setListeners$3$1(youtubePlayer));
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i2);
        if (viewFindViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), viewFindViewById);
        return viewFindViewById;
    }

    public final void loadVideo(String videoId, boolean enableSubtitles) {
        m.f(videoId, "videoId");
        this.currentVideoId = videoId;
        this.currentEnableSubtitles = Boolean.valueOf(enableSubtitles);
        ((YoutubeWebViewPlayer) _$_findCachedViewById(R.id.webview)).loadVideo(videoId, enableSubtitles);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public YoutubePlayer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        m.f(context, "context");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YoutubePlayer(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        m.f(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.threadHandler = new Handler();
        setLayoutTransition(new LayoutTransition());
        FrameLayout.inflate(context, R.layout.youtube_player, this);
        setListeners();
    }
}
