package cm.aptoide.pt.reactions.network;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class TopReactionsResponse {
    private My my;
    private List<ReactionTypeResponse> top;
    private int total;

    public static class My {
        private String type;
        private String uid;

        public String getType() {
            return this.type;
        }

        public String getUid() {
            return this.uid;
        }

        public void setType(String str) {
            this.type = str;
        }

        public void setUid(String str) {
            this.uid = str;
        }
    }

    public static class ReactionTypeResponse {
        private int total;
        private String type;

        public int getTotal() {
            return this.total;
        }

        public String getType() {
            return this.type;
        }

        public void setTotal(int i2) {
            this.total = i2;
        }

        public void setType(String str) {
            this.type = str;
        }
    }

    public My getMy() {
        return this.my;
    }

    public List<ReactionTypeResponse> getTop() {
        return this.top;
    }

    public int getTotal() {
        return this.total;
    }

    public void setMy(My my) {
        this.my = my;
    }

    public void setTop(List<ReactionTypeResponse> list) {
        this.top = list;
    }

    public void setTotal(int i2) {
        this.total = i2;
    }
}
