package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.utils.*;
import java.util.*;


public class CompareExpr extends ASTExpr {
    // Compare(expr left, cmpop* ops, expr* comparators)
    private ASTExpr left;
    private ArrayList<ASTEnumOp> ops = new ArrayList<>();
    private ArrayList<ASTExpr> comparators = new ArrayList<>();

    public CompareExpr(XMLNode node) {
        // TODO: complete the definition of the constructor. Define the class as the subclass of ASTExpr.
        super(node);
        this.exprType = ExprType.Compare;
        this.left = ASTExpr.createASTExpr(node.getChildByIdx(0));
        for (XMLNode child : node.getChildByIdx(1).getChildren())
        {
            this.ops.add(new ASTEnumOp(child));
        }
        for (XMLNode child : node.getChildByIdx(2).getChildren())
        {
            this.comparators.add(ASTExpr.createASTExpr(child));
        }

    }

    @Override
    public ArrayList<ASTElement> getChildren() {
        // TODO: complete the definition of the method `getChildren`
        ArrayList<ASTElement> return_child_list = new ArrayList<ASTElement>();
        return_child_list.add(this.left);
        return_child_list.addAll(this.comparators);
        return return_child_list;
    }

    @Override
    public int countChildren() {
        // TODO: complete the definition of the method `countChildren`
        int count = 1 + this.comparators.size();
        count += this.left.countChildren();
        for(ASTExpr child : this.comparators)
        {
            count += child.countChildren();
        }
        return count;
    }

    @Override
    public void printByPos(StringBuilder str) {
        // TODO: (Bonus) complete the definition of the method `printByPos`
    }

    /**
     * Attention: You may need to define more methods to update or access the field of the class `User`
     * Feel free to define more method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private" to "public"
     */
    public ArrayList<ASTEnumOp> returnop() {
        return this.ops;
    }

}
