package androidx.lifecycle;

/* JADX INFO: loaded from: classes.dex */
class FullLifecycleObserverAdapter implements i {
    private final e a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i f1716b;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[g.b.values().length];
            a = iArr;
            try {
                iArr[g.b.ON_CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[g.b.ON_START.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[g.b.ON_RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[g.b.ON_PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[g.b.ON_STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[g.b.ON_DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[g.b.ON_ANY.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    FullLifecycleObserverAdapter(e eVar, i iVar) {
        this.a = eVar;
        this.f1716b = iVar;
    }

    @Override // androidx.lifecycle.i
    public void a(k kVar, g.b bVar) {
        switch (a.a[bVar.ordinal()]) {
            case 1:
                this.a.onCreate(kVar);
                break;
            case 2:
                this.a.onStart(kVar);
                break;
            case 3:
                this.a.onResume(kVar);
                break;
            case 4:
                this.a.onPause(kVar);
                break;
            case 5:
                this.a.onStop(kVar);
                break;
            case 6:
                this.a.onDestroy(kVar);
                break;
            case 7:
                throw new IllegalArgumentException("ON_ANY must not been send by anybody");
        }
        i iVar = this.f1716b;
        if (iVar != null) {
            iVar.a(kVar, bVar);
        }
    }
}
