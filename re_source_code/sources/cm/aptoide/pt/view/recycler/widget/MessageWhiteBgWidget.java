package cm.aptoide.pt.view.recycler.widget;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import cm.aptoide.pt.R;
import cm.aptoide.pt.view.recycler.displayable.MessageWhiteBgDisplayable;

/* JADX INFO: loaded from: classes.dex */
public class MessageWhiteBgWidget extends Widget<MessageWhiteBgDisplayable> {
    private TextView message;

    public MessageWhiteBgWidget(View view) {
        super(view);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    protected void assignViews(View view) {
        this.message = (TextView) view.findViewById(R.id.message);
    }

    @Override // cm.aptoide.pt.view.recycler.widget.Widget
    public void bindView(MessageWhiteBgDisplayable messageWhiteBgDisplayable, int i2) {
        String message = messageWhiteBgDisplayable.getMessage();
        if (TextUtils.isEmpty(message)) {
            this.message.setVisibility(8);
        } else {
            this.message.setText(message);
        }
    }
}
