package androidx.core.view;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: classes.dex */
public final class GestureDetectorCompat {
    private final a a;

    interface a {
        boolean a(MotionEvent motionEvent);
    }

    static class b implements a {
        private static final int a = ViewConfiguration.getTapTimeout();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final int f993b = ViewConfiguration.getDoubleTapTimeout();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f994c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f995d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f996e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private int f997f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private final Handler f998g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final GestureDetector.OnGestureListener f999h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        GestureDetector.OnDoubleTapListener f1000i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f1001j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        boolean f1002k;
        private boolean l;
        private boolean m;
        private boolean n;
        MotionEvent o;
        private MotionEvent p;
        private boolean q;
        private float r;
        private float s;
        private float t;
        private float u;
        private boolean v;
        private VelocityTracker w;

        b(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            if (handler != null) {
                this.f998g = new a(handler);
            } else {
                this.f998g = new a();
            }
            this.f999h = onGestureListener;
            if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
                g((GestureDetector.OnDoubleTapListener) onGestureListener);
            }
            e(context);
        }

        private void b() {
            this.f998g.removeMessages(1);
            this.f998g.removeMessages(2);
            this.f998g.removeMessages(3);
            this.w.recycle();
            this.w = null;
            this.q = false;
            this.f1001j = false;
            this.m = false;
            this.n = false;
            this.f1002k = false;
            if (this.l) {
                this.l = false;
            }
        }

        private void c() {
            this.f998g.removeMessages(1);
            this.f998g.removeMessages(2);
            this.f998g.removeMessages(3);
            this.q = false;
            this.m = false;
            this.n = false;
            this.f1002k = false;
            if (this.l) {
                this.l = false;
            }
        }

        private void e(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null");
            }
            if (this.f999h == null) {
                throw new IllegalArgumentException("OnGestureListener must not be null");
            }
            this.v = true;
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            int scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.f996e = viewConfiguration.getScaledMinimumFlingVelocity();
            this.f997f = viewConfiguration.getScaledMaximumFlingVelocity();
            this.f994c = scaledTouchSlop * scaledTouchSlop;
            this.f995d = scaledDoubleTapSlop * scaledDoubleTapSlop;
        }

        private boolean f(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
            if (!this.n || motionEvent3.getEventTime() - motionEvent2.getEventTime() > f993b) {
                return false;
            }
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            return (x * x) + (y * y) < this.f995d;
        }

        @Override // androidx.core.view.GestureDetectorCompat.a
        public boolean a(MotionEvent motionEvent) {
            boolean zOnDoubleTap;
            MotionEvent motionEvent2;
            boolean zOnFling;
            GestureDetector.OnDoubleTapListener onDoubleTapListener;
            int action = motionEvent.getAction();
            if (this.w == null) {
                this.w = VelocityTracker.obtain();
            }
            this.w.addMovement(motionEvent);
            int i2 = action & 255;
            boolean z = i2 == 6;
            int actionIndex = z ? motionEvent.getActionIndex() : -1;
            int pointerCount = motionEvent.getPointerCount();
            float x = 0.0f;
            float y = 0.0f;
            for (int i3 = 0; i3 < pointerCount; i3++) {
                if (actionIndex != i3) {
                    x += motionEvent.getX(i3);
                    y += motionEvent.getY(i3);
                }
            }
            float f2 = z ? pointerCount - 1 : pointerCount;
            float f3 = x / f2;
            float f4 = y / f2;
            if (i2 == 0) {
                if (this.f1000i == null) {
                    zOnDoubleTap = false;
                } else {
                    boolean zHasMessages = this.f998g.hasMessages(3);
                    if (zHasMessages) {
                        this.f998g.removeMessages(3);
                    }
                    MotionEvent motionEvent3 = this.o;
                    if (motionEvent3 == null || (motionEvent2 = this.p) == null || !zHasMessages || !f(motionEvent3, motionEvent2, motionEvent)) {
                        this.f998g.sendEmptyMessageDelayed(3, f993b);
                        zOnDoubleTap = false;
                    } else {
                        this.q = true;
                        zOnDoubleTap = this.f1000i.onDoubleTap(this.o) | false | this.f1000i.onDoubleTapEvent(motionEvent);
                    }
                }
                this.r = f3;
                this.t = f3;
                this.s = f4;
                this.u = f4;
                MotionEvent motionEvent4 = this.o;
                if (motionEvent4 != null) {
                    motionEvent4.recycle();
                }
                this.o = MotionEvent.obtain(motionEvent);
                this.m = true;
                this.n = true;
                this.f1001j = true;
                this.l = false;
                this.f1002k = false;
                if (this.v) {
                    this.f998g.removeMessages(2);
                    this.f998g.sendEmptyMessageAtTime(2, this.o.getDownTime() + ((long) a) + ((long) ViewConfiguration.getLongPressTimeout()));
                }
                this.f998g.sendEmptyMessageAtTime(1, this.o.getDownTime() + ((long) a));
                return zOnDoubleTap | this.f999h.onDown(motionEvent);
            }
            if (i2 == 1) {
                this.f1001j = false;
                MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                if (this.q) {
                    zOnFling = this.f1000i.onDoubleTapEvent(motionEvent) | false;
                } else {
                    if (this.l) {
                        this.f998g.removeMessages(3);
                        this.l = false;
                    } else if (this.m) {
                        boolean zOnSingleTapUp = this.f999h.onSingleTapUp(motionEvent);
                        if (this.f1002k && (onDoubleTapListener = this.f1000i) != null) {
                            onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                        }
                        zOnFling = zOnSingleTapUp;
                    } else {
                        VelocityTracker velocityTracker = this.w;
                        int pointerId = motionEvent.getPointerId(0);
                        velocityTracker.computeCurrentVelocity(1000, this.f997f);
                        float yVelocity = velocityTracker.getYVelocity(pointerId);
                        float xVelocity = velocityTracker.getXVelocity(pointerId);
                        if (Math.abs(yVelocity) > this.f996e || Math.abs(xVelocity) > this.f996e) {
                            zOnFling = this.f999h.onFling(this.o, motionEvent, xVelocity, yVelocity);
                        }
                    }
                    zOnFling = false;
                }
                MotionEvent motionEvent5 = this.p;
                if (motionEvent5 != null) {
                    motionEvent5.recycle();
                }
                this.p = motionEventObtain;
                VelocityTracker velocityTracker2 = this.w;
                if (velocityTracker2 != null) {
                    velocityTracker2.recycle();
                    this.w = null;
                }
                this.q = false;
                this.f1002k = false;
                this.f998g.removeMessages(1);
                this.f998g.removeMessages(2);
            } else {
                if (i2 != 2) {
                    if (i2 == 3) {
                        b();
                        return false;
                    }
                    if (i2 == 5) {
                        this.r = f3;
                        this.t = f3;
                        this.s = f4;
                        this.u = f4;
                        c();
                        return false;
                    }
                    if (i2 != 6) {
                        return false;
                    }
                    this.r = f3;
                    this.t = f3;
                    this.s = f4;
                    this.u = f4;
                    this.w.computeCurrentVelocity(1000, this.f997f);
                    int actionIndex2 = motionEvent.getActionIndex();
                    int pointerId2 = motionEvent.getPointerId(actionIndex2);
                    float xVelocity2 = this.w.getXVelocity(pointerId2);
                    float yVelocity2 = this.w.getYVelocity(pointerId2);
                    for (int i4 = 0; i4 < pointerCount; i4++) {
                        if (i4 != actionIndex2) {
                            int pointerId3 = motionEvent.getPointerId(i4);
                            if ((this.w.getXVelocity(pointerId3) * xVelocity2) + (this.w.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                                this.w.clear();
                                return false;
                            }
                        }
                    }
                    return false;
                }
                if (this.l) {
                    return false;
                }
                float f5 = this.r - f3;
                float f6 = this.s - f4;
                if (this.q) {
                    return false | this.f1000i.onDoubleTapEvent(motionEvent);
                }
                if (!this.m) {
                    if (Math.abs(f5) < 1.0f && Math.abs(f6) < 1.0f) {
                        return false;
                    }
                    boolean zOnScroll = this.f999h.onScroll(this.o, motionEvent, f5, f6);
                    this.r = f3;
                    this.s = f4;
                    return zOnScroll;
                }
                int i5 = (int) (f3 - this.t);
                int i6 = (int) (f4 - this.u);
                int i7 = (i5 * i5) + (i6 * i6);
                if (i7 > this.f994c) {
                    zOnFling = this.f999h.onScroll(this.o, motionEvent, f5, f6);
                    this.r = f3;
                    this.s = f4;
                    this.m = false;
                    this.f998g.removeMessages(3);
                    this.f998g.removeMessages(1);
                    this.f998g.removeMessages(2);
                } else {
                    zOnFling = false;
                }
                if (i7 > this.f994c) {
                    this.n = false;
                }
            }
            return zOnFling;
        }

        void d() {
            this.f998g.removeMessages(3);
            this.f1002k = false;
            this.l = true;
            this.f999h.onLongPress(this.o);
        }

        public void g(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
            this.f1000i = onDoubleTapListener;
        }

        private class a extends Handler {
            a() {
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1) {
                    b bVar = b.this;
                    bVar.f999h.onShowPress(bVar.o);
                    return;
                }
                if (i2 == 2) {
                    b.this.d();
                    return;
                }
                if (i2 != 3) {
                    throw new RuntimeException("Unknown message " + message);
                }
                b bVar2 = b.this;
                GestureDetector.OnDoubleTapListener onDoubleTapListener = bVar2.f1000i;
                if (onDoubleTapListener != null) {
                    if (bVar2.f1001j) {
                        bVar2.f1002k = true;
                    } else {
                        onDoubleTapListener.onSingleTapConfirmed(bVar2.o);
                    }
                }
            }

            a(Handler handler) {
                super(handler.getLooper());
            }
        }
    }

    static class c implements a {
        private final GestureDetector a;

        c(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
            this.a = new GestureDetector(context, onGestureListener, handler);
        }

        @Override // androidx.core.view.GestureDetectorCompat.a
        public boolean a(MotionEvent motionEvent) {
            return this.a.onTouchEvent(motionEvent);
        }
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean a(MotionEvent motionEvent) {
        return this.a.a(motionEvent);
    }

    public GestureDetectorCompat(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        if (Build.VERSION.SDK_INT > 17) {
            this.a = new c(context, onGestureListener, handler);
        } else {
            this.a = new b(context, onGestureListener, handler);
        }
    }
}
