package com.trello.rxlifecycle.g;

import com.trello.rxlifecycle.OutsideLifecycleException;
import rx.m.e;

/* JADX INFO: compiled from: RxLifecycleAndroid.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final e<com.trello.rxlifecycle.g.a, com.trello.rxlifecycle.g.a> a = new a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final e<com.trello.rxlifecycle.g.b, com.trello.rxlifecycle.g.b> f20670b = new b();

    /* JADX INFO: compiled from: RxLifecycleAndroid.java */
    static class a implements e<com.trello.rxlifecycle.g.a, com.trello.rxlifecycle.g.a> {
        a() {
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.trello.rxlifecycle.g.a call(com.trello.rxlifecycle.g.a aVar) {
            switch (C0252c.a[aVar.ordinal()]) {
                case 1:
                    return com.trello.rxlifecycle.g.a.DESTROY;
                case 2:
                    return com.trello.rxlifecycle.g.a.STOP;
                case 3:
                    return com.trello.rxlifecycle.g.a.PAUSE;
                case 4:
                    return com.trello.rxlifecycle.g.a.STOP;
                case 5:
                    return com.trello.rxlifecycle.g.a.DESTROY;
                case 6:
                    throw new OutsideLifecycleException("Cannot bind to Activity lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + aVar + " not yet implemented");
            }
        }
    }

    /* JADX INFO: compiled from: RxLifecycleAndroid.java */
    static class b implements e<com.trello.rxlifecycle.g.b, com.trello.rxlifecycle.g.b> {
        b() {
        }

        @Override // rx.m.e
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public com.trello.rxlifecycle.g.b call(com.trello.rxlifecycle.g.b bVar) {
            switch (C0252c.f20671b[bVar.ordinal()]) {
                case 1:
                    return com.trello.rxlifecycle.g.b.DETACH;
                case 2:
                    return com.trello.rxlifecycle.g.b.DESTROY;
                case 3:
                    return com.trello.rxlifecycle.g.b.DESTROY_VIEW;
                case 4:
                    return com.trello.rxlifecycle.g.b.STOP;
                case 5:
                    return com.trello.rxlifecycle.g.b.PAUSE;
                case 6:
                    return com.trello.rxlifecycle.g.b.STOP;
                case 7:
                    return com.trello.rxlifecycle.g.b.DESTROY_VIEW;
                case 8:
                    return com.trello.rxlifecycle.g.b.DESTROY;
                case 9:
                    return com.trello.rxlifecycle.g.b.DETACH;
                case 10:
                    throw new OutsideLifecycleException("Cannot bind to Fragment lifecycle when outside of it.");
                default:
                    throw new UnsupportedOperationException("Binding to " + bVar + " not yet implemented");
            }
        }
    }

    /* JADX INFO: renamed from: com.trello.rxlifecycle.g.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: RxLifecycleAndroid.java */
    static /* synthetic */ class C0252c {
        static final /* synthetic */ int[] a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final /* synthetic */ int[] f20671b;

        static {
            int[] iArr = new int[com.trello.rxlifecycle.g.b.values().length];
            f20671b = iArr;
            try {
                iArr[com.trello.rxlifecycle.g.b.ATTACH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.CREATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.CREATE_VIEW.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.START.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.RESUME.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.PAUSE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.STOP.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.DESTROY_VIEW.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.DESTROY.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f20671b[com.trello.rxlifecycle.g.b.DETACH.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            int[] iArr2 = new int[com.trello.rxlifecycle.g.a.values().length];
            a = iArr2;
            try {
                iArr2[com.trello.rxlifecycle.g.a.CREATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[com.trello.rxlifecycle.g.a.START.ordinal()] = 2;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                a[com.trello.rxlifecycle.g.a.RESUME.ordinal()] = 3;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                a[com.trello.rxlifecycle.g.a.PAUSE.ordinal()] = 4;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                a[com.trello.rxlifecycle.g.a.STOP.ordinal()] = 5;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                a[com.trello.rxlifecycle.g.a.DESTROY.ordinal()] = 6;
            } catch (NoSuchFieldError unused16) {
            }
        }
    }

    public static <T> com.trello.rxlifecycle.b<T> a(rx.e<com.trello.rxlifecycle.g.a> eVar) {
        return com.trello.rxlifecycle.c.a(eVar, a);
    }

    public static <T> com.trello.rxlifecycle.b<T> b(rx.e<com.trello.rxlifecycle.g.b> eVar) {
        return com.trello.rxlifecycle.c.a(eVar, f20670b);
    }
}
