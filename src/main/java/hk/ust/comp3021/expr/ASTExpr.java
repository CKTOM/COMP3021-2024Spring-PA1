package hk.ust.comp3021.expr;

import hk.ust.comp3021.misc.*;
import hk.ust.comp3021.stmt.ASTStmt;
import hk.ust.comp3021.utils.*;

public abstract class ASTExpr extends ASTElement {
    enum ExprType {
        BoolOp, BinOp, UnaryOp, Compare, Call, Constant, Attribute,
        Subscript, Name, List, Tuple
    }

    protected ExprType exprType;

    public ASTExpr(XMLNode node) {
        super(node);
    }

    @Override
    public String getNodeType() {
        return this.exprType.name();
    }

    /**
     * Create ASTExpr from the XNL Node based on the tag name
     *
     * @param node: the XML Node from which to generate ASTExpr
     * @return: created ASTExpr
     *
     * You may need to remove the `return null` from the skeleton.
     */
    public static ASTExpr createASTExpr(XMLNode node) {
        // TODO: complete the definition of the method `createASTExpr`
        int index = 0;
        String Type = node.getTagName();
        for (ExprType the_ExprType : ExprType.values()) {
            if (Type.equals(the_ExprType.name())) {
                break;
            }
            index++;
        }
        switch (index) {
            case 0:
                return new BoolOpExpr(node);
            case 1:
                return new BinOpExpr(node);
            case 2:
                return new UnaryOpExpr(node);
            case 3:
                return new CompareExpr(node);
            case 4:
                return new CallExpr(node);
            case 5:
                return new ConstantExpr(node);
            case 6:
                return new AttributeExpr(node);
            case 7:
                return new SubscriptExpr(node);
            case 8:
                return new NameExpr(node);
            case 9:
                return new ListExpr(node);
            case 10:
                return new TupleExpr(node);
            default:
                System.out.println("Unknown expression type");
        }
        return null;
    }

    /**
     * Attention: You may need to define more methods to update or access the field of the class `User`
     * Feel free to define more method but remember not
     * (1) removing the fields or methods in our skeleton.
     * (2) changing the type signature of `public` methods
     * (3) changing the modifiers of the fields and methods, e.g., changing a modifier from "private" to "public"
     */
    public void yourMethod() {

    }
}
