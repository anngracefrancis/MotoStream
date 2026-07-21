package e.h.a.h0;

/* JADX INFO: compiled from: DownloadServiceConnectChangedEvent.java */
/* JADX INFO: loaded from: classes2.dex */
public class b extends c {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final a f21339c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Class<?> f21340d;

    /* JADX INFO: compiled from: DownloadServiceConnectChangedEvent.java */
    public enum a {
        connected,
        disconnected,
        lost
    }

    public b(a aVar, Class<?> cls) {
        super("event.service.connect.changed");
        this.f21339c = aVar;
        this.f21340d = cls;
    }

    public a b() {
        return this.f21339c;
    }
}
