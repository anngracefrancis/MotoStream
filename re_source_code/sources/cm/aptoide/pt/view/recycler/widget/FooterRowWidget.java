package cm.aptoide.pt.view.recycler.widget;

import android.view.View;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.recycler.displayable.FooterRowDisplayable;

/* JADX INFO: loaded from: classes.dex */
public class FooterRowWidget extends Widget<FooterRowDisplayable> {
    private TextView title;

    public FooterRowWidget(View view) {
        super(view);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.title = (TextView) view.findViewById(R.id.title);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(FooterRowDisplayable footerRowDisplayable, int i2) {
        this.title.setText(footerRowDisplayable.getPojo());
        this.title.setVisibility(0);
    }
}
