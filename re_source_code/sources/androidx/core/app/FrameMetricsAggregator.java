package androidx.core.app;

import android.app.Activity;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.SparseIntArray;
import android.view.FrameMetrics;
import android.view.Window;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes.dex */
public class FrameMetricsAggregator {
    private b a;

    private static class a extends b {
        private static HandlerThread a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static Handler f835b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f836c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        SparseIntArray[] f837d = new SparseIntArray[9];

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ArrayList<WeakReference<Activity>> f838e = new ArrayList<>();

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Window.OnFrameMetricsAvailableListener f839f = new WindowOnFrameMetricsAvailableListenerC0016a();

        /* JADX INFO: renamed from: androidx.core.app.FrameMetricsAggregator$a$a, reason: collision with other inner class name */
        class WindowOnFrameMetricsAvailableListenerC0016a implements Window.OnFrameMetricsAvailableListener {
            WindowOnFrameMetricsAvailableListenerC0016a() {
            }

            @Override // android.view.Window.OnFrameMetricsAvailableListener
            public void onFrameMetricsAvailable(Window window, FrameMetrics frameMetrics, int i2) {
                a aVar = a.this;
                if ((aVar.f836c & 1) != 0) {
                    aVar.f(aVar.f837d[0], frameMetrics.getMetric(8));
                }
                a aVar2 = a.this;
                if ((aVar2.f836c & 2) != 0) {
                    aVar2.f(aVar2.f837d[1], frameMetrics.getMetric(1));
                }
                a aVar3 = a.this;
                if ((aVar3.f836c & 4) != 0) {
                    aVar3.f(aVar3.f837d[2], frameMetrics.getMetric(3));
                }
                a aVar4 = a.this;
                if ((aVar4.f836c & 8) != 0) {
                    aVar4.f(aVar4.f837d[3], frameMetrics.getMetric(4));
                }
                a aVar5 = a.this;
                if ((aVar5.f836c & 16) != 0) {
                    aVar5.f(aVar5.f837d[4], frameMetrics.getMetric(5));
                }
                a aVar6 = a.this;
                if ((aVar6.f836c & 64) != 0) {
                    aVar6.f(aVar6.f837d[6], frameMetrics.getMetric(7));
                }
                a aVar7 = a.this;
                if ((aVar7.f836c & 32) != 0) {
                    aVar7.f(aVar7.f837d[5], frameMetrics.getMetric(6));
                }
                a aVar8 = a.this;
                if ((aVar8.f836c & 128) != 0) {
                    aVar8.f(aVar8.f837d[7], frameMetrics.getMetric(0));
                }
                a aVar9 = a.this;
                if ((aVar9.f836c & 256) != 0) {
                    aVar9.f(aVar9.f837d[8], frameMetrics.getMetric(2));
                }
            }
        }

        a(int i2) {
            this.f836c = i2;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public void a(Activity activity) {
            if (a == null) {
                HandlerThread handlerThread = new HandlerThread("FrameMetricsAggregator");
                a = handlerThread;
                handlerThread.start();
                f835b = new Handler(a.getLooper());
            }
            for (int i2 = 0; i2 <= 8; i2++) {
                SparseIntArray[] sparseIntArrayArr = this.f837d;
                if (sparseIntArrayArr[i2] == null && (this.f836c & (1 << i2)) != 0) {
                    sparseIntArrayArr[i2] = new SparseIntArray();
                }
            }
            activity.getWindow().addOnFrameMetricsAvailableListener(this.f839f, f835b);
            this.f838e.add(new WeakReference<>(activity));
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] b() {
            return this.f837d;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] c(Activity activity) {
            for (WeakReference<Activity> weakReference : this.f838e) {
                if (weakReference.get() == activity) {
                    this.f838e.remove(weakReference);
                    break;
                }
            }
            activity.getWindow().removeOnFrameMetricsAvailableListener(this.f839f);
            return this.f837d;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] d() {
            SparseIntArray[] sparseIntArrayArr = this.f837d;
            this.f837d = new SparseIntArray[9];
            return sparseIntArrayArr;
        }

        @Override // androidx.core.app.FrameMetricsAggregator.b
        public SparseIntArray[] e() {
            for (int size = this.f838e.size() - 1; size >= 0; size--) {
                WeakReference<Activity> weakReference = this.f838e.get(size);
                Activity activity = weakReference.get();
                if (weakReference.get() != null) {
                    activity.getWindow().removeOnFrameMetricsAvailableListener(this.f839f);
                    this.f838e.remove(size);
                }
            }
            return this.f837d;
        }

        void f(SparseIntArray sparseIntArray, long j2) {
            if (sparseIntArray != null) {
                int i2 = (int) ((500000 + j2) / 1000000);
                if (j2 >= 0) {
                    sparseIntArray.put(i2, sparseIntArray.get(i2) + 1);
                }
            }
        }
    }

    private static class b {
        b() {
        }

        public void a(Activity activity) {
        }

        public SparseIntArray[] b() {
            return null;
        }

        public SparseIntArray[] c(Activity activity) {
            return null;
        }

        public SparseIntArray[] d() {
            return null;
        }

        public SparseIntArray[] e() {
            return null;
        }
    }

    public FrameMetricsAggregator() {
        this(1);
    }

    public void a(Activity activity) {
        this.a.a(activity);
    }

    public SparseIntArray[] b() {
        return this.a.b();
    }

    public SparseIntArray[] c(Activity activity) {
        return this.a.c(activity);
    }

    public SparseIntArray[] d() {
        return this.a.d();
    }

    public SparseIntArray[] e() {
        return this.a.e();
    }

    public FrameMetricsAggregator(int i2) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.a = new a(i2);
        } else {
            this.a = new b();
        }
    }
}
