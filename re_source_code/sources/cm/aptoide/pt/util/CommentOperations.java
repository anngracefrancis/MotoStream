package cm.aptoide.pt.util;

import cm.aptoide.pt.comments.CommentNode;
import cm.aptoide.pt.dataprovider.model.v7.Comment;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/* JADX INFO: loaded from: classes.dex */
public class CommentOperations {
    public List<CommentNode> flattenByDepth(List<CommentNode> list) {
        LinkedList linkedList = new LinkedList();
        Stack stack = new Stack();
        stack.addAll(list);
        while (!stack.isEmpty()) {
            CommentNode commentNode = (CommentNode) stack.pop();
            linkedList.add(commentNode);
            if (commentNode.hasChild()) {
                for (CommentNode commentNode2 : commentNode.getChildComments()) {
                    commentNode2.setLevel(commentNode.getLevel() + 1);
                    stack.push(commentNode2);
                }
            }
        }
        return linkedList;
    }

    public List<CommentNode> transform(List<Comment> list) {
        c.e.d dVar = new c.e.d();
        for (Comment comment : list) {
            Comment.Parent parent = comment.getParent();
            if (parent != null) {
                CommentNode commentNode = (CommentNode) dVar.g(parent.getId());
                if (commentNode == null) {
                    commentNode = new CommentNode();
                }
                commentNode.addChild(new CommentNode(comment));
                dVar.b(parent.getId(), commentNode);
            } else {
                CommentNode commentNode2 = (CommentNode) dVar.g(comment.getId());
                if (commentNode2 == null) {
                    dVar.b(comment.getId(), new CommentNode(comment));
                } else {
                    commentNode2.setComment(comment);
                }
            }
        }
        ArrayList arrayList = new ArrayList(dVar.n());
        for (int i2 = 0; i2 < dVar.n(); i2++) {
            arrayList.add((CommentNode) dVar.o(i2));
        }
        return arrayList;
    }
}
