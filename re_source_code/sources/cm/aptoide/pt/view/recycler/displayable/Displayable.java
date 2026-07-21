package cm.aptoide.pt.view.recycler.displayable;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.WindowManager;
import cm.aptoide.pt.utils.AptoideUtils;
import cm.aptoide.pt.view.LifecycleSchim;
import cm.aptoide.pt.view.recycler.widget.WidgetFactory;

/* JADX INFO: loaded from: classes.dex */
public abstract class Displayable implements LifecycleSchim {
    private int defaultPerLineCount;
    private boolean fixedPerLineCount;
    private boolean isVisible = false;
    private rx.t.b subscriptions = new rx.t.b();

    public class Configs {
        private final int defaultPerLineCount;
        private final boolean fixedPerLineCount;

        public Configs(int i2, boolean z) {
            this.defaultPerLineCount = i2;
            this.fixedPerLineCount = z;
        }

        public int getDefaultPerLineCount() {
            return this.defaultPerLineCount;
        }

        public boolean isFixedPerLineCount() {
            return this.fixedPerLineCount;
        }
    }

    public Displayable() {
        Configs config = getConfig();
        this.fixedPerLineCount = config.isFixedPerLineCount();
        this.defaultPerLineCount = config.getDefaultPerLineCount();
    }

    protected abstract Configs getConfig();

    public int getDefaultPerLineCount() {
        return this.defaultPerLineCount;
    }

    public int getPerLineCount(WindowManager windowManager, Resources resources) {
        int defaultPerLineCount = isFixedPerLineCount() ? getDefaultPerLineCount() : (int) ((AptoideUtils.ScreenU.getScreenWidthInDip(windowManager, resources) / 360.0f) * getDefaultPerLineCount());
        if (defaultPerLineCount != 0) {
            return defaultPerLineCount;
        }
        return 1;
    }

    public int getSpanSize(WindowManager windowManager, Resources resources) {
        return WidgetFactory.getColumnSize(resources, windowManager) / getPerLineCount(windowManager, resources);
    }

    public rx.t.b getSubscriptions() {
        return this.subscriptions;
    }

    public abstract int getViewLayout();

    public boolean isFixedPerLineCount() {
        return this.fixedPerLineCount;
    }

    public boolean isVisible() {
        return this.isVisible;
    }

    @Override // cm.aptoide.pt.view.LifecycleSchim
    public void onDestroyView() {
    }

    @Override // cm.aptoide.pt.view.LifecycleSchim
    public void onPause() {
        this.isVisible = false;
    }

    @Override // cm.aptoide.pt.view.LifecycleSchim
    public void onResume() {
        this.isVisible = true;
    }

    @Override // cm.aptoide.pt.view.LifecycleSchim
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // cm.aptoide.pt.view.LifecycleSchim
    public void onViewCreated() {
    }

    @Override // cm.aptoide.pt.view.LifecycleSchim
    public void onViewStateRestored(Bundle bundle) {
    }

    public Displayable setFullRow() {
        this.defaultPerLineCount = 1;
        this.fixedPerLineCount = true;
        return this;
    }

    public void setVisible(boolean z) {
        this.isVisible = z;
    }
}
